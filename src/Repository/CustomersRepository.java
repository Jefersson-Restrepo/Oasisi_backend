package Repository;

import Domain.Customer;
import Port.OutputPort;
import Config.DatabaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomersRepository implements OutputPort<Customer> {
    private final String jdbcUrl;

    public CustomersRepository() {
        this.jdbcUrl = DatabaseConfig.getJdbcUrl();
        initializeDatabase();
    }

    private Connection openConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el controlador JDBC de SQLite. Recarga el proyecto Maven.", e);
        }
        return DriverManager.getConnection(jdbcUrl);
    }

    private void initializeDatabase() {
        String sql = """
                CREATE TABLE IF NOT EXISTS customers (
                    id INTEGER PRIMARY KEY CHECK (id > 0),
                    name TEXT NOT NULL,
                    gender TEXT,
                    age INTEGER NOT NULL CHECK (age BETWEEN 1 AND 120),
                    phone TEXT NOT NULL,
                    address TEXT
                )
                """;
        try (Connection connection = openConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw databaseError("inicializar la base de datos de clientes", e);
        }
    }

    @Override
    public void create(Customer customer) {
        String sql = "INSERT INTO customers (id, name, gender, age, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            bindCustomer(statement, customer);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw databaseError("registrar el cliente", e);
        }
    }

    @Override
    public Customer selectById(int id) {
        String sql = "SELECT id, name, gender, age, phone, address FROM customers WHERE id = ?";
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet result = statement.executeQuery()) {
                return result.next() ? mapCustomer(result) : null;
            }
        } catch (SQLException e) {
            throw databaseError("buscar el cliente", e);
        }
    }

    @Override
    public List<Customer> selectAll() {
        String sql = "SELECT id, name, gender, age, phone, address FROM customers ORDER BY id";
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = openConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {
            while (result.next()) {
                customers.add(mapCustomer(result));
            }
            return customers;
        } catch (SQLException e) {
            throw databaseError("listar los clientes", e);
        }
    }

    @Override
    public boolean update(Customer customer) {
        String sql = "UPDATE customers SET name = ?, gender = ?, age = ?, phone = ?, address = ? WHERE id = ?";
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getGender());
            statement.setInt(3, customer.getAge());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getAddress());
            statement.setInt(6, customer.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw databaseError("actualizar el cliente", e);
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw databaseError("eliminar el cliente", e);
        }
    }

    private void bindCustomer(PreparedStatement statement, Customer customer) throws SQLException {
        statement.setInt(1, customer.getId());
        statement.setString(2, customer.getName());
        statement.setString(3, customer.getGender());
        statement.setInt(4, customer.getAge());
        statement.setString(5, customer.getPhone());
        statement.setString(6, customer.getAddress());
    }

    private Customer mapCustomer(ResultSet result) throws SQLException {
        return new Customer(
                result.getInt("id"),
                result.getString("name"),
                result.getString("gender"),
                result.getInt("age"),
                result.getString("phone"),
                result.getString("address"));
    }

    private IllegalStateException databaseError(String operation, SQLException cause) {
        return new IllegalStateException("No se pudo " + operation + ": " + cause.getMessage(), cause);
    }
}
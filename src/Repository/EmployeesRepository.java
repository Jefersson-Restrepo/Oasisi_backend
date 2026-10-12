package Repository;

import Domain.Employees;
import java.util.ArrayList;
import java.util.List;

public class EmployeesRepository {
    private final List<Employees> data = new ArrayList<>();
    public void create(Employees employees) { if (employees != null) data.add(employees); }
    public Employees selectById(int id) { return data.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null); }
    public List<Employees> selectAll() { return new ArrayList<>(data); }
    public boolean update(Employees employees) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == employees.getId()) { data.set(i, employees); return true; }
        }
        return false;
    }
    public boolean delete(int id) { return data.removeIf(employee -> employee.getId() == id); }
}
package Service;

import Domain.Employees;
import Port.InputPort;
import Port.OutputPort;
import Repository.EmployeesRepository;
import java.util.List;
import java.util.Objects;

public class EmployeesService implements InputPort<Employees> {
    private final OutputPort<Employees> repository;

    public EmployeesService() {
        this(new EmployeesRepository());
    }

    public EmployeesService(OutputPort<Employees> repository) {
        this.repository = Objects.requireNonNull(repository, "El OutputPort no puede ser nulo.");
    }

    public void create(Employees employee) {
        if (employee == null) throw new IllegalArgumentException("El empleado no puede ser nulo.");
        if (employee.getName() == null || employee.getName().isBlank())
            throw new IllegalArgumentException("El nombre del empleado es obligatorio.");
        if (employee.getIdService() == null || employee.getIdService().isBlank())
            throw new IllegalArgumentException("Debe asignarse un servicio al empleado.");
        repository.create(employee);
    }
    public Employees selectById(int id) {
        return repository.selectById(id);
    }

    public List<Employees> selectAll() {
        return repository.selectAll();
    }

    public boolean update(Employees employee) {
        return employee != null && repository.update(employee);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }
}

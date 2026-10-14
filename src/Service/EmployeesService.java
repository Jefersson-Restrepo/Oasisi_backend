package Service;

import Domain.Employees;
import Repository.EmployeesRepository;
import java.util.List;

public class EmployeesService {
    private final EmployeesRepository repository = new EmployeesRepository();

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

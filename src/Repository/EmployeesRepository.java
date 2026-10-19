package Repository;

import Domain.Employees;
import Port.OutputPort;
import java.util.ArrayList;
import java.util.List;

public class EmployeesRepository implements OutputPort<Employees> {
    private final List<Employees> data = new ArrayList<>();
    public void create(Employees employees) { if (employees != null) data.add(employees); }
    public Employees selectById(int id) {
        for (Employees employee : data) {
            if (employee.getId() == id) return employee;
        }
        return null;
    }
    public List<Employees> selectAll() { return new ArrayList<>(data); }
    public boolean update(Employees employees) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == employees.getId()) { data.set(i, employees); return true; }
        }
        return false;
    }
    public boolean delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == id) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }
}
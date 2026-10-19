package Repository;

import Domain.Person;
import Port.OutputPort;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements OutputPort<Person> {
    private final List<Person> data = new ArrayList<>();
    public void create(Person person) { if (person != null) data.add(person); }
    public Person selectById(int id) {
        for (Person person : data) {
            if (person.getId() == id) return person;
        }
        return null;
    }
    public List<Person> selectAll() { return new ArrayList<>(data); }
    public boolean update(Person person) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == person.getId()) { data.set(i, person); return true; }
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
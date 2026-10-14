package Repository;

import Domain.Person;
import Port.OutputPort;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements OutputPort<Person> {
    private final List<Person> data = new ArrayList<>();
    public void create(Person person) { if (person != null) data.add(person); }
    public Person selectById(int id) { return data.stream().filter(person -> person.getId() == id).findFirst().orElse(null); }
    public List<Person> selectAll() { return new ArrayList<>(data); }
    public boolean update(Person person) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == person.getId()) { data.set(i, person); return true; }
        }
        return false;
    }
    public boolean delete(int id) { return data.removeIf(person -> person.getId() == id); }
}
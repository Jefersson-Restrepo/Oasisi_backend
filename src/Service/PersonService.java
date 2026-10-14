package Service;

import Domain.Person;
import Port.InputPort;
import Port.OutputPort;
import Repository.PersonRepository;
import java.util.List;
import java.util.Objects;

public class PersonService implements InputPort<Person> {
    private final OutputPort<Person> repository;

    public PersonService() {
        this(new PersonRepository());
    }

    public PersonService(OutputPort<Person> repository) {
        this.repository = Objects.requireNonNull(repository, "El OutputPort no puede ser nulo.");
    }

    public void create(Person person) {
        if (person == null) throw new IllegalArgumentException("La persona no puede ser nula.");
        if (person.getName() == null || person.getName().isBlank())
            throw new IllegalArgumentException("El nombre es obligatorio.");
        if (person.getAge() <= 0 || person.getAge() > 120)
            throw new IllegalArgumentException("La edad debe estar entre 1 y 120 aÃ±os.");
        repository.create(person);
    }
    public Person selectById(int id) {
        return repository.selectById(id);
    }

    public List<Person> selectAll() {
        return repository.selectAll();
    }

    public boolean update(Person person) {
        return person != null && repository.update(person);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }
}

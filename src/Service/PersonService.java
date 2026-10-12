package Service;

import Domain.Person;
import Repository.PersonRepository;
import java.util.List;

public class PersonService {
    private final PersonRepository repository = new PersonRepository();

    public void create(Person person) {
        if (person == null) throw new IllegalArgumentException("La persona no puede ser nula.");
        if (person.getName() == null || person.getName().isBlank()) throw new IllegalArgumentException("El nombre es obligatorio.");
        if (person.getAge() <= 0 || person.getAge() > 120) throw new IllegalArgumentException("La edad debe estar entre 1 y 120 aÃ±os.");
        repository.create(person);
    }

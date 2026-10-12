package View;

import Domain.Person;
import java.util.List;

public class PersonView {
    public void showMenu() {
        System.out.println("\n--- Personas ---");
        System.out.println("1. Crear persona");
        System.out.println("2. Listar personas");
        System.out.println("3. Buscar persona");
        System.out.println("4. Actualizar persona");
        System.out.println("5. Eliminar persona");
        System.out.println("0. Volver");
    }

    public void showPeople(List<Person> people) {
        if (people.isEmpty()) { System.out.println("No hay personas registradas."); return; }
        for (Person person : people) System.out.println(person);
    }
}
package Service;

import Domain.Service;
import Port.InputPort;
import Port.OutputPort;
import Repository.ServiceRepository;
import java.util.List;
import java.util.Objects;

public class ServiceService implements InputPort<Service> {
    private final OutputPort<Service> repository;

    public ServiceService() {
        this(new ServiceRepository());
    }

    public ServiceService(OutputPort<Service> repository) {
        this.repository = Objects.requireNonNull(repository, "El OutputPort no puede ser nulo.");
    }

    public void create(Service service) {
        if (service == null) throw new IllegalArgumentException("El servicio no puede ser nulo.");
        if (service.getDescription() == null || service.getDescription().isBlank())
            throw new IllegalArgumentException("La descripciÃ³n del servicio es obligatoria.");
        if (service.getDuration() <= 0) throw new IllegalArgumentException("La duraciÃ³n debe ser mayor a cero.");
        repository.create(service);
    }
    public Service selectById(int id) {
        return repository.selectById(id);
    }

    public List<Service> selectAll() {
        return repository.selectAll();
    }

    public boolean update(Service service) {
        return service != null && repository.update(service);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }
}

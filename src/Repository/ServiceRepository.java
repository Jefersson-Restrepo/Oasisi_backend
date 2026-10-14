package Repository;

import Domain.Service;
import Port.OutputPort;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements OutputPort<Service> {
    private final List<Service> data = new ArrayList<>();
    public void create(Service service) { if (service != null) data.add(service); }
    public Service selectById(int id) { return data.stream().filter(service -> service.getId() == id).findFirst().orElse(null); }
    public List<Service> selectAll() { return new ArrayList<>(data); }
    public boolean update(Service service) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == service.getId()) { data.set(i, service); return true; }
        }
        return false;
    }
    public boolean delete(int id) { return data.removeIf(service -> service.getId() == id); }
}
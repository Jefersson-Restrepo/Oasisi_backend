package Repository;

import Domain.ServiceStatus;
import java.util.ArrayList;
import java.util.List;

public class ServiceStatusRepository {
    private final List<ServiceStatus> statuses = new ArrayList<>();

    public void create(ServiceStatus status) {
        if (status != null) {
            statuses.add(status);
        }
    }

    public List<ServiceStatus> selectAll() {
        return new ArrayList<>(statuses);
    }
}
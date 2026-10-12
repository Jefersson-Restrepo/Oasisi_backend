package Repository;

import java.util.ArrayList;
import java.util.List;

public class ServiceStatusRepository {
    private final List<String> statuses = new ArrayList<>();
    public void create(String status) { if (status != null && !status.isBlank()) statuses.add(status); }
    public List<String> selectAll() { return new ArrayList<>(statuses); }
}
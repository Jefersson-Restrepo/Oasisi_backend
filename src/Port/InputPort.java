package Port;

import java.util.List;

public interface InputPort<T> {
    void create(T entity);
    T selectById(int id);
    List<T> selectAll();
    boolean update(T entity);
    boolean delete(int id);
}

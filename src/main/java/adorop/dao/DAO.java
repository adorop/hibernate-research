package adorop.dao;

import java.util.List;

/**
 * Created by user on 01.05.2017.
 */
public interface DAO<T> {
    List<T> findAll();
    void save(T entity);
    T update(T entity);
    T find(Long id);
    void delete(Long id);
}

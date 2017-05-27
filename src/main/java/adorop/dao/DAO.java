package adorop.dao;

import java.util.List;

/**
 * Created by user on 01.05.2017.
 */
public interface DAO<T> {
    List<T> findAll();
    T save(T entity);
    T update(T entity);
}

package adorop.dao;

import adorop.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<T> implements DAO<T> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(persistedClass());
        query.select(query.from(persistedClass()));
        return entityManager.createQuery(query)
                .getResultList();
    }

    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public T find(Long id) {
        return entityManager.find(persistedClass(), id);
    }

    @Override
    public void delete(Long id) {

    }

    protected abstract Class<T> persistedClass();
}

package adorop.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
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
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
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
        entityManager.remove(entityManager.getReference(persistedClass(), id));
    }

    protected abstract Class<T> persistedClass();
}

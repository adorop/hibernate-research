package adorop.dao;

import adorop.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao<T> implements DAO<Product> {

    @Override
    public List<Product> findAll() {
//        return sessionFactory
        return null;
    }

    @Override
    public Product save(Product entity) {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }
}

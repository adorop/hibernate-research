package dao;

import model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

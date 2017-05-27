package adorop.dao;

import adorop.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends AbstractDao<Product> {
    @Override
    protected Class<Product> persistedClass() {
        return Product.class;
    }
}

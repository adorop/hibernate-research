package adorop.service;

import adorop.dao.DAO;
import adorop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final DAO<Product> productDAO;

    @Autowired
    public ProductServiceImpl(DAO<Product> productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }
}

package adorop.service;

import adorop.dao.DAO;
import adorop.model.Product;
import adorop.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final DAO<Product> productDAO;
    private final Converter<ProductDto, Product> converter;

    @Autowired
    public ProductServiceImpl(DAO<Product> productDAO, Converter<ProductDto, Product> converter) {
        this.productDAO = productDAO;
        this.converter = converter;
    }

    @Override
    public Product save(ProductDto productDto) {
        return productDAO.save(converter.convert(productDto));
    }
}

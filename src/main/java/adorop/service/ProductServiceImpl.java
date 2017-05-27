package adorop.service;

import adorop.dao.DAO;
import adorop.model.Product;
import adorop.model.User;
import adorop.service.dto.ProductDto;
import adorop.service.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final DAO<Product> productDAO;
    private final DAO<User> userDAO;
    private final Converter<ProductDto, Product> converter;
    private final Converter<Product, ProductDto> toDtoConverter;
    private final Validator<ProductDto> validator;

    @Autowired
    public ProductServiceImpl(DAO<Product> productDAO,
                              DAO<User> userDAO,
                              Converter<ProductDto, Product> converter,
                              Converter<Product, ProductDto> toDtoConverter,
                              Validator<ProductDto> validator) {
        this.productDAO = productDAO;
        this.userDAO = userDAO;
        this.converter = converter;
        this.toDtoConverter = toDtoConverter;
        this.validator = validator;
    }

    @Override
    public ProductDto find(Long id) {
        Product product = productDAO.find(id);
        product.setTimesViewed(product.getTimesViewed() + 1L);
        return toDtoConverter.convert(product);
    }

    @Override
    public Product save(ProductDto productDto) {
        validator.validate(productDto);
        Product product = converter.convert(productDto);
        userDAO.find(productDto.getOwnerId())
                .getProducts()
                .add(product);
        return product;
    }
}

package adorop.service.dto.converters;

import adorop.dao.DAO;
import adorop.service.dto.ProductDto;
import adorop.model.Product;
import adorop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToProductConverter implements Converter<ProductDto, Product> {
    private final DAO<User> userDAO;

    @Autowired
    public DtoToProductConverter(DAO<User> userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Product convert(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setOwner(findOwner(productDto));
        return product;
    }

    private User findOwner(ProductDto productDto) {
        return userDAO.find(productDto.getOwnerId());
    }
}

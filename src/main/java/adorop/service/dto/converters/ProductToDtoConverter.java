package adorop.service.dto.converters;

import adorop.model.Product;
import adorop.service.dto.ProductDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToDtoConverter implements Converter<Product, ProductDto> {
    @Override
    public ProductDto convert(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setOwnerId(product.getOwner().getId());
        return productDto;
    }
}

package adorop.service;

import adorop.model.Product;
import adorop.service.dto.ProductDto;

public interface ProductService {
    ProductDto find(Long id);
    Product save(ProductDto productDto);
}

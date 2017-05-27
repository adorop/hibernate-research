package adorop.service;

import adorop.model.Product;
import adorop.service.dto.ProductDto;

public interface ProductService {
    Product save(ProductDto productDto);
}

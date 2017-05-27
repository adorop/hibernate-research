package adorop.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private Long id;
    private String description;
    private BigDecimal price;
    private Long ownerId;
}

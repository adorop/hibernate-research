package adorop.service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductDto {
    private Long id;
    @NotNull
    private String description;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Long ownerId;
}

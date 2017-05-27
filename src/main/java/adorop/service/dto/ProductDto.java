package adorop.service.dto;

import com.sun.istack.internal.NotNull;
import lombok.Data;

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

package adorop.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BadRequestDto {
    private String message;

    public BadRequestDto(String message) {
        this.message = message;
    }
}

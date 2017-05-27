package adorop.web;

import adorop.service.BadRequestException;
import adorop.service.dto.BadRequestDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllersExceptionHandler {
    @ExceptionHandler
    public BadRequestDto handle(BadRequestException e) {
        return new BadRequestDto(e.getMessage());
    }
}

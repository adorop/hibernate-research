package adorop.web;

import adorop.service.BadRequestException;
import adorop.service.dto.BadRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllersExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BadRequestDto handle(BadRequestException e) {
        return new BadRequestDto(e.getMessage());
    }
}

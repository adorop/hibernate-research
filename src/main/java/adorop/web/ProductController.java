package adorop.web;

import adorop.service.BadRequestException;
import adorop.service.ProductService;
import adorop.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final Validator productValidator;
    private final ProductService productService;

    @Autowired
    public ProductController(@Qualifier("productValidator") Validator productValidator,
                             ProductService productService) {
        this.productValidator = productValidator;
        this.productService = productService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(productValidator);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Validated  ProductDto productDto, Errors errors) {
        if (errors.hasErrors()) {
            throw new BadRequestException(errors.getFieldErrors().toString());
        }
        productService.save(productDto);
    }
}

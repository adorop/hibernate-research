package adorop.service.validators;

import adorop.dao.DAO;
import adorop.model.User;
import adorop.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {
    private final DAO<User> userDAO;

    @Autowired
    public ProductValidator(DAO<User> userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == ProductDto.class;
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductDto productDto= (ProductDto) o;
        Long userId = productDto.getOwnerId();
        User user = userDAO.find(userId);
        if (user == null) {
            errors.reject("ownerId is not valid");
        }
    }
}

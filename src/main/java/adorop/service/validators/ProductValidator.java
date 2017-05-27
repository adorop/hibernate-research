package adorop.service.validators;

import adorop.dao.DAO;
import adorop.model.User;
import adorop.service.BadRequestException;
import adorop.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator implements Validator<ProductDto> {
    private final DAO<User> userDAO;

    @Autowired
    public ProductValidator(DAO<User> userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void validate(ProductDto entity) {
        Long userId = entity.getOwnerId();
        User user = userDAO.find(userId);
        if (user == null) {
            throw new BadRequestException("ownerId is not valid");
        }
    }
}

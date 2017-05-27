package adorop.dao;

import adorop.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractDao<User> {
    @Override
    protected Class<User> persistedClass() {
        return User.class;
    }
}

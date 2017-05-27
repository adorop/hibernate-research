package adorop.service;

import adorop.dao.DAO;
import adorop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final DAO<User> userDAO;

    @Autowired
    public UserServiceImpl(DAO<User> userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }
}

package adorop.service;

import adorop.dao.DAO;
import adorop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final DAO<User> userDAO;

    @Autowired
    public UserServiceImpl(DAO<User> userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User save(User user) {
        userDAO.save(user);
        return user;
    }
}

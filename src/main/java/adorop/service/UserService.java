package adorop.service;

import adorop.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);
}

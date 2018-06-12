package edisk.service;

import edisk.entity.Role;
import edisk.entity.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    User getUser(String name);

    List<User> getUsers();

    void saveUser(User user);

    List<Role> getRoles();
}

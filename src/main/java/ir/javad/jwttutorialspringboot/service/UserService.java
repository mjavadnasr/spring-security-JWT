package ir.javad.jwttutorialspringboot.service;

import ir.javad.jwttutorialspringboot.Model.Role;
import ir.javad.jwttutorialspringboot.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}

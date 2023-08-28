package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class CreateUsersAndRoles {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @PostConstruct
    public void run() {
        Role admin = new Role(1, "ROLE_ADMIN");
        Role user = new Role(2, "ROLE_USER");
        roleService.saveRole(admin);
        roleService.saveRole(user);

        // username: superAdmin
        // password: root
        User user1 = new User("James", "Bond", 90, "007@outlook.com"
                , "superAdmin", "$2a$10$bf5hvebgY5lbdIFb/Mx.ZO.z5c6.C0d4wEzLk2eQH3kbRI0.FtUWK");

        // username: simpleUser
        // password: root
        User user2 = new User("Vasiliy", "Terkin", 80, "terkin@gmail.com"
                , "simpleUser", "$2a$10$bf5hvebgY5lbdIFb/Mx.ZO.z5c6.C0d4wEzLk2eQH3kbRI0.FtUWK");user1.setRole(admin);

        user1.setRole(user);
        user2.setRole(user);
        userService.addUser(user1);
        userService.addUser(user2);
    }

}

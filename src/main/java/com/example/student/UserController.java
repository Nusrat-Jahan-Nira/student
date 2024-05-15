package com.example.student;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        users.add(user);
        return "User created: " + user.getName();
    }

    @DeleteMapping("/{userName}")
    public String deleteUser(@PathVariable String userName) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                users.remove(user);
                return "User deleted: " + userName;
            }
        }
        return "User not found";
    }

}
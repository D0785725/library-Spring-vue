package bin.javaproject.librarysystemtest.controller;

import bin.javaproject.librarysystemtest.entity.User;
import bin.javaproject.librarysystemtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User>  getAllUsers(){
        return userService.findAll();
    }
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        System.out.println(user);
        return userService.registerUser(user);
    }
}

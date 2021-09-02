package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Entities.User;
import com.example.demo.Service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @GetMapping("/findAllUsers")
    public List<User> findAllUsers(){
        return this.userService.findAllUsers();
    }

    @GetMapping("/findUser/{id}")
    public User findUser(@PathVariable Long id){
        return this.userService.findUser(id);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        this.userService.addUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(
        @PathVariable Long id,
        @RequestBody User user
    ){
        this.userService.updateUser(user, id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);
    }

}

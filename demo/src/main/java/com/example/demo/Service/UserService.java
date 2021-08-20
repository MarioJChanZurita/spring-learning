package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.User;
import com.example.demo.Repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService( UserRepository userRepository ){
        this.userRepository = userRepository;
    }
    
    public List<User> findAllUsers(){
        return this.userRepository.findAll();
    }

    public User findUser(Long id){
        return this.userRepository.findById(id).orElse(null);
    }

    public void addUser(User user){
        this.userRepository.save(user);
    }

    public void updateUser(User updatedUser, Long id){
        User user = this.userRepository.findById(id).orElse(null);
        user.setName(updatedUser.getName());
        this.userRepository.save(user);
    }

    public void deleteUser(Long id){
        this.userRepository.deleteById(id);
    }

}

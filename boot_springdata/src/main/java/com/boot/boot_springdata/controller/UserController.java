package com.boot.boot_springdata.controller;

import com.boot.boot_springdata.entity.User;
import com.boot.boot_springdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by Brian in 21:25 2018/12/2
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @GetMapping("/user")
    public User saveUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}

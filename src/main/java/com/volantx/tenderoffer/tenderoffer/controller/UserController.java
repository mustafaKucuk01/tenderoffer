package com.volantx.tenderoffer.tenderoffer.controller;


import com.volantx.tenderoffer.tenderoffer.entity.User;
import com.volantx.tenderoffer.tenderoffer.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> list(){
        return userService.all();
    }

    @GetMapping("/{id}")
    public User read(@PathVariable("id") Long id){
        return userService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id")Long id,@RequestBody User user){
        return userService.updateUser(id,user);
    }

}

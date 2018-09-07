package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.User;
import com.volantx.tenderoffer.tenderoffer.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;

public class UserService implements ApplicationRunner {

    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    List<User> getAllUsers(){return userRepository.findAll();}
}

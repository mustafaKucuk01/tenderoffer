package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class UserService implements ApplicationRunner {

    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}

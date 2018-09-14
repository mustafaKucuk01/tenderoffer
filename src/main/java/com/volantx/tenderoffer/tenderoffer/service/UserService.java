package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.User;
import com.volantx.tenderoffer.tenderoffer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("Kamuran","YILMAZ","test1@test.com","5335454367");
        User user2 = new User("Kamuran","YILMAZ","test2@test.com","5335454367");
        User user3 = new User("Kamuran","YILMAZ","test3@test.com","5335454367");
        User user4 = new User("Kamuran","YILMAZ","test4@test.com","5335454367");

        try{
            Stream.of(user1,user2,user3,user4).forEach(this::addUser);
        }catch (Exception e){

        }
    }

    public List<User> all(){
        return userRepository.findAll();
    }

    public User addUser(User user) {
        System.out.println("Adding user "+ user.toString());
        Optional<User> byEmail = userRepository.findByEmail(user.getEmail());
        if (byEmail.isPresent()){
            System.out.println("Already added");
            throw new RuntimeException("Already added");
        }
        return userRepository.save(user);
    }

    public User updateUser(Long id,User user) {
        System.out.println("Update user "+ user.toString());
        get(id);
        user.setId(id);
        Optional<User> byEmail = userRepository.findByEmail(user.getEmail());
        if (byEmail.isPresent() && !byEmail.get().getId().equals(user.getId())){
            System.out.println("Already added");
            throw new RuntimeException("Already added");
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        System.out.println("Delete user "+ id);
        userRepository.delete(get(id));
    }

    public User get(Long id) {
        System.out.println("Get user "+id);
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("Use not found");
        }
        return byId.get();
    }
}

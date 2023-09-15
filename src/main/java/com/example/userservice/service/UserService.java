package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String addUser(User user){

        this.userRepository.save(user);
                return "user added successfully";
    }
    public String userDelete(Integer id){
        this.userRepository.deleteById(id);
        return "user deleted successfully";
    }
    public String userUpdate(Integer id, User user){
       User user1= new User();
        user1=this.userRepository.findById(id).get();
        user1.setEmail(user.getEmail());
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setLocation(user.getLocation());
        this.userRepository.save(user1);
        return "User has been updated";

    }
}

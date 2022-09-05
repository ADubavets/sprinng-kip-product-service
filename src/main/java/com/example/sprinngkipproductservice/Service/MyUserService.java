package com.example.sprinngkipproductservice.Service;

import com.example.sprinngkipproductservice.Model.MyUser;
import com.example.sprinngkipproductservice.Repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserService {
    @Autowired
    private MyUserRepository userRepository;

    public List<MyUser> findAll() {
        return userRepository.findAll();
    }

    public MyUser save(MyUser user) {
        return userRepository.save(user);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public Optional<MyUser> userFindById(Long id) {
        return userRepository.findById(id);
    }

    public MyUser getUserByUserName(String username) {
        return userRepository.getUserByUserName(username);
    }

    public MyUser getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

}

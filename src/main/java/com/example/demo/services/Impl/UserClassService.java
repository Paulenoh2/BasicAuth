package com.example.demo.services.Impl;

import com.example.demo.entities.UserClass;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserClassDetails;
import com.example.demo.services.UserService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserClassService implements UserDetailsService , UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserClass> userClass= userRepository.findByUsername(username);
       return userClass.map(UserClassDetails ::new)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find this username" + username));

    }

    @Override
    public String createUser(UserClass userClass) {
      userClass.setPassword(passwordEncoder.encode(userClass.getPassword()));
        userRepository.save(userClass);
        return "user is added successful";
    }

    @Override
    public UserClass updateUser(UserClass userClass) {
        return userRepository.save(userClass);
    }

    @Override
    public List<UserClass> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteAllUser(UserClass userClass) {
        userRepository.delete(userClass);
    }

    @Override
    public void deleteUseById(Integer id) {
            userRepository.deleteById(id);
    }


    @Override
    public Optional<UserClass> getUserById(Integer id) {
        Optional<UserClass> getById = userRepository.findById(id);
        return getById;
    }
}
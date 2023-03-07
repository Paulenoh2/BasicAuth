package com.example.demo.services;

import com.example.demo.entities.UserClass;

import java.util.List;
import java.util.Optional;

public interface UserService {



    public String createUser(UserClass userClass);
    public UserClass updateUser (UserClass userClass);

    public List<UserClass> getAllUsers();

    public void deleteAllUser(UserClass userClass);
    public  void deleteUseById(Integer id);

    public Optional <UserClass> getUserById(Integer id);






}

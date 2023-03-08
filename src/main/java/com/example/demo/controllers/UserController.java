package com.example.demo.controllers;

import com.example.demo.entities.UserClass;
import com.example.demo.services.Impl.UserClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
   private UserClassService userClassService;



@GetMapping("/welcome")
public String message(){
    return "Welcome Endpoint to Spring Security page not secure";
}


@PostMapping("/new")
public String addNewUser(@RequestBody UserClass userClass){
    userClassService.createUser(userClass);
    return "added new user";
}

@PutMapping("/edit")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public UserClass update (@RequestBody UserClass userClass){
   return userClassService.updateUser(userClass);


}

@GetMapping ("/all")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserClass> getAll (){
    return userClassService.getAllUsers();
}

@GetMapping ("/get/{id}")
@PreAuthorize("hasAuthority('ROLE_USER')")
public Optional<UserClass> getById(@PathVariable Integer id){
    Optional<UserClass> getUser = userClassService.getUserById(id);
    return getUser;
}

@DeleteMapping  ("/delete/{id}")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public  String  deleteByUserId (@PathVariable Integer id){
    userClassService.deleteUseById(id);
    return "delete was succesfull";
}

}

package com.example.demo.repository;

import com.example.demo.entities.UserClass;
import com.example.demo.security.UserClassDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@Repository

public interface UserRepository extends JpaRepository<UserClass,Integer> {


 public Optional<UserClass> findByUsername(String username);

}

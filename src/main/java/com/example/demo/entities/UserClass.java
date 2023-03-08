package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor

@NoArgsConstructor
@ToString

@Entity
@Table(name = "users")
public class UserClass {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
     @Column(name = "username")
    private String username;
    @Column (name = "password")
    private String password;

    @Column (name = "roles")
    private String roles;


}

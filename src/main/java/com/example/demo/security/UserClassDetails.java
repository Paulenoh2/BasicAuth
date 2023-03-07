package com.example.demo.security;

import com.example.demo.entities.UserClass;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class UserClassDetails implements UserDetails {


        private String username;
        private String password;
        private List <GrantedAuthority> authorities;

        public UserClassDetails (UserClass userClass){
        username = getUsername();
        password = getPassword();
        authorities = Arrays.stream(userClass.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        }




    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities ;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

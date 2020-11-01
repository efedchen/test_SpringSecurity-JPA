package com.example.springsecurityjpa.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //hardcoded
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //hardcoded
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //hardcoded
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}

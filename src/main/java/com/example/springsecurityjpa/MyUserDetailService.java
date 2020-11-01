package com.example.springsecurityjpa;

import com.example.springsecurityjpa.models.MyUserDetails;
import com.example.springsecurityjpa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    //service retrives user data from mySql db (for now its hardcoded)
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        MyUserDetails userDetails = user.map(MyUserDetails::new).get();
        return userDetails;
    }
}

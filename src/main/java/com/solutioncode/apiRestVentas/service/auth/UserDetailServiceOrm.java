package com.solutioncode.apiRestVentas.service.auth;

import com.solutioncode.apiRestVentas.component.security.CustomUser;
import com.solutioncode.apiRestVentas.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailServiceOrm implements UserDetailsService {
    public static Logger logger = LoggerFactory.getLogger(UserDetailServiceOrm.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var boxUser = userRepository.findByEmail(email);
        if (boxUser.isEmpty())
            throw new UsernameNotFoundException("not found user");
        var user = boxUser.get();
        return new CustomUser(
                user.getEmail(),
                user.getName(),
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority(user.getRol().getName()))
        );
    }

}

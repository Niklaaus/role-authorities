package com.example.role_authorities.service;

import com.example.role_authorities.entity.Authority;
import com.example.role_authorities.entity.User;
import com.example.role_authorities.enums.Roles;
import com.example.role_authorities.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        List<Authority> user_authorities=user.getRoles().stream().flatMap(role-> role.getAuthorities().stream()).toList();

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return user_authorities.stream().map(authority -> new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return authority.getAuthority();
                    }
                }).collect(Collectors.toList());
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getUsername();
            }
        };
    }
}

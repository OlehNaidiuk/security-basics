package com.naidiuk.securitybasics.security;

import com.naidiuk.securitybasics.entity.User;
import com.naidiuk.securitybasics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByUsername(username);
        return SecurityUser.transformToUserDetails(user);
    }
}

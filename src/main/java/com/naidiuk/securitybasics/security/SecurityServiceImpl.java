package com.naidiuk.securitybasics.security;

import com.naidiuk.securitybasics.dto.AuthenticationRequestDto;
import com.naidiuk.securitybasics.entity.User;
import com.naidiuk.securitybasics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Override
    public String getAuthentication(AuthenticationRequestDto authRequestDto) {
        User user = userService.findByUsername(authRequestDto.getUsername());
        authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                        authRequestDto.getUsername(), authRequestDto.getPassword()));
        return jwtProvider.createToken(user.getUsername(), user.getUserId());
    }
}

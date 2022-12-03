package com.naidiuk.securitybasics.controller;

import com.naidiuk.securitybasics.dto.AuthenticationRequestDto;
import com.naidiuk.securitybasics.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class SingInController {
    @Value("${jwt.authorization-header}")
    private String authorizationHeader;
    private final SecurityService securityService;

    @PostMapping("/login")
    public void authenticate(
            @RequestBody AuthenticationRequestDto authRequestDto,
            HttpServletResponse response
    ) {
        String token = securityService.getAuthentication(authRequestDto);
        response.setHeader(authorizationHeader, token);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}

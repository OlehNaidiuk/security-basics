package com.naidiuk.securitybasics.controller;

import com.naidiuk.securitybasics.dto.UserDto;
import com.naidiuk.securitybasics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sign-up")
@RequiredArgsConstructor
public class SignUpController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
        Long userId = userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }
}

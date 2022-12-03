package com.naidiuk.securitybasics.service;

import com.naidiuk.securitybasics.dto.UserDto;
import com.naidiuk.securitybasics.entity.User;

public interface UserService {
    Long save(UserDto userDto);
    User findByUsername(String username);
}

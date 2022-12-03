package com.naidiuk.securitybasics.mapper;

import com.naidiuk.securitybasics.dto.UserDto;
import com.naidiuk.securitybasics.entity.User;

public class UserMapper {
    private UserMapper() {

    }

    public static User transformToDao(UserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
    }
}

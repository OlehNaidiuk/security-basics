package com.naidiuk.securitybasics.service;

import com.naidiuk.securitybasics.dto.UserDto;
import com.naidiuk.securitybasics.entity.User;
import com.naidiuk.securitybasics.mapper.UserMapper;
import com.naidiuk.securitybasics.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Long save(UserDto userDto) {
        User user = UserMapper.transformToDao(userDto);
        String encodedPassword = new BCryptPasswordEncoder(12).encode(user.getPassword());
        user.setPassword(encodedPassword);
        User savedUser = userRepository.save(user);
        return savedUser.getUserId();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                        .orElseThrow(() ->
                                new UsernameNotFoundException(
                                        String.format("User with username=%s not found.", username)));
    }
}

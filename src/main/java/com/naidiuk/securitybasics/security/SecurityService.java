package com.naidiuk.securitybasics.security;

import com.naidiuk.securitybasics.dto.AuthenticationRequestDto;

public interface SecurityService {
    String getAuthentication(AuthenticationRequestDto authRequestDto);
}

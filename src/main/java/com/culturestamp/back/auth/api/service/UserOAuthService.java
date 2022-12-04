package com.culturestamp.back.auth.api.service;

import com.culturestamp.back.dto.UserServiceResponse;
import com.culturestamp.back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserOAuthService {
    private final UserRepository userRepository;

    public UserServiceResponse getUser(String userId);

}

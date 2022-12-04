package com.culturestamp.back.auth.api.service;

import com.culturestamp.back.dto.UserResponse;
import com.culturestamp.back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserOAuthService {
    private final UserRepository userRepository;

    public UserResponse getUser(String userId) {
       return new UserResponse(userRepository.findByUserId(userId));
    }
}

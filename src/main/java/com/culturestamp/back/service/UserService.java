package com.culturestamp.back.service;

import com.culturestamp.back.dto.UserResponse;

public interface UserService {
    public UserResponse getUserById(Long userId);
}

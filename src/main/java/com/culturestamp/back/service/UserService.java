package com.culturestamp.back.service;

import java.util.Optional;

import com.culturestamp.back.dto.UserRequest;
import com.culturestamp.back.entity.User;

public interface UserService {
	User create(UserRequest userParameter);
	User create(User user);
	User read(Long id);
	Optional<User> findByEmail(String email);
}


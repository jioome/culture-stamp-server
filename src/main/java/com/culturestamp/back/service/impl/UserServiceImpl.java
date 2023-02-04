package com.culturestamp.back.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culturestamp.back.dto.UserRequest;
import com.culturestamp.back.entity.User;
import com.culturestamp.back.oauth.UserRepository;

@Service
public class UserServiceImpl {
	@Autowired
	private UserRepository userRepository;

	private final List<User> users = new ArrayList<>();

	// create 없이 delete update read 만 있어도 됨
	public User create(UserRequest userParameter) {
		final User user = new User(userParameter.getUserId(),userParameter.getSocialId(), userParameter.getEmail(), userParameter.getNickName(),userParameter.getPicture(),userParameter.getStatus(),userParameter.getFollower(),userParameter.getRole());
		return userRepository.save(user);
	}

	@Transactional
	public User create(User user) {
		return userRepository.save(user);
	}

	@Cacheable(cacheNames = "user", key = "#id")
	public User read(Long id) {
		return userRepository.findById(id).orElseThrow(NullPointerException::new);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}

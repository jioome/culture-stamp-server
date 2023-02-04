package com.culturestamp.back.oauth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.culturestamp.back.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findByEmail(String email); //
	boolean existsByEmail(String email);

}
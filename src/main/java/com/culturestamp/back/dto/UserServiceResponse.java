package com.culturestamp.back.dto;

import java.util.Date;

import com.culturestamp.back.entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceResponse {

	private Long userId;
	private String nickname;
	private String loginId;
	private ProviderType providerType;
//	private String providerId;
	private String email;
	private String password;
	private RoleType roleType;
	private Date lastLoginAt;
	private int failCount;

	public UserServiceResponse(User user) {
		this.userId = user.getUserId();
		this.nickname = user.getNickname();
		this.providerType = user.getProviderType();
//		this.providerId = user.getProviderId();
		this.loginId = user.getLoginId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.lastLoginAt = user.getLastLoginAt();
	}

	public UserServiceResponse update(String name) {
		this.nickname = name;
		return this;
	}

}


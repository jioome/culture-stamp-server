package com.culturestamp.back.dto;

import com.culturestamp.back.entity.User;
import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	private String nickname;
	private String loginId;
	private String providerType;
//	private String providerId;
	private String email;
	private String password;
	private String role;
	private Date lastLoginAt;
	private int failCount;

	@Builder
	public UserResponse(UserServiceResponse user) {
		this.nickname = user.getNickname();
		this.loginId = user.getLoginId();
		this.providerType = user.getProviderType();
//		this.providerId = user.getProviderId();
		this.role = user.getRole();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.lastLoginAt = user.getLastLoginAt();
		this.failCount = user.getFailCount();
	}

	@Builder
	public UserResponse(User user) {
		this.nickname = user.getNickname();
		this.loginId = user.getLoginId();
		this.providerType = user.getProviderType();
//		this.providerId = user.getProviderId();
		this.role = user.getRole();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.lastLoginAt = user.getLastLoginAt();
		this.failCount = user.getFailCount();
	}

	public UserResponse update(String name) {
		this.nickname = name;
		return this;
	}


}

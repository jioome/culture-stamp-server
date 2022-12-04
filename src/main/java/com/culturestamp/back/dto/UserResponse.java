package com.culturestamp.back.dto;

import com.culturestamp.back.auth.oauth.entity.ProviderType;
import com.culturestamp.back.auth.oauth.entity.RoleType;
import com.culturestamp.back.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	private String nickname;
	private String loginId;
	private ProviderType providerType;
//	private String providerId;
	private String email;
	private String password;
	private RoleType roleType;
	private Date lastLoginAt;
	private int failCount;

	public UserResponse(UserServiceResponse userServiceResponse) {
		this.nickname = userServiceResponse.getNickname();
		this.loginId = userServiceResponse.getLoginId();
		this.providerType = userServiceResponse.getProviderType();
//		this.providerId = userServiceResponse.getProviderId();
		this.email = userServiceResponse.getEmail();
		this.password = userServiceResponse.getPassword();
		this.lastLoginAt = userServiceResponse.getLastLoginAt();
		this.failCount = userServiceResponse.getFailCount();
	}

	public UserResponse(User user) {
		this.nickname = user.getNickname();
		this.loginId = user.getLoginId();
		this.providerType = user.getProviderType();
//		this.providerId = user.getProviderId();
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

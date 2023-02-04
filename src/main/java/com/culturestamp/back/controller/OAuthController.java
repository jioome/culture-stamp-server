package com.culturestamp.back.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.culturestamp.back.oauth.AuthToken;
import com.culturestamp.back.oauth.AuthTokenProvider;
import com.culturestamp.back.oauth.service.OAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OAuthController {
	@Autowired
	private OAuthService oAuthService;
	private AuthTokenProvider jwtManager;

	@RequestMapping("/oauth2/users/kakao")
	public AuthToken kakaoLogin(@RequestParam String code) throws IOException {
		String accessToken = oAuthService.getKakaoAccessToken(code);
		System.out.println("accessToken : " +accessToken);
		AuthToken jwtToken = oAuthService.getKakaoUserInfo(accessToken);
		System.out.println("jwtToken : " + jwtToken.getToken());
		return jwtToken;
	}
}

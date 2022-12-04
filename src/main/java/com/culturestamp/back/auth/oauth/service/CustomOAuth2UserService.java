package com.culturestamp.back.auth.oauth.service;

import com.culturestamp.back.auth.oauth.entity.ProviderType;
import com.culturestamp.back.auth.oauth.entity.RoleType;
import com.culturestamp.back.auth.oauth.entity.UserPrincipal;
import com.culturestamp.back.auth.oauth.exception.OAuthProviderMissMatchException;
import com.culturestamp.back.auth.oauth.info.OAuth2UserInfo;
import com.culturestamp.back.auth.oauth.info.OAuth2UserInfoFactory;
import com.culturestamp.back.dto.UserResponse;
import com.culturestamp.back.entity.User;
import com.culturestamp.back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);

        try {
            return this.process(userRequest, user);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User process(OAuth2UserRequest userRequest, OAuth2User user) {
        ProviderType providerType = ProviderType.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());

        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(providerType, user.getAttributes());
        UserResponse savedUser = new UserResponse(userRepository.findByUserId(userInfo.getId()));

        if (savedUser != null) {
            if (providerType != savedUser.getProviderType()) {
                throw new OAuthProviderMissMatchException(
                        "Looks like you're signed up with " + providerType +
                        " account. Please use your " + savedUser.getProviderType() + " account to login."
                );
            }
            updateUser(savedUser, userInfo);
        } else {
            savedUser = createUser(userInfo, providerType);
        }

        return UserPrincipal.create(savedUser, user.getAttributes());
    }

    private UserResponse createUser(OAuth2UserInfo userInfo, ProviderType providerType) {
        Date now = new Date();
        User user = new User().builder()
                .nickname(userInfo.getName())
                .loginId(userInfo.getId())
                .providerType(providerType)
                .email(userInfo.getEmail())
                .password("NO_PASS")
                .roleType(RoleType.USER)
                .lastLoginAt(now)
                .failCount(0)
                .build();

        return new UserResponse(userRepository.saveAndFlush(user));
    }

    private UserResponse updateUser(UserResponse userResponse, OAuth2UserInfo userInfo) {
        if (userInfo.getName() != null && !userResponse.getNickname().equals(userInfo.getName())) {
            userResponse.setNickname(userInfo.getName());
        }
        return userResponse;
    }
}

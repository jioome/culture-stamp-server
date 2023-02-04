package com.culturestamp.back.oauth.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.security.oauth2.client.provider.kakao")
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
public class KakaoOAuthProviderProperties {

    private String tokenUri;

    private String userInfoUri;

    private String authorizationUri;
}

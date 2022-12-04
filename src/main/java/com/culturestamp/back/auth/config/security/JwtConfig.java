package com.culturestamp.back.auth.config.security;

import com.culturestamp.back.auth.oauth.token.AuthTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
//    @Value("${jwt.secret}")
    private String secret = "926D96C90030DD58429D2751AC1BDBBC";

    @Bean
    public AuthTokenProvider jwtProvider() {
        return new AuthTokenProvider(secret);
    }
}

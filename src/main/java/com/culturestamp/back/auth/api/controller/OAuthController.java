package com.culturestamp.back.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login/oauth2/code")
public class OAuthController {

    @RequestMapping("/google")
    public String googleLogin(@RequestParam String code) throws IOException {
//        String accessToken = oAuthService.getKakaoAccessToken(code);
        System.out.println("accessCode : " + code);
//        AuthToken jwtToken = oAuthService.getKakaoUserInfo(accessToken);
//        System.out.println("jwtToken : " + jwtToken.getToken());
//        return jwtToken;
        return code;
    }


}

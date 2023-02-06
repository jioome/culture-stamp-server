package com.culturestamp.back.auth.api.controller;


import com.culturestamp.back.auth.api.service.UserOAuthService;
import com.culturestamp.back.dto.UserResponse;
import com.culturestamp.back.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/oauth")
public class OAuthController {

    @Autowired
    private UserOAuthService userOAuthService;


    @GetMapping("/user/info")
    public ResponseEntity getIndex(Principal principal, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (principal == null) {
            response.sendRedirect("http://localhost:8080/oauth2/authorization/google");
            return ResponseEntity.ok().build();
        }
        User entity = userOAuthService.getUser(Long.valueOf(principal.getName()));
        UserResponse userResponse = new UserResponse(entity);
        return ResponseEntity.ok().body(userResponse);
    }


    @RequestMapping("/login/google")
    public ResponseEntity loginWithGoogleOauth(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String authToken = userOAuthService.loginOAuthGoogle(request);

        final ResponseCookie cookie = ResponseCookie.from("test", authToken)
                .httpOnly(true)
                .maxAge(7 * 24 * 3600)
                .path("/")
                .secure(false)
                .build();
        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return ResponseEntity.ok().build();
    }

}

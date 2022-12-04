package com.culturestamp.back.auth.api.controller.user;

import com.culturestamp.back.auth.api.service.UserOAuthService;
import com.culturestamp.back.auth.common.ApiResponse;
import com.culturestamp.back.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserOAuthService userOAuthService;

    @GetMapping
    public ApiResponse getUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserResponse userResponse = userOAuthService.getUser(principal.getUsername());

        return ApiResponse.success("user", userResponse);
    }
}

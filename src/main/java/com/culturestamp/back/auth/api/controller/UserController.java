package com.culturestamp.back.controller;


import com.culturestamp.back.dto.UserResponse;
import com.culturestamp.back.dto.UserServiceResponse;
import com.culturestamp.back.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    // TODO: final 문의
    @GetMapping("/user/{userId}")
    public UserResponse getUserById(@PathVariable String userId) {
        final UserServiceResponse userServiceResponse = userServiceImpl.getUserById(Long.valueOf(userId));
        return new UserResponse(userServiceResponse);
    }


}

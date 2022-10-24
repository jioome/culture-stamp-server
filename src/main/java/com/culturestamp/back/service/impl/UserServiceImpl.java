package com.culturestamp.back.service.impl;

import com.culturestamp.back.entity.User;
import com.culturestamp.back.repository.UserRepository;
import com.culturestamp.back.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void insertUser(User user) {
        //userRepository.save()
    }
}

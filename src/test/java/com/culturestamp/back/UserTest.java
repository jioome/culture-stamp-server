package com.culturestamp.back;

import com.culturestamp.back.entity.Role;
import com.culturestamp.back.entity.User;
import com.culturestamp.back.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void insertUser() throws Exception {
        // User(String loginId, String email, String password, Role role, int failCount)
        userRepository.save(User.builder()
                            .loginId("firstTry")
                            .email("firstTry@cultureStamp.com")
                            .password("firstTry")
                            .role(Role.USER)
                            .failCount(0)
                            .build());
    }

}

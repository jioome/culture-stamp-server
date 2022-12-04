package com.culturestamp.back.auth.oauth.service;


import com.culturestamp.back.auth.oauth.entity.UserPrincipal;
import com.culturestamp.back.dto.UserResponse;
import com.culturestamp.back.dto.UserServiceResponse;
import com.culturestamp.back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserServiceResponse userServiceResponse = userRepository.findByEmail(email);
        if (userServiceResponse == null) {
            throw new UsernameNotFoundException("Can not find username.");
        }
        UserResponse userResponse = new UserResponse(userServiceResponse);
        return UserPrincipal.create(userResponse);
    }
}

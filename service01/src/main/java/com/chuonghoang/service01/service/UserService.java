package com.chuonghoang.service01.service;

import lombok.RequiredArgsConstructor;
import com.chuonghoang.service01.dto.response.UserResponse;
import com.chuonghoang.service01.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;


    public UserResponse getUserDetail(Long id) {
        var user = userRepository.findById(id);
        return user.map(value -> UserResponse.builder().userId(value.getUserId()).name(value.getName()).build()).orElse(null);
    }
}

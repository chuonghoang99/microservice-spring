package com.chuonghoang.service01.service;


import com.chuonghoang.service01.entities.RefreshToken;
import com.chuonghoang.service01.entities.User;
import com.chuonghoang.service01.exceptions.TokenException;
import com.chuonghoang.service01.exceptions.UsernameNotFoundException;
import com.chuonghoang.service01.repo.RefreshTokenRepository;
import com.chuonghoang.service01.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    private final UserRepository userRepository;


    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository, UserRepository userRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
    }

    public RefreshToken createRefreshToken(String email) {

        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email));

        RefreshToken refreshToken = user.getRefreshToken();

        if (refreshToken == null) {
            long refreshTokenValidity = 30 * 1000;
            refreshToken = RefreshToken.builder().refreshToken(UUID.randomUUID().toString()).expirationTime(Instant.now().plusMillis(refreshTokenValidity)).user(user).build();


            // save refresh token
            refreshTokenRepository.save(refreshToken);
        }

        return refreshToken;
    }

    public RefreshToken verifyRefreshToken(String refreshToken) {

        RefreshToken refreshTokenOb = refreshTokenRepository.findByRefreshToken(refreshToken).orElseThrow(() -> new TokenException("Refresh token not exists"));

        if (refreshTokenOb.getExpirationTime().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(refreshTokenOb);
            throw new TokenException("Refresh token expired");
        }

        return refreshTokenOb;
    }


}

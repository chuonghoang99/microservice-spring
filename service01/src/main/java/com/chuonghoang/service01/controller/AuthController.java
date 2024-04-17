package com.chuonghoang.service01.controller;

import com.chuonghoang.service01.service.AuthService;
import com.chuonghoang.service01.service.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.chuonghoang.service01.common.response.ResponseData;
import com.chuonghoang.service01.config.local.Translator;
import com.chuonghoang.service01.dto.request.LoginRequest;
import com.chuonghoang.service01.dto.request.RefreshTokenRequest;
import com.chuonghoang.service01.dto.request.RegisterRequest;
import com.chuonghoang.service01.dto.response.AuthResponse;
import com.chuonghoang.service01.entities.RefreshToken;
import com.chuonghoang.service01.entities.User;
import com.chuonghoang.service01.service.RefreshTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final RefreshTokenService refreshTokenService;

    private final JwtService jwtService;

    // endpoint to register new user
    @PostMapping("/register")
    @Operation(summary = "API register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    // endpoint to authenticate user for login
    @PostMapping("/authenticate")
    public ResponseData<?> authenticate(@Valid @RequestBody LoginRequest request) {
        var data = authService.authenticate(request);

        return new ResponseData<>(HttpStatus.OK.value(), Translator.toLocale((
                "login.success"
        )));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(@RequestBody RefreshTokenRequest request) {

        RefreshToken refreshToken = refreshTokenService.verifyRefreshToken(request.getRefreshToken());
        User user = refreshToken.getUser();

        String token = this.jwtService.generateToken(user);

        return ResponseEntity.ok(AuthResponse.builder()
                .refreshToken(refreshToken.getRefreshToken())
                .token(token)
                .build());
    }
}


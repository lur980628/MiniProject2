package com.rookies4.MiniProject2.controller;

import com.rookies4.MiniProject2.domain.User;
import com.rookies4.MiniProject2.dto.UserRegisterDto;
import com.rookies4.MiniProject2.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegisterDto registerDto) {
        try {
            User newUser = new User();
            newUser.setUsername(registerDto.getUsername());
            newUser.setPassword(registerDto.getPassword());
            newUser.setNickname(registerDto.getNickname());

            authService.registerUser(newUser);
            return new ResponseEntity<>("회원가입이 성공적으로 완료되었습니다.", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
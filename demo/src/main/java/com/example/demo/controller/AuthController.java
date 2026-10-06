package com.example.demo.controller;

import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.dto.SignUpResponse;
import com.example.demo.dto.LoginResponse;


@RestController
public class AuthController{
    // this needs the service
    private final AuthService service;
    AuthController(AuthService sv){this.service = sv;}


    @PostMapping("/auth/login")
    // valid to validate the body
    ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest req) {
        LoginResponse res = service.login(req);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/auth/signup")
    ResponseEntity<SignUpResponse> signup(@Valid @RequestBody SignupRequest req) {
        SignUpResponse res = service.signup(req);
        return ResponseEntity.ok(res);
    }

}

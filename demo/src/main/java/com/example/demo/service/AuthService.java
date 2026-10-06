package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService{
    private final UserRepository userRepo; // this is like db querier
    // it needs jwt token, written as jwt.secret=${JWT_SECRET} in application.properties
    @Value("${jwt.secret}")
    private String jwtSecret;

    // empty initialisation
    AuthService(UserRepository u){this.userRepo= u;}
    public LoginResponse login(LoginRequest req){
        // 1. find user by email
        // 2. check password
        // 3. generate JWT
        // 4. return LoginResponse with token
    }

    public SignUpResponse signup(SignUpRequest req){
        // 1. check email not already taken
        // 2. hash password
        // 3. save user
        // 4. return LoginResponse with token

    }

}

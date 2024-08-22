package com.VirtualSchool.vschool.controller;

import com.VirtualSchool.vschool.model.request.LoginRequest;
import com.VirtualSchool.vschool.model.request.RegisterRequest;
import com.VirtualSchool.vschool.model.response.AuthenticationResponse;
import com.VirtualSchool.vschool.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        System.out.println("register in autController");
        try {
            userService.register(registerRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("login in authController");
        try {
            var auth=userService.authenticate(loginRequest);
            return ResponseEntity.ok(auth);
        }catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

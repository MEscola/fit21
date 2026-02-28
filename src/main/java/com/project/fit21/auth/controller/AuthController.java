package com.project.fit21.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fit21.auth.DTO.LoginRequestDTO;
import com.project.fit21.auth.DTO.LoginResponseDTO;
import com.project.fit21.auth.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (
        @RequestBody @Valid LoginRequestDTO request) {

            LoginResponseDTO response = authService.login(request);
            return ResponseEntity.ok(response);     
        }

}

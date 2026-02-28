package com.project.fit21.auth.service;

import org.springframework.stereotype.Service;

import com.project.fit21.auth.DTO.LoginRequestDTO;
import com.project.fit21.auth.DTO.LoginResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultAuthService implements AuthService {

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) { 
        return null;   
}
}
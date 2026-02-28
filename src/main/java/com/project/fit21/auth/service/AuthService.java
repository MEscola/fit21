package com.project.fit21.auth.service;

import com.project.fit21.auth.DTO.LoginRequestDTO;
import com.project.fit21.auth.DTO.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO request);

}

package com.project.fit21.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fit21.user.dto.UserRequestDTO;
import com.project.fit21.user.dto.UserResponseDTO;
import com.project.fit21.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(
        @RequestBody @Valid UserRequestDTO request) {
            
            UserResponseDTO response = userService.create(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> list() {
        return ResponseEntity.ok(userService.list());
    }

}

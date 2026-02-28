package com.project.fit21.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.fit21.user.dto.UserRequestDTO;
import com.project.fit21.user.dto.UserResponseDTO;
import com.project.fit21.user.entity.User;
import com.project.fit21.user.exception.EmailAlreadyExistsException;
import com.project.fit21.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO create(UserRequestDTO request) {

        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new EmailAlreadyExistsException("Este email ja existe!" + request.email());
        }

        // CONVERTER DTO PARA ENTIDADE

        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();

        // SALVAR USUÁRIO NO BANCO DE DADOS
        User savedUser = userRepository.save(user);

        // CONVERTER ENTIDADE PARA DTO DE RESPOSTA(usa o @builder no UserResponseDTO)
        return convertToResponseDTO(savedUser);
    }

    // CONVERTE A LISTA DE USUÁRIOS PARA DTO DE RESPOSTA
    public List<UserResponseDTO> list() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .toList();
    }

    private UserResponseDTO convertToResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail());
    }
}
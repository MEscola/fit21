package com.project.fit21.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.fit21.user.entity.User;
import com.project.fit21.user.exception.EmailAlreadyExistsException;
import com.project.fit21.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user) {

        userRepository.findByEmail(user.getEmail())
            .ifPresent(u -> {
                throw new EmailAlreadyExistsException(user.getEmail());
            });

        return userRepository.save(user);
    }

    public List<User> list() {
        return userRepository.findAll();
    }

}

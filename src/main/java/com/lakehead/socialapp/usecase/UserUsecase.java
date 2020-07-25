package com.lakehead.socialapp.usecase;

import com.lakehead.socialapp.entity.UserEntity;
import com.lakehead.socialapp.usecase.port.repository.UserRepository;

import java.util.Optional;

public class UserUsecase {

    private final UserRepository userRepository;

    public UserUsecase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> info(Long id) {
        return userRepository.findById(id);
    }
}

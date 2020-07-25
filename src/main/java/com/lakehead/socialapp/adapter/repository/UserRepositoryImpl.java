package com.lakehead.socialapp.adapter.repository;

import com.lakehead.socialapp.entity.UserEntity;
import com.lakehead.socialapp.usecase.port.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<UserEntity> findById(Long id) {
        return Optional.empty();
    }
}

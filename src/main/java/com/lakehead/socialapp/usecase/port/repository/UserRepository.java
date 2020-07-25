package com.lakehead.socialapp.usecase.port.repository;

import com.lakehead.socialapp.entity.UserEntity;

import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> findById(Long id);
}

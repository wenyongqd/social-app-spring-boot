package com.lakehead.socialapp.usecase.port.repository;

import com.lakehead.socialapp.entity.ImageEntity;

import java.util.Optional;

public interface ImageRepository {
    Optional<ImageEntity> findById(Long id);
}

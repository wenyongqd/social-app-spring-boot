package com.lakehead.socialapp.adapter.repository;

import com.lakehead.socialapp.entity.ImageEntity;
import com.lakehead.socialapp.usecase.port.repository.ImageRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImageRepositoryImpl implements ImageRepository {
    @Override
    public Optional<ImageEntity> findById(Long id) {
        return Optional.empty();
    }
}

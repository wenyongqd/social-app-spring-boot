package com.lakehead.socialapp.usecase;

import com.lakehead.socialapp.entity.ImageEntity;
import com.lakehead.socialapp.usecase.port.repository.ImageRepository;

import java.util.Optional;

public class ImageUsecase {
    private final ImageRepository imageRepository;


    public ImageUsecase(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Optional<ImageEntity> info(Long id){
        return imageRepository.findById(id);
    }
}

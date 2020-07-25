package com.lakehead.socialapp.adapter.controller.dto;

import com.lakehead.socialapp.entity.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {

    private Long id;

    private String url;

    private LocalDateTime createdAt;

    private Long userId;

    public static ImageDto fromEntity(ImageEntity imageEntity){
        return ImageDto.builder().id(imageEntity.getId()).url(imageEntity.getUrl()).createdAt(imageEntity.getCreatedAt()).userId(imageEntity.getUserId()).build();
    }

    public ImageEntity toEntity(){
        return ImageEntity.builder().id(id).url(url).createdAt(createdAt).userId(userId).build();
    }
}

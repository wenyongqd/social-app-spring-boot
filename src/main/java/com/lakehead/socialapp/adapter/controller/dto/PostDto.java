package com.lakehead.socialapp.adapter.controller.dto;

import com.lakehead.socialapp.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;

    private Long userId;

    private String title;

    private String titlepic;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long postClassId;

    private UserDto user;

    @Builder.Default
    private List<ImageDto> image = List.of();

    private PostStatDto stat;

    private Boolean liked;

    public static PostDto fromEntity(PostEntity postEntity) {
        return PostDto.builder().id(postEntity.getId()).userId(postEntity.getUserId()).title(postEntity.getTitle()).titlepic(postEntity.getTitlepic()).createdAt(postEntity.getCreatedAt())
                .updatedAt(postEntity.getUpdatedAt()).postClassId(postEntity.getPostClassId()).build();
    }


}

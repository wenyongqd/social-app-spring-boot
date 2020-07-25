package com.lakehead.socialapp.adapter.controller.dto;

import com.lakehead.socialapp.entity.PostStatEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostStatDto {

    private Long id;

    private Long postId;

    private Long likeCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static PostStatDto fromEntity(PostStatEntity postStatEntity) {
        return PostStatDto.builder().id(postStatEntity.getId()).postId(postStatEntity.getPostId())
                .likeCount(postStatEntity.getLikeCount()).createdAt(postStatEntity.getCreatedAt())
                .updatedAt(postStatEntity.getUpdatedAt()).build();
    }

    public PostStatEntity toEntity() {
        return PostStatEntity.builder().id(id).postId(postId).likeCount(likeCount)
                .createdAt(createdAt).updatedAt(updatedAt).build();
    }
}

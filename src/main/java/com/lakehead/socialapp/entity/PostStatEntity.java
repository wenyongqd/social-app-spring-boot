package com.lakehead.socialapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostStatEntity {
    private Long id;

    private Long postId;

    @Builder.Default
    private Long likeCount = 0L;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

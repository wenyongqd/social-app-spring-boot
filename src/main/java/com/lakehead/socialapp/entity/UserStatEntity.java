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
public class UserStatEntity {
    private Long id;

    private Long userId;

    @Builder.Default
    private Long postCount = 0L;

    @Builder.Default
    private Long likeCount = 0L;

    @Builder.Default
    private Long followingCount = 0L;

    @Builder.Default
    private Long followerCount = 0L;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

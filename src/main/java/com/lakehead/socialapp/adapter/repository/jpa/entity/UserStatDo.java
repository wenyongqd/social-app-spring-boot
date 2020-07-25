package com.lakehead.socialapp.adapter.repository.jpa.entity;

import com.lakehead.socialapp.entity.UserStatEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "UserStat")
@Table(name = "user_stat")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserStatDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long postCount;

    private Long likeCount;

    private Long followingCount;

    private Long followerCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null)
            createdAt = LocalDateTime.now();
    }

    public static UserStatDo fromEntity(UserStatEntity fileEntity) {
        return UserStatDo.builder().id(fileEntity.getId()).userId(fileEntity.getUserId())
                .postCount(fileEntity.getPostCount()).likeCount(fileEntity.getLikeCount())
                .followingCount(fileEntity.getFollowingCount())
                .followerCount(fileEntity.getFollowerCount()).createdAt(fileEntity.getCreatedAt())
                .updatedAt(fileEntity.getUpdatedAt()).build();
    }

    public UserStatEntity toEntity() {
        return UserStatEntity.builder().id(id).userId(userId).postCount(postCount)
                .likeCount(likeCount).followingCount(followingCount).followerCount(followerCount)
                .createdAt(createdAt).updatedAt(updatedAt).build();
    }

}

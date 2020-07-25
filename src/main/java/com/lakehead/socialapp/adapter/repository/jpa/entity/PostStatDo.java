package com.lakehead.socialapp.adapter.repository.jpa.entity;

import com.lakehead.socialapp.entity.PostStatEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "PostStat")
@Table(name = "post_stat")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostStatDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;

    private Long likeCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null)
            createdAt = LocalDateTime.now();
    }

    public static PostStatDo fromEntity(PostStatEntity fileEntity) {
        return PostStatDo.builder().id(fileEntity.getId()).postId(fileEntity.getPostId()).likeCount(fileEntity.getLikeCount())
                .createdAt(fileEntity.getCreatedAt()).updatedAt(fileEntity.getUpdatedAt()).build();
    }

    public PostStatEntity toEntity() {
        return PostStatEntity.builder().id(id).postId(postId).likeCount(likeCount)
                .createdAt(createdAt).updatedAt(updatedAt).build();
    }


}

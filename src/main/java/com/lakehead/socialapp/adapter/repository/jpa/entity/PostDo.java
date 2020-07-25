package com.lakehead.socialapp.adapter.repository.jpa.entity;

import com.lakehead.socialapp.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Post")
@Table(name = "post")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String title;

    private String titlepic;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long postClassId;

    @PrePersist
    public void prePersist() {
        if (titlepic == null)
            titlepic = "";
        if (createdAt == null)
            createdAt = LocalDateTime.now();
        if (updatedAt == null)
            updatedAt = LocalDateTime.now();
    }

    public static PostDo fromEntity(PostEntity userEntity) {
        return PostDo.builder().id(userEntity.getId()).userId(userEntity.getUserId()).title(userEntity.getTitle())
                .titlepic(userEntity.getTitlepic()).createdAt(userEntity.getCreatedAt()).updatedAt(userEntity.getUpdatedAt()).postClassId(userEntity.getPostClassId()).build();
    }

    public PostEntity toEntity() {
        return PostEntity.builder().id(id).userId(userId).title(title).titlepic(titlepic).createdAt(createdAt).updatedAt(updatedAt).postClassId(postClassId).build();
    }

}

package com.lakehead.socialapp.adapter.repository.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "PostImage")
@Table(name = "postimage")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostImageDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;

    private Long imageId;

    private LocalDateTime createdAt;

}

package com.lakehead.socialapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {

    private Long id;

    private Long userId;

    private String title;

    private String titlepic;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long postClassId;

}

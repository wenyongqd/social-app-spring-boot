package com.lakehead.socialapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {

    private Integer id;

    private Integer userId;

    private Integer fid;

    private Integer fnum;

    private String data;

    private LocalDateTime createdAt;

    private Integer postId;
}

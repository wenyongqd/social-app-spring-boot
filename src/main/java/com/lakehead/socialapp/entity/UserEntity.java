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
public class UserEntity {

    private Long id;

    private String userName;

    private Long userPic;

    private String password;

    private String phone;

    private String email;

    private int status;

    private LocalDateTime createAt;
}

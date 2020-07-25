package com.lakehead.socialapp.adapter.repository.jpa.entity;

import com.lakehead.socialapp.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Adsense")
@Table(name = "adsense")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdsenseDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long src;

    private Long url;

    private int type;

    private LocalDateTime createdAt;

}

package com.lakehead.socialapp.usecase;

import com.lakehead.socialapp.entity.PostStatEntity;
import com.lakehead.socialapp.usecase.port.repository.PostStatRepository;
import com.lakehead.socialapp.usecase.port.repository.UserStatRepository;

import java.time.LocalDateTime;

public class StatUsecase {

    private final UserStatRepository userStatRepository;
    private final PostStatRepository postStatRepository;

    public StatUsecase(UserStatRepository userStatRepository, PostStatRepository postStatRepository) {
        this.userStatRepository = userStatRepository;
        this.postStatRepository = postStatRepository;
    }

    public PostStatEntity postStatInfoByPostId(Long postId) {
        var postStatEntity = postStatRepository.findByPostId(postId);
        if (postStatEntity.isEmpty()) {
            return PostStatEntity.builder().id(0L).postId(postId).createdAt(LocalDateTime.now())
                    .build();
        }

        return postStatEntity.get();
    }
}

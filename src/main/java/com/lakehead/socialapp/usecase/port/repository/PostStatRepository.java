package com.lakehead.socialapp.usecase.port.repository;

import com.lakehead.socialapp.entity.PostStatEntity;

import java.util.Optional;

public interface PostStatRepository {
    Optional<PostStatEntity> findByPostId(Long postId);
}


package com.lakehead.socialapp.usecase.port.repository;

import com.lakehead.socialapp.entity.PostEntity;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    PostEntity save(PostEntity postEntity);

    void delete(Long id);

    Optional<PostEntity> findById(Long id);

    Optional<PostEntity> findAll();

    List<PostEntity> following(Long userId, Long limit);

    List<PostEntity> suggest(Long likeCount);

    List<PostEntity> published(Long userId);

    List<PostEntity> postlist(Long limit);

    List<PostEntity> hot(Long likeCount);

    void like(Long userId, Long postId);

    void unlike(Long userId, Long postId);

    List<PostEntity> liked(Long userId);

    Long likedCount(Long userId);

    Long followingCount(Long userId);

    Boolean isLiked(Long userId, Long postId);



}

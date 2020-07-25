package com.lakehead.socialapp.adapter.repository.jpa;

import com.lakehead.socialapp.adapter.repository.jpa.entity.PostLikeDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostLikeJpaRepository
        extends JpaRepository<PostLikeDo, Long>, QuerydslPredicateExecutor<PostLikeDo> {
    @Transactional
    void deleteByUserIdAndPostId(Long userId, Long postId);

    Boolean existsByUserIdAndPostId(Long userId, Long postId);
}

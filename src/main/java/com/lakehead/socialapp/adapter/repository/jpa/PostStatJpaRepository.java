package com.lakehead.socialapp.adapter.repository.jpa;

import com.lakehead.socialapp.adapter.repository.jpa.entity.PostStatDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostStatJpaRepository extends JpaRepository<PostStatDo, Long>, QuerydslPredicateExecutor<PostStatDo> {
    Optional<PostStatDo> findByPostId(Long postId);
}

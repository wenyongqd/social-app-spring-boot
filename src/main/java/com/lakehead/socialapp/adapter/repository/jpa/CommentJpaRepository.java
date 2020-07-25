package com.lakehead.socialapp.adapter.repository.jpa;

import com.lakehead.socialapp.adapter.repository.jpa.entity.CommentDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentJpaRepository extends JpaRepository<CommentDo, Integer>, QuerydslPredicateExecutor<CommentDo> {
}

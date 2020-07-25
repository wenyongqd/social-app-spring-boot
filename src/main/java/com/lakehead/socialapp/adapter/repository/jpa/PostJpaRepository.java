package com.lakehead.socialapp.adapter.repository.jpa;

import com.lakehead.socialapp.adapter.repository.jpa.entity.PostDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PostJpaRepository extends JpaRepository<PostDo, Long>, QuerydslPredicateExecutor<PostDo> {
}

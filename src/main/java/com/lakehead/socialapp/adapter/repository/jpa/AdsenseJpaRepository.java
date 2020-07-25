package com.lakehead.socialapp.adapter.repository.jpa;

import com.lakehead.socialapp.adapter.repository.jpa.entity.AdsenseDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsenseJpaRepository extends JpaRepository<AdsenseDo, Integer>, QuerydslPredicateExecutor<AdsenseDo> {
}

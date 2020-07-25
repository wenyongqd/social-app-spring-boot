package com.lakehead.socialapp.adapter.repository.jpa.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration(proxyBeanMethods = false)
@EntityScan("com.lakehead.socialapp.adapter.repository.jpa.entity")
@EnableJpaRepositories("com.lakehead.socialapp.adapter.repository.jpa")
public class JpaConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}


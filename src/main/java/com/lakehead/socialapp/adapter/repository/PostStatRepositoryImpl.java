package com.lakehead.socialapp.adapter.repository;

import com.lakehead.socialapp.adapter.repository.jpa.PostStatJpaRepository;
import com.lakehead.socialapp.adapter.repository.jpa.entity.PostStatDo;
import com.lakehead.socialapp.entity.PostEntity;
import com.lakehead.socialapp.entity.PostStatEntity;
import com.lakehead.socialapp.usecase.port.repository.PostStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostStatRepositoryImpl implements PostStatRepository {

    @Autowired
    public PostStatJpaRepository postStatJpaRepository;

    @Override
    public Optional<PostStatEntity> findByPostId(Long postId) {
        return postStatJpaRepository.findByPostId(postId).map(PostStatDo->PostStatDo.toEntity());
    }
}

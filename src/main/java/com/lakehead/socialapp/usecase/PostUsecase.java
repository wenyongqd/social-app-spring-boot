package com.lakehead.socialapp.usecase;

import com.lakehead.socialapp.entity.PostEntity;
import com.lakehead.socialapp.usecase.port.repository.PostRepository;

import java.util.List;

public class PostUsecase {
    private final PostRepository postRepository;

    public PostUsecase(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostEntity publish(PostEntity postEntity) {
        var post =  PostEntity.builder().userId(postEntity.getUserId()).title(postEntity.getTitle()).titlepic(postEntity.getTitlepic())
                .postClassId(postEntity.getPostClassId()).build();
        return postRepository.save(post);
    }

    public List<PostEntity> following(Long userId, Long limit) {
        return postRepository.following(userId, limit);
    }

    public List<PostEntity> hot(Long likeCount) {
        return postRepository.hot(likeCount);
    }

    public List<PostEntity> suggest(Long likeCount) {
        return postRepository.suggest(likeCount);
    }

    public List<PostEntity> postlist(Long limit) {
        return postRepository.postlist(limit);
    }


}

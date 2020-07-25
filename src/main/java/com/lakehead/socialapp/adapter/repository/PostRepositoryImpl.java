package com.lakehead.socialapp.adapter.repository;

import com.lakehead.socialapp.adapter.repository.jpa.ListPostJpaRepository;
import com.lakehead.socialapp.adapter.repository.jpa.PostJpaRepository;
import com.lakehead.socialapp.adapter.repository.jpa.PostLikeJpaRepository;
import com.lakehead.socialapp.adapter.repository.jpa.entity.PostDo;
import com.lakehead.socialapp.adapter.repository.jpa.entity.QPostDo;
import com.lakehead.socialapp.adapter.repository.jpa.entity.QUserFollowDo;
import com.lakehead.socialapp.entity.PostEntity;
import com.lakehead.socialapp.usecase.port.repository.PostRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PostRepositoryImpl implements PostRepository {

    private JPAQueryFactory jpaQueryFactory;
    private PostJpaRepository postJpaRepo;
    private PostLikeJpaRepository postLikeJpaRepo;
    @Autowired
    private ListPostJpaRepository listPostJpaRepo;

    public PostRepositoryImpl(JPAQueryFactory jpaQueryFactory, PostJpaRepository postJpaRepo,
                              PostLikeJpaRepository postLikeJpaRepo) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.postJpaRepo = postJpaRepo;
        this.postLikeJpaRepo = postLikeJpaRepo;
    }

    @Override
    public PostEntity save(PostEntity postEntity) {
        return postJpaRepo.save(PostDo.fromEntity(postEntity)).toEntity();
    }

    @Override
    public void delete(Long id) {
        postJpaRepo.deleteById(id);
    }

    @Override
    public List<PostEntity> postlist(Long limit) {
        // 实现排序和分页
        Pageable pageable = PageRequest.of(0, 2);

        Page<PostDo> productPage = listPostJpaRepo.findAll(pageable);

        List<PostDo> listProduct = productPage.getContent();

        return listProduct.stream().map(postDo -> postDo.toEntity()).collect(Collectors.toList());
    }

    @Override
    public Optional<PostEntity> findById(Long id) {
        return postJpaRepo.findById(id).map(postDo -> postDo.toEntity());
    }

    @Override
    public Optional<PostEntity> findAll() {
        return Optional.empty();
    }

    private JPAQuery<PostDo> followingQuery(Long userId) {
        var post = QPostDo.postDo;
        var userFollow = QUserFollowDo.userFollowDo;
        var query = jpaQueryFactory.selectFrom(post).join(userFollow)
                .on(post.userId.eq(userFollow.followingId)).where(userFollow.followerId.eq(userId));
        return query;
    }

    @Override
    public List<PostEntity> following(Long userId, Long limit) {
        var query = followingQuery(userId);
        var post = QPostDo.postDo;
        query.orderBy(post.id.desc());
        if (limit != null) {
            query.limit(limit);
        }
        return query.fetch().stream().map(postDo -> postDo.toEntity()).collect(Collectors.toList());
    }

    @Override
    public List<PostEntity> suggest(Long likeCount) {
        return null;
    }

    @Override
    public List<PostEntity> published(Long userId) {
        return null;
    }

    @Override
    public List<PostEntity> hot(Long likeCount) {
        return null;
    }

    @Override
    public void like(Long userId, Long postId) {

    }

    @Override
    public void unlike(Long userId, Long postId) {

    }

    @Override
    public List<PostEntity> liked(Long userId) {
        return null;
    }

    @Override
    public Long likedCount(Long userId) {
        return null;
    }

    @Override
    public Long followingCount(Long userId) {
        return null;
    }

    @Override
    public Boolean isLiked(Long userId, Long postId) {
        return null;
    }
}

package com.lakehead.socialapp.adapter.controller;

import com.lakehead.socialapp.adapter.controller.dto.ImageDto;
import com.lakehead.socialapp.adapter.controller.dto.PostDto;
import com.lakehead.socialapp.adapter.controller.dto.PostStatDto;
import com.lakehead.socialapp.adapter.repository.jpa.ListPostJpaRepository;
import com.lakehead.socialapp.entity.ImageEntity;
import com.lakehead.socialapp.entity.PostEntity;
import com.lakehead.socialapp.usecase.ImageUsecase;
import com.lakehead.socialapp.usecase.PostUsecase;
import com.lakehead.socialapp.usecase.StatUsecase;
import com.lakehead.socialapp.usecase.UserUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
abstract public class AbstractController {

    @Autowired
    protected PostUsecase postUsecase;

    @Autowired
    protected UserUsecase userUsecase;

    @Autowired
    protected StatUsecase statUsecase;

    @Autowired
    protected ImageUsecase imageUsecase;

    protected PostDto fullPostDto(PostEntity postEntity) {
        var postDto = PostDto.fromEntity(postEntity);

        var user = userUsecase.info(postDto.getId());

        postDto.setImage(imageUsecase.info(postDto.getUserId()).stream().map(this::fullImageDto).collect(Collectors.toList()));

        postDto.setStat(PostStatDto.fromEntity(statUsecase.postStatInfoByPostId(postDto.getId())));
        // ？？？？
        postDto.setLiked(true);

        return postDto;
    }

    protected ImageDto  fullImageDto(ImageEntity imageEntity) {
        var imageDto = ImageDto.fromEntity(imageEntity);
        return imageDto;
    }



}

package com.lakehead.socialapp.adapter.controller;

import com.lakehead.socialapp.adapter.controller.dto.RootDto;
import com.lakehead.socialapp.entity.PostEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
@Api(tags = "Post Apis")
public class PostController extends AbstractController{

    @GetMapping("/postlist")
    @ApiOperation("Posts published by users which are followed by current user")
    public RootDto postList(@RequestParam(defaultValue = "10") Long limit) {
        List<PostEntity> postEntities = postUsecase.postlist(limit);

        return new RootDto().addDataEntry("posts",postEntities.stream().map(this::fullPostDto).collect(Collectors.toList()));
    }
}

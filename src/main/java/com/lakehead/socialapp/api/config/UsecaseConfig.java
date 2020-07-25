package com.lakehead.socialapp.api.config;

import com.lakehead.socialapp.usecase.ImageUsecase;
import com.lakehead.socialapp.usecase.PostUsecase;
import com.lakehead.socialapp.usecase.StatUsecase;
import com.lakehead.socialapp.usecase.UserUsecase;
import com.lakehead.socialapp.usecase.port.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsecaseConfig {
    @Bean
    public PostUsecase postUsecase(PostRepository postRepository) {
        return new PostUsecase(postRepository);
    }

    @Bean
    public UserUsecase userUsecase(UserRepository userRepository) { return new UserUsecase(userRepository); }

    @Bean
    public StatUsecase statUsecase(UserStatRepository userStatRepository, PostStatRepository postStatRepository) {
        return new StatUsecase(userStatRepository, postStatRepository);
    }

    @Bean
    public ImageUsecase imageUsecase(ImageRepository imageRepository) {
        return new ImageUsecase(imageRepository);
    }
}

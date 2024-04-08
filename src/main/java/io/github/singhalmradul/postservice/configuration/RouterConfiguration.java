package io.github.singhalmradul.postservice.configuration;

import static org.springframework.web.servlet.function.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import io.github.singhalmradul.postservice.handlers.PostHandler;

@Configuration
public class RouterConfiguration {

    @Bean
    RouterFunction<ServerResponse> likeRouter(PostHandler handler) {

        return (
            route()
            .path("/posts", builder -> builder
                .GET("/{id}/exists", handler::postExists)
            )
            .path("/users/{userId}/posts", builder -> builder
                .GET("/feed", handler::getFeed)
                .GET(handler::getPostsByUser)
            )
            .build()
        );
    }
}

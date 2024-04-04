package io.github.singhalmradul.postservice.model;

import java.time.Instant;
import java.util.UUID;

public record PostRecord(
    String text,
    String image,
    int likes,
    int comments,
    UUID id,
    User user,
    Instant createdAt,
    boolean isLiked
) {

    public PostRecord(Post post, User user, int likes, boolean isLiked) {
        this(
            post.getText(),
            post.getImage(),
            likes,
            post.getComments(),
            post.getId(),
            user,
            post.getCreatedAt(),
            isLiked
        );
    }
}
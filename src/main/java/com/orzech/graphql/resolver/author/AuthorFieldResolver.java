package com.orzech.graphql.resolver.author;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.orzech.graphql.dto.AuthorDto;
import com.orzech.graphql.dto.CommentDto;
import com.orzech.graphql.dto.PostDto;
import com.orzech.graphql.service.PostService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class AuthorFieldResolver implements GraphQLResolver<AuthorDto> {

    private final PostService postService;

    public AuthorFieldResolver(PostService postService) {
        this.postService = postService;
    }

    public List<PostDto> posts(AuthorDto authorDto) {
        return postService.findAllPostsByAuthorId(authorDto.getId());
//        return Collections.singletonList(PostDto.builder()
//                .id(UUID.randomUUID())
//                .title("Post title")
//                .description("Post Description")
//                .category("Post Category")
//                .authorId(authorDto.getId())
//                .build());
    }

    public Integer postCount(AuthorDto authorDto) {
        return postService.countAuthorPosts(authorDto.getId());
    }

    public List<CommentDto> comments(AuthorDto authorDto, Integer lastComments) {
        return Collections.singletonList(CommentDto.builder()
                .id(UUID.randomUUID())
                .text("Some random text")
                .build());
    }
}

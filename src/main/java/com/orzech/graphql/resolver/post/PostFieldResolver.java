package com.orzech.graphql.resolver.post;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.orzech.graphql.dto.AuthorDto;
import com.orzech.graphql.dto.CommentDto;
import com.orzech.graphql.dto.PostDto;
import com.orzech.graphql.repository.CommentRepository;
import com.orzech.graphql.service.AuthorService;
import com.orzech.graphql.service.CommentService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class PostFieldResolver implements GraphQLResolver<PostDto> {

    private final AuthorService authorService;
    private final CommentService commentService;

    public PostFieldResolver(AuthorService authorService, CommentService commentRepository) {
        this.authorService = authorService;
        this.commentService = commentRepository;
    }

    public AuthorDto author(PostDto post) {
        return authorService.getAuthorById(post.getAuthorId());
//        return AuthorDto.builder()
//                .id(UUID.randomUUID())
//                .name("Author Name")
//                .email("Author@email.com")
//                .build();
    }

    public List<CommentDto> comments(PostDto post, Integer lastNComments) {
        return commentService.getNLastPostComments(post.getId(), lastNComments);
//        return Collections.singletonList(CommentDto.builder()
//                .id(UUID.randomUUID())
//                .text("Random Text")
//                .build());
    }

}

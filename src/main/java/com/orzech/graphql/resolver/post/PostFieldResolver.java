package com.orzech.graphql.resolver.post;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.orzech.graphql.dto.AuthorDto;
import com.orzech.graphql.dto.PostDto;
import com.orzech.graphql.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class PostFieldResolver implements GraphQLResolver<PostDto> {

    private final AuthorService authorService;

    public PostFieldResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public AuthorDto author(PostDto post) {
        return authorService.getAuthorById(post.getAuthorId());
//        return AuthorDto.builder()
//                .id(UUID.randomUUID())
//                .name("Author Name")
//                .email("Author@email.com")
//                .build();
    }
}

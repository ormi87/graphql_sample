package com.orzech.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.orzech.graphql.dto.AuthorDto;
import com.orzech.graphql.dto.PostDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PostFieldResolver implements GraphQLResolver<PostDto> {
    public AuthorDto author(PostDto post) {
        return AuthorDto.builder()
                .id(UUID.randomUUID())
                .name("Author Name")
                .email("Author@email.com")
                .build();
    }
}

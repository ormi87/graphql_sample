package com.orzech.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.orzech.graphql.dto.AuthorDto;
import com.orzech.graphql.dto.PostDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class AuthorFieldResolver implements GraphQLResolver<AuthorDto> {
    public List<PostDto> posts(AuthorDto authorDto) {
        return Collections.singletonList(PostDto.builder()
                .id(UUID.randomUUID())
                .title("Post title")
                .description("Post Description")
                .category("Post Category")
                .authorId(authorDto.getId())
                .build());

    }
}

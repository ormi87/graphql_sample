package com.orzech.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.orzech.graphql.dto.AuthorDto;
import com.orzech.graphql.service.AuthorService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {

    private final AuthorService authorService;

    public AuthorQueryResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<AuthorDto> authors(){
        return authorService.getAuthors();
//        return Collections.singletonList(AuthorDto.builder()
//                .id(UUID.randomUUID())
//                .name("Author Name")
//                .email("Author@email.com")
//                .build());
    }
}

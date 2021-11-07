package com.orzech.graphql.resolver.author;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.orzech.graphql.dto.AuthorDto;
import com.orzech.graphql.service.AuthorService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {

    private final AuthorService authorService;

    public AuthorMutationResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public UUID createAuthor(AuthorDto author){
        return authorService.createNewAuthor(author);
    }
}

package com.orzech.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.orzech.graphql.dto.AuthorDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {

    public UUID createAuthor(AuthorDto author){
        return UUID.randomUUID();
    }
}

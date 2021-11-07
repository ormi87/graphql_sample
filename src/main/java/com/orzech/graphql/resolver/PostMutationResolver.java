package com.orzech.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.orzech.graphql.dto.PostDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PostMutationResolver implements GraphQLMutationResolver {

    public UUID createPost(PostDto post){
        return UUID.randomUUID();
    }
}

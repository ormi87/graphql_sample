package com.orzech.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.orzech.graphql.dto.PostDto;
import com.orzech.graphql.service.PostService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PostMutationResolver implements GraphQLMutationResolver {

    private final PostService postService;

    public PostMutationResolver(PostService postService) {
        this.postService = postService;
    }

    public UUID createPost(PostDto post){
        return postService.createNewPost(post);
    }
}

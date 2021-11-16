package com.orzech.graphql.resolver.comment;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.orzech.graphql.dto.CommentDto;
import com.orzech.graphql.dto.PostDto;
import com.orzech.graphql.service.PostService;
import org.springframework.stereotype.Component;

@Component
public class CommentFieldResolver implements GraphQLResolver<CommentDto> {

    private final PostService postService;

    public CommentFieldResolver(PostService postService) {
        this.postService = postService;
    }

    public PostDto post(CommentDto commentDto){
        return postService.findPost(commentDto.getPostId());
    }

}

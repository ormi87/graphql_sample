package com.orzech.graphql.resolver.comment;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.orzech.graphql.dto.CommentDto;
import com.orzech.graphql.service.CommentService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentQueryResolver implements GraphQLQueryResolver {

    private final CommentService commentService;

    public CommentQueryResolver(CommentService commentService) {
        this.commentService = commentService;
    }

    public List<CommentDto> comments(Integer count, Integer offset){
        return commentService.getNLastComments(count, offset);
    }
}

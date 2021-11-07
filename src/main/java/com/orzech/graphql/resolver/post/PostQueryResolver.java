package com.orzech.graphql.resolver.post;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.orzech.graphql.dto.PostDto;
import com.orzech.graphql.service.PostService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostQueryResolver implements GraphQLQueryResolver {

    private final PostService postService;

    public PostQueryResolver(PostService postService) {
        this.postService = postService;
    }

    public List<PostDto> recentPost(Integer count, Integer offset) {
        return postService.getRecentPost(count, offset);
//        List<PostDto> allPost = postService.findAll();
//        return allPost.subList(offset, count + offset);
    }
}

package com.orzech.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.orzech.graphql.dto.PostDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class PostQueryResolver implements GraphQLQueryResolver {

    public List<PostDto> recentPost(Integer count, Integer offset){
        return Collections.singletonList(PostDto.builder()
                        .id(UUID.randomUUID())
                .build());
    }
}

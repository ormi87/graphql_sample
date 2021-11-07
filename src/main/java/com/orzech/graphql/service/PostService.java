package com.orzech.graphql.service;

import com.orzech.graphql.dto.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {
    public List<PostDto> findAllPostsByAuthorId(UUID authorId);
}

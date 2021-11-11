package com.orzech.graphql.service;

import com.orzech.graphql.dto.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {
    public List<PostDto> findAllPostsByAuthorId(UUID authorId);

    public List<PostDto> findAll();

    List<PostDto> getRecentPost(Integer count, Integer offset);

    UUID createNewPost(PostDto post);

    Integer countAuthorPosts(UUID id);
}

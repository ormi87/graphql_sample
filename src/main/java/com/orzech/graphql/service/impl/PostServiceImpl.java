package com.orzech.graphql.service.impl;

import com.orzech.graphql.dto.PostDto;
import com.orzech.graphql.model.Post;
import com.orzech.graphql.repository.PostRepository;
import com.orzech.graphql.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> findAllPostsByAuthorId(UUID authorId) {
        List<Post> allByAuthorId = postRepository.findAllByAuthorId(authorId);

        return allByAuthorId.stream()
                .map(post -> {
                    return PostDto.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .description(post.getDescription())
                            .category(post.getCategory())
                            .authorId(authorId)
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findAll() {
        List<Post> allPosts = postRepository.findAll();

        return allPosts.stream().map(post -> {
            return PostDto.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .description(post.getDescription())
                    .category(post.getCategory())
                    .authorId(post.getAuthor().getId())
                    .build();
        } ).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getRecentPost(Integer count, Integer offset) {
        Pageable pageable = PageRequest.of(offset ,count);
        Page<Post> all = postRepository.findAll(pageable);

        return all.stream().map(post -> {
            return PostDto.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .description(post.getDescription())
                    .category(post.getCategory())
                    .authorId(post.getAuthor().getId())
                    .build();
        } ).collect(Collectors.toList());

    }
}

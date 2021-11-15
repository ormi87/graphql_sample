package com.orzech.graphql.service.impl;

import com.orzech.graphql.dto.CommentDto;
import com.orzech.graphql.model.Comment;
import com.orzech.graphql.repository.CommentRepository;
import com.orzech.graphql.service.CommentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDto> getNLastAuthorComments(UUID authorId, Integer lastComments) {
        List<Comment> allByAuthor_id = commentRepository.findAllByAuthor_Id(authorId, PageRequest.of(0, lastComments));
        return allByAuthor_id.stream()
                .map(comment -> {
                    return CommentDto.builder()
                            .id(comment.getId())
                            .text(comment.getText())
                            .authorId(authorId)
                            .postId(comment.getPost().getId())
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getNLastPostComments(UUID postId, Integer lastComments) {
        List<Comment> allByPost_id = commentRepository.findAllByPost_Id(postId, PageRequest.of(0, lastComments));
        return allByPost_id.stream()
                .map(comment -> {
                    return CommentDto.builder()
                            .id(comment.getId())
                            .text(comment.getText())
                            .authorId(comment.getAuthor().getId())
                            .postId(postId)
                            .build();
                }).collect(Collectors.toList());
    }
}

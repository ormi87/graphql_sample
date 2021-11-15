package com.orzech.graphql.service;

import com.orzech.graphql.dto.CommentDto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.UUID;

public interface CommentService {

    public List<CommentDto> getNLastAuthorComments(UUID authorId, Integer lastComments);
    public List<CommentDto> getNLastPostComments(UUID postId, Integer lastComments);
}

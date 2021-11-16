package com.orzech.graphql.repository;

import com.orzech.graphql.model.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    public List<Comment> findAllByAuthor_Id(UUID authorID, Pageable pageable);

    List<Comment> findAllByPost_Id(UUID id, Pageable pageable);
}

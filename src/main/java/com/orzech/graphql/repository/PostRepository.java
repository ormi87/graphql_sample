package com.orzech.graphql.repository;

import com.orzech.graphql.dto.PostDto;
import com.orzech.graphql.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    public List<Post> findAllByAuthorId(UUID authorI);

}

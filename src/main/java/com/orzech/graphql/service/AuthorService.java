package com.orzech.graphql.service;

import com.orzech.graphql.dto.AuthorDto;

import java.util.List;
import java.util.UUID;

public interface AuthorService {

    public List<AuthorDto> getAuthors();

    AuthorDto getAuthorById(UUID authorId);

    UUID createNewAuthor(AuthorDto author);
}

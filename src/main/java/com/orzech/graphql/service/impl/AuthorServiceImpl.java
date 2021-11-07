package com.orzech.graphql.service.impl;

import com.orzech.graphql.dto.AuthorDto;
import com.orzech.graphql.model.Author;
import com.orzech.graphql.repository.AuthorRepository;
import com.orzech.graphql.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDto> getAuthors() {
        List<Author> allAuthors = authorRepository.findAll();

        return allAuthors.stream()
                .map(author -> {
                    return AuthorDto.builder()
                            .id(author.getId())
                            .name(author.getName())
                            .email(author.getEmail())
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(UUID authorId) {
        //check what is the difference between getById and findById
        Author byId = authorRepository.findById(authorId).get();

        return AuthorDto.builder()
                .id(byId.getId())
                .name(byId.getName())
                .email(byId.getEmail())
                .build();
    }

    @Override
    public UUID createNewAuthor(AuthorDto authorDto) {
        Author author = Author.builder()
                .email(authorDto.getEmail())
                .name(authorDto.getName())
                .build();

        Author authorSaved = authorRepository.saveAndFlush(author);
        return authorSaved.getId();
    }
}

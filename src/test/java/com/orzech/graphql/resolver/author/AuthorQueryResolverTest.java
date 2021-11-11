package com.orzech.graphql.resolver.author;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.orzech.graphql.TestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static com.orzech.graphql.Utils.readResponseFromFile;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestApplication.class)
class AuthorQueryResolverTest {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void shouldReturnAuthors() throws IOException {
        GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource("request/authors.graphqls");
        assertThat(graphQLResponse.isOk()).isTrue();
        assertThat(readResponseFromFile("response/authors.json")).isEqualToIgnoringWhitespace(graphQLResponse.getRawResponse().getBody());
    }
}
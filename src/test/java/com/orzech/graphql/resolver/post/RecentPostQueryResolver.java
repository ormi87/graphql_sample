package com.orzech.graphql.resolver.post;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.orzech.graphql.TestApplication;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static com.orzech.graphql.Utils.readResponseFromFile;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestApplication.class)
public class RecentPostQueryResolver {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    @Test
    void shouldReturnRecentPost() throws IOException {

        GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource("request/post-recent_query.graphqls");
        Assertions.assertThat(graphQLResponse.isOk()).isTrue();
        Assertions.assertThat(graphQLResponse.getRawResponse().getBody()).isEqualToIgnoringWhitespace(readResponseFromFile("response/post-recent-response.json"));
    }
}

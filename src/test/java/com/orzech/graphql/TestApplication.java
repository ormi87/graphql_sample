package com.orzech.graphql;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GraphqlApplication.class)
public class TestApplication {
}

package com.orzech.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HelloWorldQueryResolver implements GraphQLQueryResolver {

    public String helloWorld() {
        return "Sample return String from hello world query";
    }

    public String parametrizedQuery(String firstArg, String secondArg) {
        return String.format("Parametrized method %s %s", firstArg, Optional.ofNullable(secondArg).orElse(""));
    }
}

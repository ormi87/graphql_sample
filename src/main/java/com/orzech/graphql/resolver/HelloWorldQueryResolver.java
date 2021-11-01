package com.orzech.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldQueryResolver implements GraphQLQueryResolver {

    public String helloWorld() {
        return "Sample return String from hello world query";
    }
}

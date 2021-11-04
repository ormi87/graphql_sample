package com.orzech.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.orzech.graphql.dto.MessageDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class HelloWorldQueryResolver implements GraphQLQueryResolver {

    public String helloWorld() {
        return "Sample return String from hello world query";
    }

    public String parametrizedQuery(String firstArg, String secondArg) {
        return String.format("Parametrized method %s %s", firstArg, Optional.ofNullable(secondArg).orElse(""));
    }

    public MessageDto message(){
        return MessageDto.builder()
                .id(UUID.randomUUID())
                .text("Some random text")
                .build();
    }

    public List<Integer> someArray(){
        return Arrays.asList(1,2,3,4,5);
    }
}

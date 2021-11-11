package com.orzech.graphql;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Utils {
    public static String readResponseFromFile(String pathToFile) throws IOException {
        return IOUtils.toString(new ClassPathResource(pathToFile).getInputStream(), StandardCharsets.UTF_8);
    }
}

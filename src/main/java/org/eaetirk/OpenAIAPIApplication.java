package org.eaetirk;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class OpenAIAPIApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(OpenAIAPIApplication.class)
                .run(args);
    }

}
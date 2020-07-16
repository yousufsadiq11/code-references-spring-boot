package com.github.code.references;

import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CodeReferencesApplication {

    public static void main(String[] args) throws IOException, ParseException {
        SpringApplication.run(CodeReferencesApplication.class, args);
    }
    
}

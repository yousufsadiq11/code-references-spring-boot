package com.github.code.references;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.code.references.models.Service;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class CodeReferencesApplication {

    private static ObjectMapper objectMapper;

    public static void main(String[] args) throws IOException, ParseException {
        SpringApplication.run(CodeReferencesApplication.class, args);

        // get object mapper
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // convert json to string
        String jsonString = fetchResponseAndConvertToString();
        JSONObject obj = new JSONObject(jsonString);
        // fetch the required path ... add null checks wherever required
        String data = obj.getJSONObject("data").getJSONObject("service").toString();

        Service service = objectMapper.readValue(data, Service.class);
        // example usage... Iterate over the maps and get the required keys or use regex as key for the map to get the required property
        System.out.println("Storage ::: "+ service.get("STORAGE").get("resource_group").get("SQLSERVER-IAAS-PROD-01RG025"));
    }

    public static String fetchResponseAndConvertToString() throws IOException, ParseException {
        // sample response is stored in resources directory..fetching and converting it to json
        org.json.simple.parser.JSONParser parser = new JSONParser();
        org.json.simple.JSONObject data = (org.json.simple.JSONObject) parser.parse(
                new FileReader("src/main/resources/response.json"));
        return data.toString();
    }
}

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/callOtherMicroservices")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/usingRestTemplate")
    public void callOtherMicroservices(){
        String url = "http://localhost:9111/kafka/send/{message}";
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("message","RestTemplate has been used to call kafka producer from Spring Boot Application");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(httpHeaders);

        String response = restTemplate.postForObject(url, entity, String.class, uriVariables);
        System.out.println("response sent ");
    }
}

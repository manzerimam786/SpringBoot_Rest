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
public class WebClientController {

    @Autowired
    private WebClient webClient;

    @PostMapping("/usingWebClient")
    public void callOtherMicroservices_UsingWebClient(){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("message","WebClient has been used to call kafka producer from Spring Boot Application");

        WebClient webClient = WebClient.create("http://localhost:9111");
        String response  = webClient.post().uri(uriBuilder -> uriBuilder.path("/kafka/send/{message}").build(uriVariables))
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("response sent via WebClient"+response);
    }
}

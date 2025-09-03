//package com.example.config.Day4.Day10;
//
//import com.example.entity.StudentEntity;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.List;
//
//public class WebClientCalls {
//
//    private WebClient client = WebClient.create("http://localhost:8080");
//
//
//    private void callPostMethodViaWebClient(){
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setFirstName("manzer");
//        client.post().uri("/students").bodyValue(studentEntity).retrieve().bodyToMono(StudentEntity.class).block();
//    }
//
//    private void callPostMethodViaWebClientUsingSingleParam(){
//        client.post().uri("/students/{studentid}", 1).retrieve().bodyToMono(StudentEntity.class).block();
//    }
//    private void callGetMethodUsingWebClientUsingSingleParam(){
//        client.get().uri("/students/{studentid}",1).retrieve().bodyToMono(StudentEntity.class).block();
//    }
//
//    private void callGetMethodUsingWebClient(){
//        client.get().uri("/students").retrieve().bodyToMono(new ParameterizedTypeReference<List<StudentEntity>>() {
//        }).block();
//    }
//
//    private void callPutMethodUsingWebClient(){
//        client.put().uri("/students/{studentid}",  1).bodyValue(StudentEntity.class).retrieve().bodyToMono(StudentEntity.class).block();
//    }
//
//    private void callDeleteMethodViaWebClient(){
//        client.delete().retrieve().bodyToMono(String.class).block();
//    }
//}
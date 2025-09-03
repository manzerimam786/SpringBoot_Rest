//package com.example.config.Day4.Day10;
//
//import com.example.entity.StudentEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Configuration
//public class RestTemplateCalls {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    private void callPostMethodViaRestTemplate() {
//
//        String url = "http://localhost:8080/students";
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setFirstName("manzer");
//
//        HttpEntity httpEntity = new HttpEntity(studentEntity, httpHeaders);
//        ResponseEntity<StudentEntity> response = restTemplate.postForEntity(url, httpEntity, StudentEntity.class);
//        StudentEntity studentEntity1 = response.getBody();
//    }
//
//    private void callPostMethodAcceptingArgsViaRestTemplate() {
//        String url = "http://localhost:8080/students/{studentId}";
//        Map<String, Integer> uriVariable = new HashMap<>();
//        uriVariable.put("studentId", 1);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setFirstName("manzer");
//
//        HttpEntity httpEntity = new HttpEntity(studentEntity, httpHeaders);
//
//        restTemplate.postForEntity(url, httpEntity, StudentEntity.class, uriVariable);
//    }
//
//    private void callGetMethodViaRestTemplateForSingleId() {
//        String url = "http://localhost:8080/students/{studentId}";
//        Map<String, Integer> uriVariable = new HashMap<>();
//        uriVariable.put("studentId", 1);
//        restTemplate.getForEntity(url, StudentEntity.class, uriVariable);
//    }
//
//    private void callGetMethodViaRestTemplate() {
//        String url = "http://localhost:8080/students";
//        ResponseEntity<List<StudentEntity>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
//        });
//    }
//
//    private void callPutMethodViaRestTemplate() {
//        String url = "http://localhost:8080/students/{studentId}";
//        Map<String, Integer> uriVariable = new HashMap<>();
//        uriVariable.put("studentId", 1);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setFirstName("manzer");
//
//        HttpEntity httpEntity = new HttpEntity(studentEntity, httpHeaders);
//        restTemplate.exchange(url, HttpMethod.PUT, httpEntity, StudentEntity.class, uriVariable);
//    }
//
//    private void callDeleteMethodViaRestTemplate() {
//        String url = "http://localhost:8080/students/{studentId}";
//        Map<String, Integer> uriVariable = new HashMap<>();
//        uriVariable.put("studentId", 1);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity httpEntity = new HttpEntity(httpHeaders);
//        restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class, uriVariable);
//    }
//}

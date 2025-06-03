//package com.example.config;
//
//import com.example.entity.StudentEntity;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.*;
//import org.springframework.web.client.RestTemplate;
//
//import javax.print.attribute.standard.Media;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class RestTemplateConfig {
//    private RestTemplate restTemplate = new RestTemplate();
//    private StudentEntity studentEntity = new StudentEntity();
//    private static final String url = "http://localhost:8080";
//    public void getCall(){
//        Map<String, Integer> urivariable = new HashMap<>();
//        urivariable.put(studentEntity.getFirstName(),"manzer Iamm");
//
////        ResponseEntity<StudentEntity> response = restTemplate.getForEntity(url, StudentEntity.class, urivariable);
////        StudentEntity entity = response.getBody();
//
//        ResponseEntity<StudentEntity> response  = restTemplate.exchange(url, HttpMethod.GET, null, StudentEntity.class, urivariable);
//        ResponseEntity<List<StudentEntity>> list = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<StudentEntity>>() {});
//    }
//
//    public void putCall(){
//        Map<String, Integer> urivariable = new HashMap<>();
//        urivariable.put(studentEntity.getFirstName(),"manzer Iamm");
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setFirstName("manzer Iamm");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity httpEntity = new HttpEntity(headers, studentEntity);
//        restTemplate.postForEntity(url, httpEntity, StudentEntity.class, urivariable);
//
//    }
//}

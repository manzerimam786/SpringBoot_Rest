//package com.example.controller;
//
//public class RestTemplateCalls {
//    RestTemplate for POST call
//1. Post Whole Body
//    URL : http://localhost:8081/users
//
//    ResteTemplate restTemplate = new RestTemplate();
//    HttpHeaders headers = new HttpHeaders();
//   headers.setContentType(MediaType.APPLICATION_JSON);
//
//    User user = new User(1, "manzer");
//
//    HttpEntity httpEntity = new HttpEntity(user, headers);
//    ResponseEntity<User> response = restTemplate.postForEntity(url, httpEntity, User.class);
//    User user = response.getBody();
//
//2. Post 1 field Body
//    URL : http://localhost:8081/users/{userId}
//
//    String url = "http://localhost/8081/users/{userId}"
//    RestTemplate restTemplate = new RestTemplate();
//
//    HttpHeaders headers = new HttpHeaders();
//   header.setContentType(MediaType.APPLICATION_JSON);
//
//    User user = new User(1,"manzer");
//    Map<String,Integer> uriVariable = new HashMap<>();
//   map.put("userId",1);
//    HttpEntity httpEntity = new HttpEntity(request, headers);
//    ResponseEntity<User> responseEntity = restTemplate.postForEntity(url, httpEntity, User.class, uriVariable);
//    User user = responseEntity.getBody();
//
//
//    RestTemplate for GET call
//1. GET Whole Body
//    URL : http://localhost:8081/users
//
//    String url = "http://localhost:8081/users"
//    RestTemplate restTemplate = new RestTemplate();
//    ResponseEntity<List<User> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTyepReference<List<user>({}););
//
//2. GET 1 field Body
//    URL : http://localhost:8081/users/{userId}
//
//    Map<String, Integer> uriVariable =  new HashMap<>();
//   uriVariable.put("userId",1);
//    String url = "http://localhost/8081/users/{userId}"
//    RestTemplate restTemplate = new RestTemplate();
//   restTemplate.getForEntity(url, User.class, uriVariable);
//
//    RestTemplate for PUT call
//1. PUT 1 field Body
//    URL : http://localhost:8081/users/{userId}/{updatedValue}
//
//    String url = "http://localhost/8081/users/{userId}"
//    RestTemplate restTemplate = new RestTemplate();
//
//    Map<String, Integer> uriVariable = new HashMap<>();
//   uriVariable.put("userId",1);
//
//    User user = new User(1, "updatedName");
//    HttpHeaders httpHeaders = new HttpHeaders();
//   httpHeaders.seContentType(MediaType.APPLICATION_JSON);
//
//    HttpEntity httpEntity = new HttpEntity(user, httpHeaders);
//    ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Void.class, uriVariable);
//
//    RestTemplate for DELETE call
//1. DELETE 1 field Body
//    URL : http://localhost:8081/users/{userId}
//
//    String url = "http://localhost/8081/users/{userId}"
//    RestTemplate restTemplate = new RestTemplate();
//
//    Map<String, Integer> uriVariable = new HashMap<>();
//   uriVariable.put("userId", 1);
//
//    ResponseEntity<String> responseMesssage = restTemplate.delete(url, uriVariable);
//
//    OR(recommended)
//
//    String url = "http://localhost/8081/users/{userId}"
//    RestTemplate restTemplate = new RestTemplate();
//
//    HttpHeaders headers = new HttpHeaders();
//    HttpEntity<Void> httpEntity = new HttpEntity(headers);
//    Map<String, Integer> uriVariable = new HashMap<>();
//   uriVariable.put("userId", 1);
//
//    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class, uriVariable);
//}

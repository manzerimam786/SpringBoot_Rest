//package com.example.config;
//
//public class WebClient_Calls {
//
//    WebClient for POST call
//1. Post Whole Body
//    URL : http://localhost:8081/users
//
//    User user = new User(1, "manzer");
//    WebClient client = WebClient.create("http://localhost:8081");
//    User responseUser = client
//            .post()
//            .uri("/users")
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(user)
//            .retrieve()
//            .bodyToMono(User.class)  // Use bodyToFlux(List.class) if expecting a list
//            .block();  // Blocking for demonstration, ideally use reactive flow
//
//
//
//2. Post 1 field Body
//    URL : http://localhost:8081/users/{userId}
//
//    Map<String, Object> uriVariables = new HashMap<>();
//	uriVariables.put("userId", 1);
//
//    User user = new User(1, "manzer");
//    String url = "http://localhost:8081";
//
//    WebClient client = WebClient.create(url);
//
//    User responseUser = client
//            .post()
//            .uri("/users/{userId}", uriVariables)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(user)
//            .retrieve()
//            .bodyToMono(User.class)
//            .block();
//
//
//GET for List Request
//    URL : http://localhost:8081/users
//
//    WebClient client = WebClient.create(url);
//    List<User> listOfUser = client
//            .get()
//            .uri("/users")
//            .accept(MediaType.APPLICATION_JSON)  // optional
//            .retrieve()
//            .bodyToFlux(User.class)
//            .collectList()  // convert Flux<User> to Mono<List<User>>
//            .block();
//
//GET Using PathVariable
//    URL : http://localhost:8081/users/{userId}
//
//
//    Map<String, Object> uriVariables = new HashMap<>();
//	uriVariables.put("userId", 1);
//
//    String url = "http://localhost/8081/users/{userId}"
//    WebClient client = WebClient.create(url);
//    User user = client
//            .get()
//            .uri("/users/{userId}", uriVariables)
//            .retrieve()
//            .bodyToMono(User.class)
//            .block();
//
//
//
//PUT Request
//    String url = "http://localhost:8081";
//
//    Map<String, Object> uriVariables = new HashMap<>();
//	uriVariables.put("userId", 1);
//
//    User user = new User(1, "Updated Name");
//
//    WebClient client = WebClient.create(url);
//
//    User updatedUser = client
//            .put()
//            .uri("/users/{userId}", uriVariables)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(user)
//            .retrieve()
//            .bodyToMono(User.class)
//            .block();
//
//DELETE Request
//
//    String url = "http://localhost:8081";
//
//    Map<String, Object> uriVariables = new HashMap<>();
//uriVariables.put("userId", 1);
//
//    WebClient client = WebClient.create(url);
//
//    String message = client
//            .delete()
//            .uri("/users/{userId}", uriVariables)
//            .retrieve()
//            .bodyToMono(String.class)
//            .block();
//
//System.out.println(message);
//
//
//}

//package com.example.config.Day4.Day10;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Date;
//
//public class JwtUtil {
//
//    @Autowired
//    private UserDetails userDetails;
//
//    private String mySecret = "mysecret.txt";
//    private String generateToken(UserDetails userDetails){
//        return Jwts.builder().signWith(SignatureAlgorithm.HS256, mySecret)
//                .setExpiration(new Date(System.currentTimeMillis() * 60 *60 *10))
//                .setIssuedAt(new Date())
//                .compact();
//    }
//
//    private boolean validateToken(UserDetails userDetails, String token){
//        String userName = extractUsername(token);
//        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        Date date = Jwts.parser().setSigningKey(mySecret).parseClaimsJws(token).getBody().getExpiration();
//        return date.after(new Date());
//    }
//
//    private String extractUsername(String token){
//        return Jwts.parser().setSigningKey(mySecret).parseClaimsJws(token).getBody().getSubject();
//
//    }
//}

//package com.example.util;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Date;
//
//@Configuration
//public class JwtUtil {
//
//    @Autowired
//    private UserDetails userDetails;
//    private final String SECRET_KEY = "mySecretKey";
//
//    public String generateToken(UserDetails userDetails){
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() * 60 * 60* 10))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public String extractUsername(String token, UserDetails userDeatils){
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public boolean validateToken(String token){
//        String username = extractUsername(token, userDetails);
//        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        Date expireDate =  Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token).getBody().getExpiration();
//        return expireDate.after(new Date());
//    }
//}

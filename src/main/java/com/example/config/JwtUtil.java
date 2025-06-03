//package com.example.config;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//import static javax.crypto.Cipher.SECRET_KEY;
//
//@Component
//public class JwtUtil{
//
//    private final String SECRET_KEY = "mysecret";
//    public String generateToken(UserDetails userDetails){
//        return Jwts
//                .builder()
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date() +  System.currentTiemMillis() * 1000 * 60 *60 * 10)
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public String extractUsername(String token){
//        return Jwts
//                .parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody().getSubject();
//    }
//
//    public boolean validateToken(String token, UserDetails){
//        String userName =  Jwts.parser().setSigningKey(SECRET_KEY)
//                .parseClaimJws(token).getBody().getSubject();
//        return (userName.equals(userDetails.getUsername) && !isTokenExpired();
//
//    }
//
//    public boolean isTokenExpired(){
//        Date date = Jwts.parser().setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token).getBody().getExpiration();
//        return new Date().before(date);
//    }
//
//
//
//}

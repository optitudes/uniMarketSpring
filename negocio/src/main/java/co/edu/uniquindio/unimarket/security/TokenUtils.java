package co.edu.uniquindio.unimarket.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    private final static String TOKEN_SECRET = "ajdldi5ddmfpdj4jlkhe9876h4khk0";
    private final static Long TOKEN_TIME_EXPIRE = 2_592_000L;

    public static String createToken(String email, String id){
        long expirationTime = TOKEN_TIME_EXPIRE * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        Map<String, Object> extra = new HashMap<>();
        extra.put("email",email);
        return Jwts.builder()
                .setSubject(id)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try{

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String id = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(id, null, Collections.emptyList());

        } catch (JwtException e) {
            return null;
        }
    }
}

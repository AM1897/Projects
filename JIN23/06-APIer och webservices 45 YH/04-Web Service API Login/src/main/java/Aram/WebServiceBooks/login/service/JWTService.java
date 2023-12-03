package Aram.WebServiceBooks.login.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTService {

    private long oneDay = 24 * 60 * 60 * 1000;

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // The token expiration time is set to 24 hours from the current time.
                .setExpiration(new Date(System.currentTimeMillis() + oneDay )) // 24 hours
                .signWith(getSecritkey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSecritkey() {
        byte[] key = Decoders.BASE64
                .decode("daa5ec3d56b653ffcde8470d7ba08d918dd5d27fd447542ff8dadb590f0cacff");
        return Keys.hmacShaKeyFor(key);
    }

    // getAuthenticationManager method provides an AuthenticationManager bean.
    @Bean
    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // getUserNameFromToken method extracts the username from the given JWT token.
    public String getUserNameFromToken(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    // getExpirationDateFromToken method extracts the expiration date from the given JWT token.
    public Date getExpirationDateFromToken(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    // extractClaims method extracts the specified claims from the given JWT token.
    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // extractAllClaims method extracts all claims from the given JWT token.
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSecritkey()).build().parseClaimsJws(token).getBody();
    }

    // isTokenExpired method checks if the given JWT token is expired.
    private Boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }

    // validateToken method validates the given JWT token.
    // It checks if the username in the token matches the given UserDetails and if the token is not expired.
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}

package com.solutioncode.apiRestVentas.component.util;

import com.solutioncode.apiRestVentas.component.security.CustomUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.*;

@Component
public class JwtManager {
    public static final Logger logger = LoggerFactory.getLogger(JwtManager.class);
    @Value("${jwt.secret}")
    private String JWT_SECRET;
    @Value("${jwt.expire}")
    private int JWT_EXPIRE;
    private SecretKey secretKey;

    private Key getSigningKey() {
        if (Objects.isNull(secretKey)) {
            byte[] keyBytes = Decoders.BASE64.decode(JWT_SECRET);
            this.secretKey = Keys.hmacShaKeyFor(keyBytes);
        }
        return this.secretKey;
    }

    public String generateToken(String email, String user, String role) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(calendar.HOUR, JWT_EXPIRE);
        Date expire = calendar.getTime();
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expire)
                .setIssuer("solution code")
                .claim("user", user)
                .claim("role", role)
                .signWith(getSigningKey())
                .compact();
    }

    public Optional<Authentication> getAuthentication(String token) {
        var boxClaims = getTokenPayload(token);
        if (boxClaims.isEmpty()) return Optional.empty();
        var claims = boxClaims.get();
        var authorities = Arrays.asList(new SimpleGrantedAuthority(claims.get("role", String.class)));
        var principal = new CustomUser(claims.get("sub", String.class), claims.get("user", String.class), "", authorities);
        return Optional.of(
                new UsernamePasswordAuthenticationToken(principal, principal.getPassword(), principal.getAuthorities())
        );
    }

    public Optional<Claims> getTokenPayload(String token) {
        try {
            var claims = Jwts.parserBuilder().setSigningKey(JWT_SECRET).build()
                    .parseClaimsJws(token).getBody();
            return Optional.of(claims);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

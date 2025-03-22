package br.com.itsolution.fintech.billing.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${billing.secret-key:billing-api-secret-key-256bit-minimum-safe-9876543210}")
    private String secretKey;

    @Value("${billing.token-expiration-ms:3600000}")
    private long expirationMillis;

    @GetMapping("/token")
    public ResponseEntity<Map<String, Object>> gerarToken() {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

        String token = Jwts.builder()
                .setSubject("admin")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();

        Map<String, Object> response = new HashMap<>();
        response.put("access_token", token);
        response.put("token_type", "Bearer");
        response.put("expires_in", expirationMillis / 1000);

        return ResponseEntity.ok(response);
    }

}

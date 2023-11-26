package com.jgji.sokdak.infra.token;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider implements TokenProvider {

    private final String jwtSecret = "yourSecretKey"; // 비밀키, 실제 환경에서는 보안을 위해 외부에서 주입받아야 함
    private final long jwtExpirationMs = 3600000; // 토큰 유효 시간 (예: 1시간)
    private final Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

    // JWT 토큰 생성
    public String generateJwtToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
            .signWith(key, SignatureAlgorithm.HS512)
            .compact();
    }

    // JWT 토큰에서 사용자 이름 추출
    public String getUsernameFromJwtToken(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    // JWT 토큰 유효성 검증
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(authToken);
            return true;
        } catch (JwtException e) {
            // 예외 처리 로그 등을 남길 수 있음
        }
        return false;
    }
}

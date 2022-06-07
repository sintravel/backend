package backend.sintravel.auth.jwt;


import backend.sintravel.auth.security.UserAdaptor;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtProvider {

    private final String jwtSecret;
    private final Long validTimeMilli;
    private final UserDetailsService userDetailsService;

    private Key key;

    public JwtProvider(@Value("${jwt.validTime}") Long validTime,
                       @Value("${jwt.secret}") String jwtSecret,
                       UserDetailsService userDetailsService) {
        this.validTimeMilli = validTime * 1000L;
        this.jwtSecret = jwtSecret;
        this.userDetailsService = userDetailsService;
    }

    @PostConstruct
    protected void init() {
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String createToken(String username) {
        Date now = new Date();
        Claims claims = Jwts.claims().setSubject(username);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + validTimeMilli))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Authentication getAuthentication(String jwtToken) {
        UserAdaptor userAdaptor = (UserAdaptor) userDetailsService
                .loadUserByUsername(getUsernameFromToken(jwtToken));

        return new UsernamePasswordAuthenticationToken(userAdaptor, "", userAdaptor.getAuthorities());

    }

    private String getUsernameFromToken(String jwtToken) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwtToken)
                .getBody()
                .getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }
}

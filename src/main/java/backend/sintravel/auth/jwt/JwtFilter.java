package backend.sintravel.auth.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {


    private final JwtProvider jwtProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String token = jwtProvider.resolveToken((HttpServletRequest) request);
            if (token != null) {
                SecurityContextHolder.getContext().setAuthentication(jwtProvider.getAuthentication(token));
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            sendErrorMessage("만료된 JWT 토큰 입니다");
        }
    }

    private String sendErrorMessage(String message) {
        return message;
    }
}

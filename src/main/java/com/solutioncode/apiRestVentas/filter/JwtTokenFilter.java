package com.solutioncode.apiRestVentas.filter;

import com.solutioncode.apiRestVentas.component.util.JwtManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    public static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    @Autowired
    private JwtManager jwtManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (Objects.isNull(authorization) || authorization.isEmpty() || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        var token = authorization.replace("Bearer ", "").trim();
        var authentication = jwtManager.getAuthentication(token);
        if (authorization.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authentication.get());
        filterChain.doFilter(request, response);
    }
}

package com.solutioncode.apiRestVentas.component.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

public class AuthorizationFailed implements AccessDeniedHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException, ServletException {
        Map<String, Object> body = Map.of(
                "ok", false,
                "errors", ex.getMessage()
        );
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.getOutputStream().println(objectMapper.writeValueAsString(body));
    }
}

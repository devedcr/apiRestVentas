package com.solutioncode.apiRestVentas.advice;

import com.solutioncode.apiRestVentas.component.response.ApiResponse;
import com.solutioncode.apiRestVentas.component.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class AuthenticactionAdvice {
    private final ApiResponse apiResponse;

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public Response handleExceptionUserNotFound(UsernameNotFoundException ex) {
        return apiResponse.createErrorResponse();
    }
}

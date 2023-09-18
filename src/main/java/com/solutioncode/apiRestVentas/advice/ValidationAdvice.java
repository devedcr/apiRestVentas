package com.solutioncode.apiRestVentas.advice;

import com.solutioncode.apiRestVentas.component.response.ApiResponse;
import com.solutioncode.apiRestVentas.component.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
@AllArgsConstructor
public class ValidationAdvice {
    private final ApiResponse apiResponse;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleExceptionValidation(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errors = ex.getFieldErrors().stream()
                .map((error) -> Map.of(error.getField(), error.getDefaultMessage()))
                .toList();
        return apiResponse.createErrorResponse(errors);
    }
}

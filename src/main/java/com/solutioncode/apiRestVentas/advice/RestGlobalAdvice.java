package com.solutioncode.apiRestVentas.advice;

import com.solutioncode.apiRestVentas.component.response.ApiResponse;
import com.solutioncode.apiRestVentas.component.response.Response;
import com.solutioncode.apiRestVentas.exception.NotFoundResource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class RestGlobalAdvice {
    private final ApiResponse apiResponse;

    @ExceptionHandler(value = {NotFoundResource.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response handleExceptionNotFoundResource(NotFoundResource ex) {
        return apiResponse.createErrorResponse();
    }
}

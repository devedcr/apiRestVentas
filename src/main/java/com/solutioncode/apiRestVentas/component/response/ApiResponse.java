package com.solutioncode.apiRestVentas.component.response;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse {
    public Response createSuccessResponse() {
        return Response.builder()
                .ok(true)
                .build();
    }
    public <T> Response createSuccessResponse(T data) {
        return Response.builder()
                .ok(true)
                .data(data)
                .build();
    }
    public Response createErrorResponse(){
        return Response.builder()
                .ok(false)
                .build();
    }
    public <T> Response createErrorResponse(T errors){
        return Response.builder()
                .ok(false)
                .error(errors)
                .build();
    }
}

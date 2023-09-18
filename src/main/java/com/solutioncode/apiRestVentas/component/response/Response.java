package com.solutioncode.apiRestVentas.component.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<D,E> {
    private Boolean ok;
    private D data;
    private E error;
}

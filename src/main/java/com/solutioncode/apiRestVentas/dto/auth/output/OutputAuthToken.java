package com.solutioncode.apiRestVentas.dto.auth.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutputAuthToken {
    private String token;
}

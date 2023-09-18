package com.solutioncode.apiRestVentas.dto.rol.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutputRol {
    private Long id;
    private String name;
    private String description;
}

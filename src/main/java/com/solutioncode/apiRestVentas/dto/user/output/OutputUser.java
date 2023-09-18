package com.solutioncode.apiRestVentas.dto.user.output;

import com.solutioncode.apiRestVentas.entity.Rol;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutputUser {
    private String ci;
    private String name;
    private String surname;
    private String email;
    private String fileName;
    private String rol;
}

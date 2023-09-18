package com.solutioncode.apiRestVentas.dto.user.input;


import com.solutioncode.apiRestVentas.validation.Unique;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputUserCreate {
    @NotNull
    @Unique(fieldName = "ci", entityName = "User")
    private String ci;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, max = 50)
    private String surname;
    @NotBlank
    @Email
    @Unique(fieldName = "email", entityName = "User")
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @NotNull
    @Min(1)
    private Long rolId;
    //private String filename;
}

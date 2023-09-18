package com.solutioncode.apiRestVentas.component.mapper.auth;

import com.solutioncode.apiRestVentas.dto.auth.output.OutputAuthToken;
import com.solutioncode.apiRestVentas.dto.user.output.OutputUser;
import com.solutioncode.apiRestVentas.entity.User;

public class AuthMapper {
    public static OutputAuthToken map(String token) {
        return OutputAuthToken.builder()
                .token(token)
                .build();
    }
}

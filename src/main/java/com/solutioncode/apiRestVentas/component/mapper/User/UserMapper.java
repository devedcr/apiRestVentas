package com.solutioncode.apiRestVentas.component.mapper.User;

import com.solutioncode.apiRestVentas.dto.user.output.OutputUser;
import com.solutioncode.apiRestVentas.entity.User;

public class UserMapper {
    public static OutputUser map(User user) {
        return OutputUser.builder()
                .ci(user.getCi())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .fileName(user.getFileName())
                .rol(user.getRol().getName())
                .build();
    }
}

package com.solutioncode.apiRestVentas.component.mapper.Rol;

import com.solutioncode.apiRestVentas.dto.rol.output.OutputRol;
import com.solutioncode.apiRestVentas.entity.Rol;

import java.util.List;
import java.util.stream.Collectors;

public class RolMapper {
    public static OutputRol map(Rol rol) {
        return OutputRol.builder()
                .id(rol.getId())
                .name(rol.getName())
                .description(rol.getDescription()).build();
    }

    public static List<OutputRol> map(List<Rol> roles) {
        return roles.stream().map((role) ->
                OutputRol.builder()
                        .id(role.getId())
                        .name(role.getName())
                        .description(role.getDescription())
                        .build()
        ).collect(Collectors.toList());
    }
}

package com.solutioncode.apiRestVentas.service.rol;

import com.solutioncode.apiRestVentas.dto.rol.input.InputRolCreate;
import com.solutioncode.apiRestVentas.dto.rol.input.InputRolUpdate;
import com.solutioncode.apiRestVentas.entity.Rol;

import java.util.List;

public interface IRolService {
    public Rol save(InputRolCreate input);

    public Rol update(InputRolUpdate input);

    public void remove(Long id);

    public Rol findById(Long id);
    public List<Rol> all();
}

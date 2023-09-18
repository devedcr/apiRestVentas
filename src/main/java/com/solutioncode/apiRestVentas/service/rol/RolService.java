package com.solutioncode.apiRestVentas.service.rol;

import com.solutioncode.apiRestVentas.dto.rol.input.InputRolCreate;
import com.solutioncode.apiRestVentas.dto.rol.input.InputRolUpdate;
import com.solutioncode.apiRestVentas.entity.Rol;
import com.solutioncode.apiRestVentas.exception.NotFoundResource;
import com.solutioncode.apiRestVentas.repository.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RolService implements IRolService {
    private final RolRepository rolRepository;

    @Override
    @Transactional
    public Rol save(InputRolCreate in) {
        System.out.println(in);
        var rol = Rol.builder().name(in.getName())
                .description(in.getDescription())
                .build();
        rolRepository.save(rol);
        return rol;
    }

    @Override
    @Transactional
    public Rol update(InputRolUpdate in) {
        var rol = findById(in.getId());
        rol.setName(in.getName());
        rol.setDescription(in.getDescription());
        rolRepository.save(rol);
        return rol;
    }

    @Override
    @Transactional
    public void remove(Long id) {
        var rol = findById(id);
        rolRepository.delete(rol);
    }

    @Override
    public Rol findById(Long id) {
        var boxRol = rolRepository.findById(id);
        if (boxRol.isEmpty()) throw new NotFoundResource();
        return boxRol.get();
    }

    @Override
    public List<Rol> all() {
        return rolRepository.findAll();
    }

}

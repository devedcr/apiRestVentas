package com.solutioncode.apiRestVentas.controller;

import com.solutioncode.apiRestVentas.component.mapper.Rol.RolMapper;
import com.solutioncode.apiRestVentas.component.response.ApiResponse;
import com.solutioncode.apiRestVentas.component.response.Response;
import com.solutioncode.apiRestVentas.constant.ApiRoute;
import com.solutioncode.apiRestVentas.dto.rol.input.InputRolCreate;
import com.solutioncode.apiRestVentas.dto.rol.input.InputRolUpdate;
import com.solutioncode.apiRestVentas.dto.rol.output.OutputRol;
import com.solutioncode.apiRestVentas.entity.Rol;
import com.solutioncode.apiRestVentas.service.rol.IRolService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiRoute.ROL)
@AllArgsConstructor
public class RolController {
    private static final Logger logger = LoggerFactory.getLogger(RolController.class);
    private final ApiResponse apiResponse;
    private final IRolService iRolService;

    @GetMapping(path = "")
    public ResponseEntity<Response> all() {
        logger.info(ApiRoute.ROL);
        var roles = iRolService.all();
        List<OutputRol> outRoles = RolMapper.map(roles);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse.createSuccessResponse(outRoles));
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Response> save(@Valid @RequestBody InputRolCreate req) {
        Rol rolPersisted = iRolService.save(req);
        OutputRol outRol = RolMapper.map(rolPersisted);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse.createSuccessResponse(outRol));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Response> update(@Valid @RequestBody InputRolUpdate req) {
        Rol rolUpdated = iRolService.update(req);
        OutputRol outRol = RolMapper.map(rolUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse.createSuccessResponse(outRol));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Response> remove(@PathVariable("id") Long id) {
        iRolService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse.createSuccessResponse());
    }


}

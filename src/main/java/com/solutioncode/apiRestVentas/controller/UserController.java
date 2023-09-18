package com.solutioncode.apiRestVentas.controller;

import com.solutioncode.apiRestVentas.component.mapper.User.UserMapper;
import com.solutioncode.apiRestVentas.component.response.ApiResponse;
import com.solutioncode.apiRestVentas.component.response.Response;
import com.solutioncode.apiRestVentas.constant.ApiRoute;
import com.solutioncode.apiRestVentas.dto.user.input.InputUserCreate;
import com.solutioncode.apiRestVentas.dto.user.output.OutputUser;
import com.solutioncode.apiRestVentas.entity.User;
import com.solutioncode.apiRestVentas.service.user.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiRoute.USER)
@AllArgsConstructor
public class UserController {
    private ApiResponse apiResponse;
    private IUserService iUserService;

    @PostMapping(path = "/create")
    public ResponseEntity<Response> create(@Valid @RequestBody InputUserCreate req) {
        User user = iUserService.create(req);
        OutputUser outUser = UserMapper.map(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse.createSuccessResponse(outUser));
    }
}

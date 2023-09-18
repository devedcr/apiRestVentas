package com.solutioncode.apiRestVentas.controller;

import com.solutioncode.apiRestVentas.component.mapper.auth.AuthMapper;
import com.solutioncode.apiRestVentas.component.response.ApiResponse;
import com.solutioncode.apiRestVentas.component.response.Response;
import com.solutioncode.apiRestVentas.component.util.JwtManager;
import com.solutioncode.apiRestVentas.constant.ApiRoute;
import com.solutioncode.apiRestVentas.dto.auth.input.InputLoginUser;
import com.solutioncode.apiRestVentas.dto.auth.output.OutputAuthToken;
import com.solutioncode.apiRestVentas.entity.User;
import com.solutioncode.apiRestVentas.service.user.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiRoute.AUTH)
@AllArgsConstructor
public class AuhtController {
    public static Logger logger = LoggerFactory.getLogger(AuhtController.class);
    private ApiResponse apiResponse;
    private IUserService iUserService;
    private JwtManager jwtManager;
    private AuthenticationManager authenticationManager;

    @PostMapping(path = "/login")
    public ResponseEntity<Response> login(@Valid @RequestBody InputLoginUser req) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        User user = iUserService.findByEmail(req.getEmail());
        String token = jwtManager.generateToken(user.getEmail(), user.getName(), user.getRol().getName());
        OutputAuthToken outputAuthToken = AuthMapper.map(token);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse.createSuccessResponse(outputAuthToken));
    }
}

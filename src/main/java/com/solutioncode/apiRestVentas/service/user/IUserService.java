package com.solutioncode.apiRestVentas.service.user;

import com.solutioncode.apiRestVentas.dto.user.input.InputUserCreate;
import com.solutioncode.apiRestVentas.entity.User;

public interface IUserService {
    public User create(InputUserCreate in);

    public User findById(String id);

    public User findByEmail(String email);
}

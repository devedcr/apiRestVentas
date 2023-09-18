package com.solutioncode.apiRestVentas.service.user;

import com.solutioncode.apiRestVentas.dto.user.input.InputUserCreate;
import com.solutioncode.apiRestVentas.entity.Rol;
import com.solutioncode.apiRestVentas.entity.User;
import com.solutioncode.apiRestVentas.exception.NotFoundResource;
import com.solutioncode.apiRestVentas.repository.UserRepository;
import com.solutioncode.apiRestVentas.service.rol.IRolService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private UserRepository userRepository;
    private IRolService iRolService;
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User create(InputUserCreate in) {
        Rol rol = iRolService.findById(in.getRolId());
        User user = User.builder()
                .ci(in.getCi())
                .password(passwordEncoder.encode(in.getPassword()))
                .name(in.getName())
                .surname(in.getSurname())
                .rol(rol)
                .email(in.getEmail())
                .build();
        userRepository.save(user);
        return user;
    }

    @Override
    public User findById(String id) {
        var userBox = userRepository.findById(id);
        if (userBox.isEmpty()) throw new NotFoundResource();
        return userBox.get();
    }

    @Override
    public User findByEmail(String email) {
        var userBox = userRepository.findByEmail(email);
        if (userBox.isEmpty()) throw new NotFoundResource();
        return userBox.get();
    }
}

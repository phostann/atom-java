package cc.phos.atom.service.impl;

import cc.phos.atom.domain.dto.auth.LoginUserDTO;
import cc.phos.atom.domain.dto.auth.RegisterUserDTO;
import cc.phos.atom.domain.po.UserEntity;
import cc.phos.atom.service.IAuthenticationService;
import cc.phos.atom.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 15:33:19
 */
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    @Resource
    private IUserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public UserEntity signup(RegisterUserDTO dto) {
        return userService.create(dto);
    }

    @Override
    public UserEntity authenticate(LoginUserDTO dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()));

        return userService.getByEmail(dto.getEmail());
    }
}

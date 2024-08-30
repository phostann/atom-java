package cc.phos.atom.service;

import cc.phos.atom.domain.dto.auth.LoginUserDTO;
import cc.phos.atom.domain.dto.auth.RegisterUserDTO;
import cc.phos.atom.domain.po.UserEntity;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-30 09:47:36
 */
public interface IAuthenticationService {
    UserEntity signup(RegisterUserDTO dto);

    UserEntity authenticate(LoginUserDTO dto);
}

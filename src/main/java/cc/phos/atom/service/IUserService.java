package cc.phos.atom.service;

import cc.phos.atom.domain.dto.auth.RegisterUserDTO;
import cc.phos.atom.domain.po.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 骸
 * @since 2024-08-29
 */
public interface IUserService extends IService<UserEntity> {

    UserEntity create(RegisterUserDTO dto);

    UserEntity getByEmail(String email);
}

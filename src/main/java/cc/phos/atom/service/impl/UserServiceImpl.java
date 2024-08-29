package cc.phos.atom.service.impl;

import cc.phos.atom.converter.user.UserConverter;
import cc.phos.atom.domain.dto.auth.RegisterUserDTO;
import cc.phos.atom.domain.po.UserEntity;
import cc.phos.atom.enums.ErrorCode;
import cc.phos.atom.exception.BizException;
import cc.phos.atom.mapper.UserMapper;
import cc.phos.atom.service.IUserService;
import cc.phos.atom.utils.PasswordUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 骸
 * @since 2024-08-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Override
    public UserEntity create(RegisterUserDTO dto) {
        // 检查邮箱有没有被使用
        Long count = this.lambdaQuery()
                .eq(UserEntity::getEmail, dto.getEmail())
                .count();
        if (count > 0) {
            throw new BizException(ErrorCode.EMAIL_HAS_BEEN_USED);
        }

        // 检查昵称有没有被使用
        count = this.lambdaQuery()
                .eq(UserEntity::getNickname, dto.getNickname())
                .count();
        if (count > 0) {
            throw new BizException(ErrorCode.NICKNAME_HAS_BEEN_USED);
        }

        UserEntity entity = UserConverter.INSTANCE.createUserDtoToUserEntity(dto);
        entity.setPassword(PasswordUtils.encodePassword(entity.getPassword()));

        this.baseMapper
                .insert(entity);

        return entity;
    }

    @Override
    public UserEntity getByEmail(String email) {
        return this.lambdaQuery()
                .eq(UserEntity::getEmail, email).one();
    }
}

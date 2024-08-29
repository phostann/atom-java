package cc.phos.atom.converter.user;

import cc.phos.atom.domain.dto.auth.RegisterUserDTO;
import cc.phos.atom.domain.po.UserEntity;
import cc.phos.atom.domain.vo.user.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 11:31:19
 */
@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserEntity createUserDtoToUserEntity(RegisterUserDTO dto);

    UserVO userEntityToUserVo(UserEntity entity);
}

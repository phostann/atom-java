package cc.phos.atom.controller;


import cc.phos.atom.converter.user.UserConverter;
import cc.phos.atom.domain.po.UserEntity;
import cc.phos.atom.domain.response.R;
import cc.phos.atom.domain.vo.user.UserVO;
import cc.phos.atom.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 骸
 * @since 2024-08-29
 */
@RestController
@RequestMapping("/users")
@Tag(name = "用户", description = "用户管理模块")
public class UserController {
    @Resource
    private IUserService userService;

    @Operation(summary = "获取当前用户", description = "获取当前用户")
    @GetMapping("/me")
    public R<UserVO> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserEntity entity = (UserEntity) authentication.getPrincipal();

        return R.ok(UserConverter.INSTANCE.userEntityToUserVo(entity));
    }

}

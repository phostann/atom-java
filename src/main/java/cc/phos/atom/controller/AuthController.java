package cc.phos.atom.controller;

import cc.phos.atom.converter.user.UserConverter;
import cc.phos.atom.domain.dto.auth.LoginUserDTO;
import cc.phos.atom.domain.dto.auth.RegisterUserDTO;
import cc.phos.atom.domain.po.UserEntity;
import cc.phos.atom.domain.response.R;
import cc.phos.atom.domain.vo.auth.LoginVO;
import cc.phos.atom.domain.vo.user.UserVO;
import cc.phos.atom.service.IJwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 15:25:43
 */
@RestController
@RequestMapping("/auth")
@Tag(name = "认证", description = "认证模块")
public class AuthController {
    @Resource
    private IJwtService.IAuthenticationService authenticationService;

    @Resource
    private IJwtService jwtService;

    @Operation(summary = "登录", description = "用户登录")
    @PostMapping("/login")
    R<LoginVO> login(@Valid @RequestBody LoginUserDTO dto) {
        UserEntity authenticatedUser = authenticationService.authenticate(dto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginVO loginResponse = new LoginVO();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return R.ok(loginResponse);
    }

    @Operation(summary = "注册", description = "用户注册")
    @PostMapping("/signup")
    R<UserVO> signup(@Valid @RequestBody RegisterUserDTO dto) {
        UserEntity entity = authenticationService.signup(dto);
        return R.ok(UserConverter.INSTANCE.userEntityToUserVo(entity));
    }


}

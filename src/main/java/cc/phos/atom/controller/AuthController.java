package cc.phos.atom.controller;

import cc.phos.atom.converter.user.UserConverter;
import cc.phos.atom.domain.dto.auth.LoginUserDTO;
import cc.phos.atom.domain.dto.auth.RefreshTokenDTO;
import cc.phos.atom.domain.dto.auth.RegisterUserDTO;
import cc.phos.atom.domain.po.UserEntity;
import cc.phos.atom.domain.response.R;
import cc.phos.atom.domain.vo.auth.LoginResponseVO;
import cc.phos.atom.domain.vo.user.UserVO;
import cc.phos.atom.enums.ErrorCode;
import cc.phos.atom.service.IAuthenticationService;
import cc.phos.atom.service.IJwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private IAuthenticationService authenticationService;

    @Resource
    private IJwtService jwtService;

    @Resource
    private UserDetailsService userDetailsService;

    @Operation(summary = "登录", description = "用户登录")
    @PostMapping("/login")
    R<LoginResponseVO> login(@Valid @RequestBody LoginUserDTO dto) {
        UserEntity authenticatedUser = authenticationService.authenticate(dto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        String refreshToken = jwtService.generateRefreshToken(authenticatedUser);

        LoginResponseVO loginResponse = LoginResponseVO.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .refreshToken(refreshToken)
                .refreshExpiresIn(jwtService.getRefreshExpirationTime())
                .build();

        return R.ok(loginResponse);
    }

    @Operation(summary = "注册", description = "用户注册")
    @PostMapping("/signup")
    R<UserVO> signup(@Valid @RequestBody RegisterUserDTO dto) {
        UserEntity entity = authenticationService.signup(dto);
        return R.ok(UserConverter.INSTANCE.userEntityToUserVo(entity));
    }

    @Operation(summary = "刷新 token", description = "刷新 token")
    @PostMapping("/refresh_token")
    R<LoginResponseVO> refreshToken(@Valid @RequestBody RefreshTokenDTO dto) {
        String refreshToken = dto.getRefreshToken();
        if (!jwtService.isRefreshToken(refreshToken)) {
            return R.error(ErrorCode.INVALID_REFRESH_TOKEN);
        }

        if (!jwtService.isRefreshTokenValid(refreshToken)) {
            return R.error(ErrorCode.REFRESH_TOKEN_EXPIRED);
        }

        String username = jwtService.extractUsername(refreshToken);

        UserDetails user = userDetailsService.loadUserByUsername(username);
        if (user == null) {
            return R.error(ErrorCode.USER_NOT_FOUND);
        }

        String jwtToken = jwtService.generateToken(user);
        String newRefreshToken = jwtService.generateRefreshToken(user);

        LoginResponseVO loginResponse = LoginResponseVO.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .refreshToken(newRefreshToken)
                .refreshExpiresIn(jwtService.getRefreshExpirationTime())
                .build();


        return R.ok(loginResponse);
    }


}

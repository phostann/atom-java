package cc.phos.atom.domain.vo.auth;

import cc.phos.atom.constants.AuthConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 15:39:27
 */
@Data
@Builder
@Schema(name = "登录结果", description = "登录响应体")
public class LoginResponseVO {
    @Schema(description = "token")
    private String token;

    @Schema(description = "refresh token")
    private String refreshToken;

    @Schema(description = "token 有效时间")
    private long expiresIn;

    @Schema(description = "refresh token 有效时间")
    private long refreshExpiresIn;

    @Builder.Default
    @Schema(description = "token 类型")
    private String tokenType = AuthConstants.TOKEN_TYPE;
}

package cc.phos.atom.domain.vo.auth;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "登录结果", description = "登录响应体")
public class LoginVO {
    @Schema(description = "token")
    private String token;

    @Schema(description = "token 有效时间")
    private long expiresIn;
}

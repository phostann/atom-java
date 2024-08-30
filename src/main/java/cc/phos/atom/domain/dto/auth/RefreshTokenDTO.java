package cc.phos.atom.domain.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-30 10:39:29
 */
@Data
@Schema(name = "刷新 token", description = "刷新 token 请求体")
public class RefreshTokenDTO {
    @NotBlank(message = "refresh token 不能为空")
    @Schema(description = "refresh token")
    private String refreshToken;
}

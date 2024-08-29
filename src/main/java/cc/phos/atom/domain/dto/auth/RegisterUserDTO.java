package cc.phos.atom.domain.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 10:59:20
 */
@Data
@Schema(name = "创建用户", description = "创建用户请求体")
public class RegisterUserDTO {
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @Schema(description = "邮箱", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotNull(message = "性别不能为空")
    @Min(value = 1, message = "性别只能是 1 或 2")
    @Max(value = 2, message = "性别只能是 1 或 2")
    @Schema(description = "性别; 1 男; 2 女", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer gender;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 16, message = "密码长度必须在 6 到 16 位之间")
    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @NotBlank(message = "昵称不能为空")
    @Schema(description = "昵称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nickname;

    @NotBlank(message = "头像不能为空")
    @Schema(description = "头像", requiredMode = Schema.RequiredMode.REQUIRED)
    private String avatar;
}

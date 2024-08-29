package cc.phos.atom.domain.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 16:35:42
 */
@Data
@Schema(name = "用户信息", description = "用户信息")
public class UserVO {
    @Schema(description = "用户ID")
    private Long id;
    @Schema(description = "用户名")
    private String nickname;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "性别")
    private Integer gender;
    @Schema(description = "头像")
    private String avatar;
    @Schema(description = "状态")
    private Integer status;
    @Schema(description = "封禁截止时间")
    private LocalDateTime banEndTime;
    @Schema(description = "角色ID")
    private Long roleId;
    @Schema(description = "创建时间")
    private LocalDateTime createdAt;
    @Schema(description = "更新时间")
    private LocalDateTime updatedAt;
}

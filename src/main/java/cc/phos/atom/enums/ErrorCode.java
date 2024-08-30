package cc.phos.atom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 10:19:16
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    // @formatter:off
    SUCCESS(0, "成功"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    BAD_REQUEST(403, "请求参数错误"),

    EMAIL_HAS_BEEN_USED(1001, "邮箱已被使用"),
    NICKNAME_HAS_BEEN_USED(1002, "昵称已被使用"),
    INVALID_REFRESH_TOKEN(1003, "无效的刷新令牌"),
    REFRESH_TOKEN_EXPIRED(1004, "刷新令牌已过期"),
    USER_NOT_FOUND(1005, "用户不存在"),
    ;

    // @formatter:on

    private final int code;
    private final String message;
}

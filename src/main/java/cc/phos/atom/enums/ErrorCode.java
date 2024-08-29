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

    SUCCESS(0, "成功"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    BAD_REQUEST(403, "请求参数错误"),

    EMAIL_HAS_BEEN_USED(1001, "邮箱已被使用"),
    NICKNAME_HAS_BEEN_USED(1002, "昵称已被使用");

    private final int code;
    private final String message;
}

package cc.phos.atom.domain.response;

import cc.phos.atom.enums.ErrorCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 10:21:32
 */
@AllArgsConstructor
@Data
public class R<T> {
    @Schema(description = "状态码")
    private int code;
    @Schema(description = "消息")
    private String message;
    @Schema(description = "数据")
    private T data;

    public static <T> R<T> ok() {
        return new R<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), null);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data);
    }

    public static <T> R<T> ok(int code, String message, T data) {
        return new R<>(code, message, data);
    }

    public static <T> R<T> error(ErrorCode errorCode) {
        return new R<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> R<T> error(int code, String message) {
        return new R<>(code, message, null);
    }

    public static <T> R<T> error(ErrorCode errorCode, T data) {
        return R.error(errorCode.getCode(), errorCode.getMessage(), data);
    }

    public static <T> R<T> error(int code, String message, T data) {
        return new R<>(code, message, data);
    }

    public int getCode() {
        return code;
    }
}

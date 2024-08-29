package cc.phos.atom.exception;

import cc.phos.atom.enums.ErrorCode;
import lombok.Getter;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 11:18:42
 */
@Getter
public class BizException extends RuntimeException {
    private final ErrorCode errorCode;

    public BizException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}

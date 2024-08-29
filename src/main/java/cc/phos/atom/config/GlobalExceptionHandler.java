package cc.phos.atom.config;

import cc.phos.atom.domain.response.R;
import cc.phos.atom.enums.ErrorCode;
import cc.phos.atom.exception.BizException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 11:21:11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public R<Void> handleErrorCodeException(BizException e) {
        return R.error(e.getErrorCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> errors.add(fieldError.getDefaultMessage()));
        return R.error(ErrorCode.BAD_REQUEST, String.join(", ", errors));
    }


    @ExceptionHandler(Exception.class)
    public R<Void> handleException(Exception e) {
        return R.error(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}

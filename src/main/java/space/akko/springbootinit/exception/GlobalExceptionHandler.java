package space.akko.springbootinit.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import space.akko.springbootinit.common.BaseResponse;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.common.ResultUtils;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, ErrorCode.SYSTEM_ERROR.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public BaseResponse<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException", e);
        return ResultUtils.error(ErrorCode.PARAMS_ERROR, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public BaseResponse<?> constraintViolationExceptionHandler(ConstraintViolationException e) {
        log.error("ConstraintViolationException", e);
        return ResultUtils.error(ErrorCode.PARAMS_ERROR, e.getMessage());
    }
}

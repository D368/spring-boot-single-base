package com.tse.cost.exception;

import com.tse.cost.common.constant.ExceptionConstants;
import com.tse.cost.common.constant.ResCode;
import com.tse.cost.common.result.ResResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 自定义异常捕获类
 * @author liangw
 * @date 2020/8/28 14:40
 */
@RestControllerAdvice
@Slf4j
public class ExceptionCatch {
    @ExceptionHandler(ServiceException.class)
    public ResResult<Object> serviceException(ServiceException serviceException, HttpServletResponse response){
        ResCode resCode = serviceException.getResCode();
        int value = HttpStatus.FORBIDDEN.value();
        if (resCode.getCode().equals(value)){
            response.setStatus(value);
        }
        log.error("业务异常 code:"+resCode.getCode()+" message:"+resCode.getMessage(),serviceException);
        return ResResult.fail(resCode);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResResult exception(RuntimeException exception){
        log.error("系统异常",exception);
        return ResResult.fail(ExceptionConstants.SYSTEM_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResResult<Object> exception(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        FieldError fieldError = fieldErrors.get(fieldErrors.size() - 1);
        String defaultMessage = fieldError.getDefaultMessage();
        log.error("参数异常",exception);
        return ResResult.fail(HttpStatus.BAD_REQUEST.value(),defaultMessage);
    }


}

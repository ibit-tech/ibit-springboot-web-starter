package tech.ibit.web.springboot.autoconfigure;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import tech.ibit.web.springboot.exception.ApiException;
import tech.ibit.web.springboot.exception.DefaultErrorCode;
import tech.ibit.web.springboot.exception.ErrorCode;
import tech.ibit.web.springboot.response.Response;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * 错误日志处理
 *
 * @author iBit程序猿
 */
@ControllerAdvice
public class ApiExceptionConfigure {

    /**
     * 参数缺失
     *
     * @param e 异常
     * @return 异常返回
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public Response<?> handleError(MissingServletRequestParameterException e) {
        String message = String.format("Missing Request Parameter: %s", e.getParameterName());
        return Response.getInstance(DefaultErrorCode.ParameterMissing.CODE, message);
    }

    /**
     * 参数类型错误
     *
     * @param e 异常
     * @return 异常返回
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Response<?> handleError(MethodArgumentTypeMismatchException e) {
        String message = String.format("Method Argument Type Mismatch: %s", e.getName());
        return Response.getInstance(DefaultErrorCode.ParameterTypeError.CODE, message);
    }

    /**
     * 参数类型错误
     *
     * @param e 异常
     * @return 异常返回
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Response<?> handleError(MethodArgumentNotValidException e) {
        return getHandleError(e.getBindingResult());
    }

    /**
     * 参数类型错误
     *
     * @param e 异常
     * @return 异常返回
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Response<?> handleError(BindingResult e) {
        return getHandleError(e);
    }

    /**
     * 处理绑定错误
     *
     * @param e 绑定结果
     * @return 异常返回
     */
    private Response<?> getHandleError(BindingResult e) {
        FieldError error = e.getFieldError();
        if (null == error) {
            return Response.getInstance(DefaultErrorCode.ParameterTypeError.CODE);
        }
        String defaultMessage = error.getDefaultMessage();
        if (ApiException.isApiCode(defaultMessage)) {
            // 如果是已知系统异常，不捕获
            return getExceptionResponse(defaultMessage);
        }
        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
        return Response.getInstance(DefaultErrorCode.ParameterBindError.CODE, message);
    }

    /**
     * 参数校验错误
     *
     * @param e 异常
     * @return 异常返回
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Response<?> handleError(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String defaultMessage = violation.getMessage();
        if (ApiException.isApiCode(defaultMessage)) {
            // 如果是已知系统异常，不捕获
            return getExceptionResponse(defaultMessage);
        }
        String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
        String message = String.format("%s:%s", path, violation.getMessage());
        return Response.getInstance(DefaultErrorCode.ParameterValidError.CODE, message);
    }

    /**
     * 资源不存在
     *
     * @param e 异常
     * @return 异常返回
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public Response<?> handleError(NoHandlerFoundException e) {
        return getExceptionResponse(DefaultErrorCode.NotFound.MESSAGE, e);
    }

    /**
     * 消息不可读
     *
     * @param e 异常
     * @return 异常返回
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Response<?> handleError(HttpMessageNotReadableException e) {
        return getExceptionResponse(DefaultErrorCode.MessageNotReadable.MESSAGE, e);
    }

    /**
     * 方法不支持
     *
     * @param e 异常
     * @return 异常返回
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Response<?> handleError(HttpRequestMethodNotSupportedException e) {
        return getExceptionResponse(DefaultErrorCode.MethodNotSupported.MESSAGE, e);
    }

    /**
     * 流媒体类型不支持
     *
     * @param e 异常
     * @return 异常返回
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Response<?> handleError(HttpMediaTypeNotSupportedException e) {
        return getExceptionResponse(DefaultErrorCode.MediaTypeNotSupported.MESSAGE, e);
    }

    /**
     * 处理api异常
     *
     * @param e 异常
     * @return 异常返回
     */
    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public Response<?> handleError(ApiException e) {
        return Response.getInstance(e.getCode(), e.getMessage(), e.getData());
    }

    /**
     * 未知错误
     *
     * @param e 异常
     * @return 异常返回
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Response<?> handleError(Throwable e) {
        // 只有未知错误才打印堆栈信息
        return getExceptionResponse(ErrorCode.MESSAGE, e);
    }

    /**
     * 获取异常返回对象
     *
     * @param errorMessage 错误信息
     * @return 异常返回对象
     */
    private Response<?> getExceptionResponse(String errorMessage) {
        ApiException apiException = new ApiException(errorMessage);
        return Response.getInstance(apiException.getCode(), apiException.getMessage(), apiException.getData());
    }

    /**
     * 获取异常返回对象
     *
     * @param errorMessage 错误信息
     * @param e            异常
     * @return 异常返回对象
     */
    private Response<?> getExceptionResponse(String errorMessage, Throwable e) {
        ApiException apiException = new ApiException(errorMessage, e);
        return Response.getInstance(apiException.getCode(), apiException.getMessage(), apiException.getData(), apiException);
    }
}

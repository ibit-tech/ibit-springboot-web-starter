package tech.ibit.web.springboot.exception;

/**
 * 定义错误码定义错误码接口
 *
 * @author IBIT TECH
 */
public interface ErrorCode {

    /**
     * 分割符
     */
    String SPLIT = "__";


    /**
     * 系统默认错误
     */
    int CODE = 1000_0000;
    String MESSAGE = CODE + SPLIT + "系统未知错误";


    /**
     * 默认错误编码
     */
    int DEFAULT_CODE_PREFIX = 9999_0000;

}

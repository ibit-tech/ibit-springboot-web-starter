package tech.ibit.web.springboot.exception;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

/**
 * 定义api异常
 *
 * @author IBIT TECH
 */
@Data
public class ApiException extends RuntimeException {

    /**
     * 错误码-错误信息长途
     */
    private static final int CODE_MESSAGE_LENGTH = 2;


    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 错误数据
     */
    private Object data;


    /**
     * 构造函数
     *
     * @param errorCodeMessage 错误码与错误信息
     * @param throwable        异常
     */
    public ApiException(String errorCodeMessage, Throwable throwable) {
        this(errorCodeMessage, throwable, null);
    }

    /**
     * 构造函数
     *
     * @param errorCodeMessage 错误码与错误信息
     */
    public ApiException(String errorCodeMessage) {
        this(errorCodeMessage, null);
    }

    /**
     * 构造函数
     *
     * @param errorCodeMessage 错误码与错误信息
     * @param data             错误数据
     */
    public ApiException(String errorCodeMessage, Object data) {
        this(errorCodeMessage, null, data);
    }

    /**
     * 构造函数
     *
     * @param errorCodeMessage 错误码与错误信息
     * @param throwable        异常
     * @param data             错误数据
     */
    public ApiException(String errorCodeMessage, Throwable throwable, Object data) {
        super(errorCodeMessage, throwable);
        this.data = data;

        String[] str = errorCodeMessage.split(ErrorCode.SPLIT);
        if (CODE_MESSAGE_LENGTH == str.length) {
            this.code = Integer.parseInt(str[0]);
            this.message = str[1].trim();
        } else {
            this.code = ErrorCode.CODE;
            this.message = ErrorCode.MESSAGE;
        }
    }

    /**
     * 判断是否为系统错误
     *
     * @param errorCodeMessage 错误码
     * @return 判断结果
     */
    public static boolean isApiCode(String errorCodeMessage) {
        return StringUtils.isNotEmpty(errorCodeMessage) && errorCodeMessage.matches("\\d+__.*");
    }

}

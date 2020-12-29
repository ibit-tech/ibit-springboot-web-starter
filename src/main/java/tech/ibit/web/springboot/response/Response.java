package tech.ibit.web.springboot.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tech.ibit.web.springboot.context.WebContext;

/**
 * 自定义返回格式
 *
 * @param <T> data数据类型
 * @author iBit程序猿
 */
public class Response<T> {

    /**
     * 返回码
     */
    private int code = 200;

    /**
     * 返回消息
     */
    private String message = "S_OK";

    /**
     * 返回数据
     */
    private T data;

    @JsonIgnore
    private Throwable throwable;

    /**
     * 系统时间戳
     */
    private final long timestamp = System.currentTimeMillis();

    /**
     * 请求id
     */
    private final String requestId = WebContext.getRequestId();

    /**
     * 判断是否成功
     *
     * @return 是否成功
     */
    public boolean isSuccessful() {
        return 200 == code;
    }

    /**
     * 无参构造函数
     */
    private Response() {
    }

    /**
     * 构造函数
     *
     * @param data 数据
     */
    private Response(T data) {
        this.data = data;
    }


    /**
     * 构造函数
     *
     * @param code    编码
     * @param message 消息
     * @param data    数据
     */
    private Response(int code, String message, T data) {
        this(code, message, data, null);
    }


    /**
     * 构造函数
     *
     * @param code    编码
     * @param message 消息
     */
    private Response(int code, String message) {
        this(code, message, null);
    }

    /**
     * 构造函数
     *
     * @param code      编码
     * @param message   消息
     * @param data      数据
     * @param throwable 异常
     */
    private Response(int code, String message, T data, Throwable throwable) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.throwable = throwable;
    }

    /**
     * 获取实例
     *
     * @param code      编码
     * @param message   消息
     * @param data      数据
     * @param throwable 异常
     * @param <T>       data数据类型
     * @return 实例
     */
    public static <T> Response<T> getInstance(int code, String message, T data, Throwable throwable) {
        return new Response<>(code, message, data, throwable);
    }


    /**
     * 获取实例
     *
     * @return 实例
     */
    public static Response<?> getInstance() {
        return new Response<>();
    }

    /**
     * 获取实例
     *
     * @param data 数据
     * @param <T>  data数据类型
     * @return 实例
     */
    public static <T> Response<T> getInstance(T data) {
        return new Response<>(data);
    }


    /**
     * 获取实例
     *
     * @param code    编码
     * @param message 消息
     * @param data    数据
     * @param <T>     data数据类型
     * @return 实例
     */
    public static <T> Response<T> getInstance(int code, String message, T data) {
        return new Response<>(code, message, data);
    }


    /**
     * 获取实例
     *
     * @param code    编码
     * @param message 消息
     * @param <T>     data数据类型
     * @return 实例
     */
    public static <T> Response<T> getInstance(int code, String message) {
        return new Response<>(code, message);
    }

    /**
     * Gets the value of code
     *
     * @return the value of code
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets the value of message
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the value of data
     *
     * @return the value of data
     */
    public T getData() {
        return data;
    }

    /**
     * Gets the value of throwable
     *
     * @return the value of throwable
     */
    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * Gets the value of timestamp
     *
     * @return the value of timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Gets the value of requestId
     *
     * @return the value of requestId
     */
    public String getRequestId() {
        return requestId;
    }
}

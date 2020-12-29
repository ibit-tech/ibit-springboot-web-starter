package tech.ibit.web.springboot.log;

import tech.ibit.structlog4j.extend.MapToLog;
import tech.ibit.web.springboot.utils.DateUtils;

import java.util.Date;

/**
 * 访问日志
 *
 * @author iBit程序猿
 */
public class AccessLogItem implements MapToLog {

    /**
     * 登陆id
     */
    private String loginId;

    /**
     * 请求uri
     */
    private String uri;

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回message
     */
    private String message;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 参数内容
     */
    private String param;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 所用时间
     */
    private long usedTime;

    /**
     * 平台信息
     */
    private String platform;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * session id
     */
    private String sid;

    /**
     * 请求id
     */
    private String requestId;

    /**
     * 其他id
     */
    private String otherId;

    /**
     * 构造函数
     *
     * @param platform 平台
     */
    public AccessLogItem(String platform) {
        this.createTime = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
        this.platform = platform;
    }

    /**
     * Gets the value of loginId
     *
     * @return the value of loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets the loginId
     * <p>You can use getLoginId() to get the value of loginId</p>
     *
     * @param loginId loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Gets the value of uri
     *
     * @return the value of uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the uri
     * <p>You can use getUri() to get the value of uri</p>
     *
     * @param uri uri
     */
    public void setUri(String uri) {
        this.uri = uri;
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
     * Sets the code
     * <p>You can use getCode() to get the value of code</p>
     *
     * @param code code
     */
    public void setCode(int code) {
        this.code = code;
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
     * Sets the message
     * <p>You can use getMessage() to get the value of message</p>
     *
     * @param message message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the value of ip
     *
     * @return the value of ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets the ip
     * <p>You can use getIp() to get the value of ip</p>
     *
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Gets the value of param
     *
     * @return the value of param
     */
    public String getParam() {
        return param;
    }

    /**
     * Sets the param
     * <p>You can use getParam() to get the value of param</p>
     *
     * @param param param
     */
    public void setParam(String param) {
        this.param = param;
    }

    /**
     * Gets the value of method
     *
     * @return the value of method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the method
     * <p>You can use getMethod() to get the value of method</p>
     *
     * @param method method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Gets the value of usedTime
     *
     * @return the value of usedTime
     */
    public long getUsedTime() {
        return usedTime;
    }

    /**
     * Sets the usedTime
     * <p>You can use getUsedTime() to get the value of usedTime</p>
     *
     * @param usedTime usedTime
     */
    public void setUsedTime(long usedTime) {
        this.usedTime = usedTime;
    }

    /**
     * Gets the value of platform
     *
     * @return the value of platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the platform
     * <p>You can use getPlatform() to get the value of platform</p>
     *
     * @param platform platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * Gets the value of createTime
     *
     * @return the value of createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Sets the createTime
     * <p>You can use getCreateTime() to get the value of createTime</p>
     *
     * @param createTime createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets the value of sid
     *
     * @return the value of sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * Sets the sid
     * <p>You can use getSid() to get the value of sid</p>
     *
     * @param sid sid
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * Gets the value of requestId
     *
     * @return the value of requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the requestId
     * <p>You can use getRequestId() to get the value of requestId</p>
     *
     * @param requestId requestId
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * Gets the value of otherId
     *
     * @return the value of otherId
     */
    public String getOtherId() {
        return otherId;
    }

    /**
     * Sets the otherId
     * <p>You can use getOtherId() to get the value of otherId</p>
     *
     * @param otherId otherId
     */
    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }
}

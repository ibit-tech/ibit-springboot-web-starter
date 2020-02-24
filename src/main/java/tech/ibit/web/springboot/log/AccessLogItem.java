package tech.ibit.web.springboot.log;

import lombok.Data;
import tech.ibit.structlog4j.extend.MapToLog;
import tech.ibit.web.springboot.utils.DateUtils;

import java.util.Date;

/**
 * 访问日志
 *
 * @author IBIT TECH
 */
@Data
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
}

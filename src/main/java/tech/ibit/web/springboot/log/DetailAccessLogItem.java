package tech.ibit.web.springboot.log;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 详细访问日志（打印返回结果、请求头部、返回头部等信息）
 *
 * @author iBit程序猿
 */
public class DetailAccessLogItem extends AccessLogItem {

    /**
     * 返回结果
     */
    private String result;


    /**
     * 请求头部信息
     */
    private Map<String, String> requestHeaders;

    /**
     * 返回头部信息
     */
    private Map<String, String> responseHeaders;

    /**
     * 构造函数
     *
     * @param platform 平台
     */
    public DetailAccessLogItem(String platform) {
        super(platform);
    }


    public DetailAccessLogItem(AccessLogItem logItem) {
        super(logItem.getPlatform());
        try {
            PropertyUtils.copyProperties(this, logItem);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            // ignore
        }
    }

    /**
     * Gets the value of result
     *
     * @return the value of result
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets the result
     * <p>You can use getResult() to get the value of result</p>
     *
     * @param result result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Gets the value of requestHeaders
     *
     * @return the value of requestHeaders
     */
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /**
     * Sets the requestHeaders
     * <p>You can use getRequestHeaders() to get the value of requestHeaders</p>
     *
     * @param requestHeaders requestHeaders
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    /**
     * Gets the value of responseHeaders
     *
     * @return the value of responseHeaders
     */
    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * Sets the responseHeaders
     * <p>You can use getResponseHeaders() to get the value of responseHeaders</p>
     *
     * @param responseHeaders responseHeaders
     */
    public void setResponseHeaders(Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }
}

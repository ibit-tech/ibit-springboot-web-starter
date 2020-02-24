package tech.ibit.web.springboot.log;

import lombok.Data;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 详细访问日志（打印返回结果、请求头部、返回头部等信息）
 *
 * @author IBIT TECH
 */
@Data
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
}

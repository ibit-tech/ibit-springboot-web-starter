package tech.ibit.web.springboot.session;

import java.util.Map;

/**
 * 定义session
 *
 * @author iBit程序猿
 */
public interface Session {


    /**
     * 获取sessionId
     *
     * @return sessionId
     */
    String getSessionId();


    /**
     * 获取属性
     *
     * @param attributeKey 属性键
     * @return 属性值
     */
    Object getAttribute(String attributeKey);


    /**
     * 获取多个属性
     *
     * @param attributeKeys 属性键
     * @return 属性键值Map
     */
    Map<String, Object> getAttributes(String... attributeKeys);


    /**
     * 设置属性
     *
     * @param attributeKey   属性键
     * @param attributeValue 属性值
     */
    void setAttribute(String attributeKey, Object attributeValue);

    /**
     * 设置多个属性
     *
     * @param attributes 属性map
     */
    void setAttributes(Map<String, Object> attributes);

    /**
     * 注销session
     */
    void invalid();


    /**
     * 是否无效
     *
     * @return 是否无效
     */
    boolean isInvalid();

}

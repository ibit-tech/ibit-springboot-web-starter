package tech.ibit.web.springboot.context;


import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tech.ibit.web.springboot.session.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上下文
 *
 * @author IBIT TECH
 */
public class WebContext {

    /**
     * 头部"User-Agent"
     */
    private static final String HEADER_USER_AGENT = "User-Agent";

    /**
     * 请求id
     */
    private String requestId;

    /**
     * session
     */
    private Session session;

    /**
     * 开始时间
     */
    private long beginTime = -1;

    /**
     * 定义上下文
     */
    private static ThreadLocal<WebContext> contextThreadLocal = new ThreadLocal<>();

    /**
     * 初始化
     */
    public static void init() {
        WebContext context = new WebContext();
        contextThreadLocal.set(context);
    }

    /**
     * 设置请求id
     *
     * @param requestId 请求id
     */
    public static void setRequestId(String requestId) {
        if (null != contextThreadLocal.get()) {
            contextThreadLocal.get().requestId = requestId;
        }
    }

    /**
     * 设置session
     *
     * @param session session
     */
    public static void setSession(Session session) {
        if (null != contextThreadLocal.get()) {
            contextThreadLocal.get().session = session;
        }
    }

    /**
     * 设置开始时间
     *
     * @param beginTime 开始时间
     */
    public static void setBeginTime(long beginTime) {
        if (null != contextThreadLocal.get()) {
            contextThreadLocal.get().beginTime = beginTime;
        }
    }

    /**
     * 获取请求
     *
     * @return 请求
     */
    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes) requestAttributes).getRequest();
        }
        return null;
    }

    /**
     * 获取`User-Agent`
     *
     * @return UserAgent
     */
    public static String getUserAgent() {
        HttpServletRequest request = getRequest();
        return null == request ? null : request.getHeader(HEADER_USER_AGENT);
    }

    /**
     * 获取返回
     *
     * @return 返回
     */
    public static HttpServletResponse getResponse() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes) requestAttributes).getResponse();
        }
        return null;
    }

    /**
     * 获取session
     *
     * @return session
     */
    public static Session getSession() {
        return null == contextThreadLocal.get() ? null : contextThreadLocal.get().session;
    }

    /**
     * 获取请求id
     *
     * @return 请求id
     */
    public static String getRequestId() {
        return null == contextThreadLocal.get() ? null : contextThreadLocal.get().requestId;
    }

    /**
     * 获取开始时间
     *
     * @return 开始时间
     */
    public static long getBeginTime() {
        return null == contextThreadLocal.get() ? -1 : contextThreadLocal.get().beginTime;
    }


    /**
     * 销毁
     */
    public static void destroy() {
        contextThreadLocal.remove();
    }
}

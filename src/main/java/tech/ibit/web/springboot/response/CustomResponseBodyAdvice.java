package tech.ibit.web.springboot.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import tech.ibit.web.springboot.response.annotation.CustomResponse;

import java.lang.reflect.Method;

/**
 * 自定义返回格式
 *
 * @author iBit程序猿
 */
@RestControllerAdvice
public class CustomResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        Method method = methodParameter.getMethod();
        return null != method && null != method.getAnnotation(CustomResponse.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter
            , MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest
            , ServerHttpResponse serverHttpResponse) {
        if (o instanceof Response) {
            return o;
        }
        return Response.getInstance(o);
    }
}

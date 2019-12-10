package xyz.drafter.handwriting.argumentResolver;

import xyz.drafter.handwriting.annotation.DrafterService;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author wangmeng
 * @date 2019/12/9
 * @desciption
 */
@DrafterService("httpServletReponseArgResolver")
public class HttpServletReponseArgResolver implements ArgumentResolver {
    @Override
    public boolean support(Class<?> type, int index, Method method) {

        // 判断是否是ServletRequest 的子类
        return ServletResponse.class.isAssignableFrom(type);
    }

    @Override
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int index, Method method) {
        return response;
    }
}

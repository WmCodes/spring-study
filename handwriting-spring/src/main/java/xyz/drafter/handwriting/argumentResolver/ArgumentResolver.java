package xyz.drafter.handwriting.argumentResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author wangmeng
 * @date 2019/12/9
 * @desciption
 */
public interface ArgumentResolver {

    //判断是否为当前需要解析的类
    public boolean support(Class<?> type, int index, Method method);

    // 参数解析
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response,
                                   Class<?> type,int index,Method method);

}

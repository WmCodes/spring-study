package xyz.drafter.handwriting.argumentResolver;

import xyz.drafter.handwriting.annotation.DrafterRequestParam;
import xyz.drafter.handwriting.annotation.DrafterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author wangmeng
 * @date 2019/12/9
 * @desciption
 */
@DrafterService("requestParamArgResolver")
public class RequestParamArgResolver implements ArgumentResolver {
    @Override
    public boolean support(Class<?> type, int index, Method method) {


        Annotation[][] anno = method.getParameterAnnotations();
        Annotation[] paramAnnos = anno[index];
        for (Annotation an :paramAnnos){
            if (DrafterRequestParam.class.isAssignableFrom(an.getClass())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int index, Method method) {

        Annotation[][] anno = method.getParameterAnnotations();
        Annotation[] paramAnnos = anno[index];
        for (Annotation an :paramAnnos){
            if (DrafterRequestParam.class.isAssignableFrom(an.getClass())){
                DrafterRequestParam dr = (DrafterRequestParam)an;
                String value = dr.value();
                return request.getParameter(value);
            }
        }
        return null;
    }
}

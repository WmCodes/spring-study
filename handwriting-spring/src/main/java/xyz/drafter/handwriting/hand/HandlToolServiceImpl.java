package xyz.drafter.handwriting.hand;

import xyz.drafter.handwriting.annotation.DrafterService;
import xyz.drafter.handwriting.argumentResolver.ArgumentResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmeng
 * @date 2019/12/9
 * @desciption
 */
@DrafterService("drafterHandTool")
public class HandlToolServiceImpl implements HandToolsService {
    @Override
    public Object[] hand(HttpServletRequest request, HttpServletResponse response, Method method, Map<String, Object> beans) {
        Class<?>[] paramClazzs = method.getParameterTypes();
        Object[] args = new Object[paramClazzs.length];

        //拿到所有实现了ArgumentResolver这个接口的实例
        Map<String,Object> argReslovers = getInstanceType(beans, ArgumentResolver.class);

        int index = 0;
        int i = 0;
        for (Class<?> paramClazz:paramClazzs){
            for (Map.Entry<String,Object> entry:argReslovers.entrySet()){
                ArgumentResolver ar = (ArgumentResolver)entry.getValue();
                if (ar.support(paramClazz, index, method)){
                    args[i++] = ar.argumentResolver(request, response, paramClazz, index, method);

                }
            }
            index++;
        }
        return args;
    }




    public Map<String,Object> getInstanceType(Map<String,Object>beans,Class type){
        Map<String,Object> resultBeans = new HashMap<>();
        for (Map.Entry<String,Object> entry:beans.entrySet()){
            Class<?>[] infs = entry.getValue().getClass().getInterfaces();
            if (infs != null && infs.length >0){
                for (Class<?> inf :infs){
                    if (inf.isAssignableFrom(type)){
                        resultBeans.put(entry.getKey(),entry.getValue());
                    }
                }
            }
        }
        // 获取所有实现解析的bean
        return resultBeans;
    }
}

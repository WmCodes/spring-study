package xyz.drafter.handwriting.hand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author wangmeng
 * @date 2019/12/9
 * @desciption
 */
public interface HandToolsService {

    public Object[] hand(HttpServletRequest request, HttpServletResponse response, Method method, Map<String,Object> beans);
}

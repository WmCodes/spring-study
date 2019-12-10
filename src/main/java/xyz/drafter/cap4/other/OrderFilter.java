package xyz.drafter.cap4.other;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
public class OrderFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 过滤请求
        System.out.println("Order Filter....do filter");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}

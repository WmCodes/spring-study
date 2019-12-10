package xyz.drafter.cap4;

import xyz.drafter.cap4.other.OrderFilter;
import xyz.drafter.cap4.other.OrderListener;
import xyz.drafter.cap4.other.OrderServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
@HandlesTypes(value = {DrafterService.class})
public class DrafterServletContainerInitializer implements ServletContainerInitializer {


    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("有用的类型：");
        for (Class<?> clz:set){
            System.out.println(clz);
        }
        // 注册OrderServlet组件
        ServletRegistration.Dynamic orderServlet = servletContext.addServlet("orderServlet", new OrderServlet());
        orderServlet.addMapping("/orderTest");

        // 注册监听器listener
        servletContext.addListener(OrderListener.class);

        // 注册filter
        FilterRegistration.Dynamic orderFilter = servletContext.addFilter("orderFilter", OrderFilter.class);
        // 添加filer映射信息
        orderFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");

    }
}

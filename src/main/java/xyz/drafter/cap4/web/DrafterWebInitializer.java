package xyz.drafter.cap4.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import xyz.drafter.cap4.web.config.DrafterAppConfig;
import xyz.drafter.cap4.web.config.DrafterRootConfig;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
public class DrafterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // web容器启动的时候创建的对象，调用方法来初始化容器

    // 根容器 RootWebApplicationContext
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DrafterRootConfig.class};
    }

    // 子容器 ServletWebApplicationContext
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DrafterAppConfig.class};
    }

    // 获取dispatchServlet映射信息
    // 拦截所有请求：(静态资源，js，css，png)，不包括*.jsp
    // jsp的解析是tomcat的jsp解析引擎
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

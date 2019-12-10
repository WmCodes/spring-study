package xyz.drafter.cap4.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
@ComponentScan(value = "xyz.drafter.cap4.web",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)
@EnableWebMvc
public class DrafterAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 比如说想用JSP解析器，默认的所有页面都从/WEB-INF/aaa.jsp
        registry.jsp("/WEB-INF/pages/",".jsp");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 开启图片解析器
        configurer.enable();
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DrafterInterceptor()).addPathPatterns("/**");
    }
}

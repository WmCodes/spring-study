package xyz.drafter.dell.ch3;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author wangmeng
 * @date 2019/12/8
 * @desciption
 */
@HandlesTypes(value = {DrafterService.class})
public class DrafterServletContainerInitializer implements ServletContainerInitializer {
    // set ：父类感兴趣的子类型
    // servletContext

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

        System.out.println("有用的类型:");
        for (Class<?> clz:set){
            System.out.println(clz);
        }
    }
}

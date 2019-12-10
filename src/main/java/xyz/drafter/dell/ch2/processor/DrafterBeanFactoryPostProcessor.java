package xyz.drafter.dell.ch2.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/12/7
 * @desciption
 */
@Component
public class DrafterBeanFactoryPostProcessor implements BeanFactoryPostProcessor {



    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("DrafterBeanFactoryPostProcessor.......");
        // 所有bean的定义，已经加载到beanFactory，此时bean的实例还未创建
        int count = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionName = beanFactory.getBeanDefinitionNames();
        System.out.println("当前count: "+count);
        System.out.println("当前beanNames： "+ Arrays.asList(beanDefinitionName));
    }
}

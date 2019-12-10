package xyz.drafter.cap1.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import xyz.drafter.cap1.bean.Pig;

/**
 * @author drafter
 * @date 2019/12/4
 * @desciption
 */
public class DrafterImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry  BeanDefinition 信息
     *              把所有需要添加到容器的bean加入
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean bean1 = registry.containsBeanDefinition("xyz.drafter.cap1.bean.Dog");
        boolean bean2 = registry.containsBeanDefinition("xyz.drafter.cap1.bean.Cat");
        // 如果Dog 和Cat 同时存在于IOC容器中  那么创建Pig类
        // 对于我们要注册的bean，给bean进行封装
        if (bean1 && bean2){
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig",beanDefinition);

        }
    }
}

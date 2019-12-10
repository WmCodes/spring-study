package xyz.drafter.cap1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import xyz.drafter.cap1.Person;
import xyz.drafter.cap1.bean.Cat;
import xyz.drafter.cap1.bean.Dog;

/**
 * @author drafter
 * @date 2019/12/4
 * @desciption
 */
@Configuration
@Import(value = {Dog.class, Cat.class,DrafterImportSelector.class,DrafterImportBeanDefinitionRegistrar.class})
@ComponentScan("xyz.drafter.cap1.bean")
public class SpringConfig {

    //@Scope("prototype")
   // @Lazy
    @Bean(value = "person",initMethod = "init",destroyMethod = "destory")
    public Person person01(){
        System.out.println("向容器中添加Person");
        return new Person("drafter",20);
    }
    @Bean
    public DrafterFactoryBean drafterFactoryBean(){
        return new DrafterFactoryBean();
    }


/*    @Conditional(WinCondition.class)
    @Bean("drafter")
    public Person drafter(){
        System.out.println("向容器中添加Drafter");
        return new Person("drafter",50);
    }

    @Conditional(LinuxCondition.class)
    @Bean("xyz")
    public Person xyz(){
        System.out.println("向容器中添加xyz");
        return new Person("xyz",90);
    }*/


}

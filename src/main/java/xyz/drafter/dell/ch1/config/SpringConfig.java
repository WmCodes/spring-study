package xyz.drafter.dell.ch1.config;

import org.springframework.context.annotation.*;
import xyz.drafter.dell.ch1.bean.Bird;
import xyz.drafter.dell.ch1.dao.TestDao;

/**
 * @author wangmeng
 * @date 2019/12/4
 * @desciption
 */
@Configuration
@PropertySource(value = "classpath:/test.properties")
@ComponentScan({"xyz.drafter.dell.ch1.controller","xyz.drafter.dell.ch1.service","xyz.drafter.dell.ch1.dao"})
public class SpringConfig {

    @Bean
    public Bird bird(){
        return new Bird();
    }

    // 指定优先级
    @Primary
    @Bean("testDao2")
    public TestDao testDao(){
         return new TestDao("2");
    }
}

package xyz.drafter.dell.ch2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import xyz.drafter.dell.ch2.bean.Moon;


/**
 * @author wangmeng
 * @date 2019/12/7
 * @desciption
 */
@Configuration
@ComponentScan("xyz.drafter.dell.ch2")
public class SpringConfig2 {

    @Bean
    public Moon getMoon(){
        return new Moon();
    }
}

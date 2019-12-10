package xyz.drafter.cap1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import xyz.drafter.cap1.dao.TestDao;

/**
 * @author drafter
 * @date 2019/12/4
 * @desciption
 */
@Configuration
@ComponentScan({"xyz.drafter.cap1.bean"})
public class SpringConfig3 {

    @Primary
    @Bean("testDao2")
    public TestDao testDao(){
        TestDao testDao = new TestDao();
        testDao.setFlag("2");
        return testDao;

    }
}

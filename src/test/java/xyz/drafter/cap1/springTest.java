package xyz.drafter.cap1;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import xyz.drafter.cap1.config.SpringConfig2;
import xyz.drafter.dell.ch1.bean.Bird;
import xyz.drafter.dell.ch1.config.SpringConfig;
import xyz.drafter.dell.ch1.service.TestService;


/**
 * @author wangmeng
 * @date 2019/12/4
 * @desciption
 */
public class springTest {


    @Test
    public void valueTest(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);



        String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }
        Bird bird = (Bird) annotationConfigApplicationContext.getBean("bird");
        System.out.println(bird);
        System.out.println("IOC容器创建完成");

        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        System.out.println("environment: ===="+environment.getProperty("bird.color"));


        annotationConfigApplicationContext.close();
    }

    @Test
    public void testDI(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        TestService testService = annotationConfigApplicationContext.getBean(TestService.class);
        testService.printTest();
        // 直接从容器中获取testDao  和使用Autowired注解来取比较
/*        TestDao testDao = annotationConfigApplicationContext.getBean(TestDao.class);
        System.out.println(testDao);*/
        annotationConfigApplicationContext.close();
    }


    @Test
    public void beanDefinitionTest(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig2.class);

        System.out.println("IOC容器初始化完成");
        annotationConfigApplicationContext.close();
    }
}

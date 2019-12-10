package xyz.drafter.cap1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.drafter.cap1.bean.Moon;
import xyz.drafter.cap1.bean.Sun;
import xyz.drafter.cap1.config.SpringConfig;
import xyz.drafter.cap1.config.SpringConfig2;
import xyz.drafter.cap1.config.SpringConfig3;
import xyz.drafter.cap1.dao.TestDao;
import xyz.drafter.cap1.service.OrderService;
import xyz.drafter.cap2.aop.aop.Caculator;
import xyz.drafter.cap2.aop.config.SpringConfig5;
import xyz.drafter.cap2.config.SpringConfig4;

/**
 * @author drafter
 * @date 2019/12/4
 * @desciption
 */
public class MainTest1 {

   @Test
    public void testBean(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    @Test
    public void testBean1(){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
       /* Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);*/
        String[] namesForBean = applicationContext.getBeanNamesForType(Person.class);
        for (String name:namesForBean){
            System.out.println(name);
        }
    }

    @Test
    public void annotationTest01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig2.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName: beanNames){
            System.out.println(beanName);
        }

    }

    @Test
    public void scopTest01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        Object bean1 = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean1 == bean2);
    }


    @Test
    public void lazyTest01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("IOC容器创建完成......");
        applicationContext.getBean("person");

    }


    @Test
    public void conditionTest01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("IOC容器创建完成......");
    }

    @Test
    public void importTest1(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        // 取的Monkey 类
        Object bean1 = applicationContext.getBean("drafterFactoryBean");
        Object bean2 = applicationContext.getBean("drafterFactoryBean");
        System.out.println("bean的类型："+bean1.getClass());
        System.out.println(bean1 == bean2);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName: beanNames){
            System.out.println(beanName);
        }

    }

    @Test
    public void beanTest01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("IOC容器创建完成");
        applicationContext.close();

    }

    @Test
    public void autowiredTest01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig3.class);
        System.out.println("IOC容器创建完成");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.printLn();

        TestDao testDao = applicationContext.getBean(TestDao.class);
        System.out.println(testDao);
        applicationContext.close();

    }


    @Test
    public void autowiredTest02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig3.class);
        System.out.println("IOC容器创建完成");

        Sun sun = applicationContext.getBean(Sun.class);
        System.out.println(sun.getMoon());

        Moon moon = applicationContext.getBean(Moon.class);
        System.out.println(moon);
        applicationContext.close();

    }

    @Test
    public void awareTest01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig4.class);
        System.out.println("IOC容器创建完成: "+ applicationContext);


        applicationContext.close();

    }


    @Test
    public void AOPTest01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig5.class);
        System.out.println("IOC容器创建完成: "+ applicationContext);
        Caculator c = applicationContext.getBean(Caculator.class);
        int result = c.div(4, 3);
        System.out.println(result);

        applicationContext.close();

    }



}

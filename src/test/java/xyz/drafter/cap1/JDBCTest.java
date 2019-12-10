package xyz.drafter.cap1;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.drafter.cap3.config.SpringConfig6;
import xyz.drafter.cap3.service.OrderService;

/**
 * @author drafter
 * @date 2019/12/6
 * @desciption
 */
public class JDBCTest {

    @Test
    public void jdbcTest01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig6.class);

        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.addOrder();

        applicationContext.close();
    }
}

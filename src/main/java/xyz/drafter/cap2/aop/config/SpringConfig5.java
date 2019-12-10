package xyz.drafter.cap2.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import xyz.drafter.cap2.aop.aop.Caculator;
import xyz.drafter.cap2.aop.aop.LogAspects;

/**
 * @author drafter
 * @date 2019/12/5
 * @desciption
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class SpringConfig5 {
    /**
     *
     * 日志切面类的方法需要动态感知到div()方法运行
     *      通知方法:
     *          前置通知: logStart(); 在我们执行div()除法之前运行(@Before)
     *          后置通知: logEnd(); 在我们目标方法div()运行结束之后，不管有没有异常(@After)
     *          返回通知: logReturn(); 在我们目标方法div正常返回值后执行，异常则不执行(@AfterReturning)
     *          异常通知: logException(); 在我们的目标div出现异常后运行(@AfterThrowing)
     *          环绕通知: 动态代理，需要手动执行joinPoint.procced(),其实就是执行我们的目标方法div,执行div()之前相当于前置通知，执行之后相当于后置通知 (@Around)
     */
    @Bean
    public Caculator caculator(){
        return new Caculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}

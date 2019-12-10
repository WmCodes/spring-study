package xyz.drafter.cap2.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author drafter
 * @date 2019/12/5
 * @desciption
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int xyz.drafter.cap2.aop.aop.Caculator.*(..))")
    public void pointCut(){

    }

    // 日志切面类

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+" 除法运行...参数列表: {"+ Arrays.asList(joinPoint.getArgs()) +"}");

    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("除法结束....");

    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result){
        System.out.println("除法正常返回....运行结果是:{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("除法异常....异常信息是:{"+exception+"}");
    }

/*    @Around("pointCut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("@Around 执行目标方法之前");
        Object o = proceedingJoinPoint.proceed();
        System.out.println("@Around 执行目标方法之后");
        return o;
    }*/
}

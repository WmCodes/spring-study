package xyz.drafter.cap1.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author drafter
 * @date 2019/12/4
 * @desciption
 */
@Component
public class Train implements InitializingBean, DisposableBean {


    public Train() {
        System.out.println("Train......constructor");
    }

    /**
     *
     * @throws Exception
     * bean 销毁时调用此方法
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("Train.....destory");
    }

    /**
     *
     * @throws Exception
     * 为bean属性赋值和初始化完成后调用
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Train......afterPropertiesSet.....");
    }
}

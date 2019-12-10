package xyz.drafter.cap1.bean;

import org.springframework.stereotype.Component;

/**
 * @author drafter
 * @date 2019/12/5
 * @desciption
 */
@Component
public class Moon {

    public Moon() {
        System.out.println("Moon constructor...");
    }

    public void init(){
        System.out.println("Moon  init.....");
    }

    public void destroy(){
        System.out.println("Moon destroy");
    }

}

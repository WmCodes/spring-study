package xyz.drafter.cap1.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author drafter
 * @date 2019/12/4
 * @desciption
 */
@Component
public class Jeep {
    public Jeep() {
        System.out.println("jeep .....constructor...");
    }


    @PostConstruct
    public void init(){
        System.out.println("jeep.....init");
    }

    @PreDestroy
    public void destory(){
        System.out.println("jeep....destory");
    }
}

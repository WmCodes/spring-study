package xyz.drafter.cap1.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author drafter
 * @date 2019/12/5
 * @desciption
 */
@Component
public class Sun {

    private Moon moon;


    @Autowired
    public Sun(Moon moon) {
        this.moon = moon;
        System.out.println("-------");
    }

    public Moon getMoon() {
        return moon;
    }

    //@Autowired
    public void setMoon(Moon moon) {
        this.moon = moon;
    }

    @Override
    public String toString() {
        return "Sun{" +
                "moon=" + moon +
                '}';
    }
}

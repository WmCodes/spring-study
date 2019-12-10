package xyz.drafter.cap1.config;

import org.springframework.beans.factory.FactoryBean;
import xyz.drafter.cap1.bean.Monkey;

/**
 * @author drafter
 * @date 2019/12/4
 * @desciption
 */
public class DrafterFactoryBean implements FactoryBean<Monkey> {


    @Override
    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    @Override
    public Class<?> getObjectType() {
        return Monkey.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

package xyz.drafter.cap1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.drafter.cap1.dao.TestDao;

/**
 * @author drafter
 * @date 2019/12/4
 * @desciption
 */
@Service
public class OrderService {

    //@Qualifier("testDao")
    @Autowired
    private TestDao testDao;

    public void printLn(){
        System.out.println("service ....."+testDao);
    }


}

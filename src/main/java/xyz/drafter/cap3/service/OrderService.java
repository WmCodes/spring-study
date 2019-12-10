package xyz.drafter.cap3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.drafter.cap3.dao.OrderDao;

/**
 * @author drafter
 * @date 2019/12/6
 * @desciption
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional
    public void addOrder(){
        orderDao.insert();
        System.out.println("插入成功...");
        //int a = 1/0;
    }
}

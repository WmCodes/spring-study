package xyz.drafter.cap4.web.service;

import org.springframework.stereotype.Service;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
@Service
public class OrderService {

    public String goBuy(String orderId){
        return "orderId ==== "+orderId;
    }
}

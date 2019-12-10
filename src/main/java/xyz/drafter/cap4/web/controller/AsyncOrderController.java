package xyz.drafter.cap4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
@Controller
public class AsyncOrderController {

    @ResponseBody
    @RequestMapping("/order01")
    public Callable<String> order01(){
        System.out.println("主线程开始......"+Thread.currentThread()+"----"+System.currentTimeMillis());

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("副线程开始......"+Thread.currentThread()+"----"+System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("副线程结束......"+Thread.currentThread()+"----"+System.currentTimeMillis());
                // 返回到页面的内容
                return "order buy successful....";
            }
        };


        System.out.println("主线程结束......"+Thread.currentThread()+"----"+System.currentTimeMillis());
        return callable;
    }


    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder(){
        DeferredResult<Object> deferredResult = new DeferredResult<>((long)5000,"create fail.....");
        DrafterDeferredQueue.save(deferredResult);
        return deferredResult;
    }

    @ResponseBody
    @RequestMapping("/get")
    public String get(){
        String order = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DrafterDeferredQueue.get();
        // 模拟订单服务返回的结果
        deferredResult.setResult(order);
        // DrafterDeferredQueue.save(deferredResult);
        return "get method order= "+order;
    }


}

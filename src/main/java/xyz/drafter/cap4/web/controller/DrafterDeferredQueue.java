package xyz.drafter.cap4.web.controller;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
public class DrafterDeferredQueue {

    // 一个队列
    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedQueue<>();
    public static void save(DeferredResult<Object> deferredResult){
        queue.add(deferredResult);
    }

    // 获取队列第一个元素
    public static DeferredResult<Object> get(){
        return queue.poll();
    }


}

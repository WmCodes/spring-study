package xyz.drafter.cap4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
@Controller
public class OrderController {

    @ResponseBody
    @RequestMapping("/buy")
    public String buy(){
        return "buy success.....";
    }

    @RequestMapping("/ok")
    public String ok(){
        // 到自定的appConfig的子容器，找到/WEB-INF/pages/ok.jsp
        return "ok";
    }
}

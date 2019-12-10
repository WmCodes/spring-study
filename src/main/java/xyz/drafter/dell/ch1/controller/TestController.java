package xyz.drafter.dell.ch1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import xyz.drafter.dell.ch1.service.TestService;

/**
 * @author wangmeng
 * @date 2019/12/4
 * @desciption
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;
}

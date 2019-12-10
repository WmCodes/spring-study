package xyz.drafter.dell.ch1.service;

import org.springframework.stereotype.Service;
import xyz.drafter.dell.ch1.dao.TestDao;

import javax.annotation.Resource;

/**
 * @author wangmeng
 * @date 2019/12/4
 * @desciption
 */
@Service
public class TestService {


    // 指定注入的beanID
    //@Qualifier("testDao2")
    //@Autowired

    //效果与Autowired一样
    // 但是不支持Primary功能
    // 不支持Autowired false
    @Resource(name = "testDao2")
    private TestDao testDao;

    public void printTest(){
        System.out.println(testDao);
    }
}

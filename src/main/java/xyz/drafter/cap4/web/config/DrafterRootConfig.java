package xyz.drafter.cap4.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
@ComponentScan(value = "xyz.drafter.cap4.web",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
public class DrafterRootConfig {

    // 对非controller层进入bean注入
}

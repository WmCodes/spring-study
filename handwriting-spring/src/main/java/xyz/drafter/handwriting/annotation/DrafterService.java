package xyz.drafter.handwriting.annotation;

import java.lang.annotation.*;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DrafterService {
    String value() default "";
}

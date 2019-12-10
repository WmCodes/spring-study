package xyz.drafter.handwriting.annotation;

import java.lang.annotation.*;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DrafterRequestParam {
    String value() default "";
}

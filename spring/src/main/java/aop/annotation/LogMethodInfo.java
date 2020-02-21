package aop.annotation;

import java.lang.annotation.*;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/20 19:00
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogMethodInfo {
    boolean open() default false;
    String description() default "";
}

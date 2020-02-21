package aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/20 18:43
 */
@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfig {
    @Bean
    public TestBean testBean(){
        return new TestBean();
    }
}

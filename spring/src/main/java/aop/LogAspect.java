package aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/20 18:43
 */
@Aspect
//@Component
public class LogAspect {
    @Pointcut("@annotation(aop.annotation.LogMethodInfo)")
    public void logMethodAspect() {
    }

    @Around(value = "logMethodAspect()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //是否记录日志
        boolean logMethod = Util.isLogMethod(proceedingJoinPoint);
        //类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //请求方法
        String method =  proceedingJoinPoint.getSignature().getName() + "()";
        System.out.println("class: " + className);
        System.out.println("method: " + method);
        System.out.println("log switch is: " + (logMethod? "open": "closed"));
        if(logMethod){
            System.out.println("params:" + Arrays.toString(proceedingJoinPoint.getArgs()));
        }
        Object result = proceedingJoinPoint.proceed();
        if(logMethod){
            System.out.println("result:" + result.toString());
        }
        System.out.println("-----");
        return result;
    }
}

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
    /**
     * 层切点
     */
    @Pointcut("@annotation(aop.annotation.LogMethodInfo)")
    public void logMethodAspect() {
    }

    /**
     * @param joinPoint 切点
     */
//    @Before(value = "logMethodAspect()&& @LogMethodInfo()")
    public void doBefore(JoinPoint joinPoint) {
        try {
            //是否记录日志
            boolean logMethod = Util.isLogMethod(joinPoint);
            if(!logMethod){
                return;
            }
            //类名
            String className = joinPoint.getTarget().getClass().getName();
            //请求方法
            String method =  joinPoint.getSignature().getName() + "()";
            //方法参数
            String methodParam = StringUtils.join(Arrays.asList(joinPoint.getArgs()), ",");
            StringBuilder sb = new StringBuilder(1000);
            sb.append("方法信息");
            sb.append("ClassName     :  ").append(className).append("\n");
            sb.append("MethodName :  ").append(method).append("\n");
            sb.append("MethodParams :  ").append(methodParam).append("\n");
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @AfterReturning(returning = "retVal", value = "logMethodAspect()&& @LogMethodInfo()")
    public void doAfterReturning(JoinPoint joinPoint, Object retVal) throws Throwable {
        try {
            //是否记录日志
            boolean logMethod = Util.isLogMethod(joinPoint);
            if(!logMethod){
                return;
            }
            //类名
            String className = joinPoint.getTarget().getClass().getName();
            //请求方法
            String method =  joinPoint.getSignature().getName() + "()";
            //方法参数
            String methodParam = StringUtils.join(Arrays.asList(joinPoint.getArgs()), ",");
            StringBuilder sb = new StringBuilder(1000);
            sb.append("方法信息");
            sb.append("ClassName     :  ").append(className).append("\n");
            sb.append("MethodName :  ").append(method).append("\n");
            sb.append("MethodParams :  ").append(methodParam).append("\n");
            sb.append("Result: ").append(retVal.toString()).append("\n");
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取执行时间
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
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
        Object ob = proceedingJoinPoint.proceed();
        if(logMethod){
            System.out.println("result:" + ob.toString());
        }
        System.out.println("-----");
        return ob;
    }
}

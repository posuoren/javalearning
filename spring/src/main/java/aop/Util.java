package aop;

import aop.annotation.LogMethodInfo;
import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/20 19:08
 */
public class Util {

    /**
     * @param joinPoint 切点
     * @return 方法描述
     */
    public static boolean isLogMethod(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        boolean open = false;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    open = method.getAnnotation(LogMethodInfo.class).open();
                    break;
                }
            }
        }
        return open;
    }
}

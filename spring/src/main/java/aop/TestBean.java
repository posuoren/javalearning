package aop;

import aop.annotation.LogMethodInfo;
import org.springframework.context.annotation.Bean;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/20 19:20
 */
public class TestBean {

    @LogMethodInfo
    public String testAOP(String a){
        System.out.println("testAOP");
        return "111";
    }

    @LogMethodInfo(open=true)
    public String testAopOpen(String first, String second){
        return first + second;
    }
}

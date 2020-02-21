package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/20 19:19
 */
public class StartDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class, StartDemo.class, LogAspect.class);
        TestBean student = (TestBean) context.getBean(TestBean.class);
        student.testAOP("test");
        student.testAopOpen("测试打开", "guanbi");
    }
}

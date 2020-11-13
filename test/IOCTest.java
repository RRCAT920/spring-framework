import com.huzihao.bean.Person;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huzihao
 * @since 2020/11/13 21:09
 */
public class IOCTest {
//    注意点：
//    bin目录即类路径
//    所有源码包都会放入类路径
//    java: /bin/
//    web: /WEB-INF/classes/
//
//    ApplicationContext(IOC容器接口)
//    实现类: ClassPathXmlApplicationContext: ioc容器的配置文件在类路径
//          FileSystemXmlApplicationContext：配置文件在磁盘路径
//
//    组件的注册和获取过程：
//      组件的创建工作为容器完成
//      何时创建：容器中对象的创建在容器创建时发生
//      同一组件在容器中单例
//      获取容器中没有的组件：
//      org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'person03' is defined
//      创建对象时会(property)利用setter方法为属性赋值
//      JavaBean的属性名由getter/setter方法决定，set后小驼峰
    /**
     * 从容器中获得组件
     */
    @Test
    public void test() {
//        ApplicationContext代表ioc容器
//        ClassPathXmlApplicationContext：当前应用类路径下的XML配置文件
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        var person01 = (Person) ioc.getBean("person01");
        System.out.println(person01);

        var person03 = ioc.getBean("person03");
        System.out.println(person03);
    }
}

package mapperscan.service.proxy;

import mapperscan.service.Impl.Telephone2ProductImpl;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class BeanNameAutoProxyCreatorClass {
    @Bean
    BeanNameAutoProxyCreator getBeanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("Telephone2ProductImpl");
        beanNameAutoProxyCreator.setInterceptorNames("MyAdvice");
        return beanNameAutoProxyCreator;
    }


//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new
//                AnnotationConfigApplicationContext(BeanNameAutoProxyCreatorClass.class);
////        Telephone2ProductImpl telephone2Product = annotationConfigApplicationContext.getBean("Telephone2ProductImpl", Telephone2ProductImpl.class);
////        telephone2Product.downProduct();
//    }
}

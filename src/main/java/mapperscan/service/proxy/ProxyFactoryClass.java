package mapperscan.service.proxy;

import mapperscan.service.Impl.Telephone2ProductImpl;
import mapperscan.service.Product2Service;
import org.springframework.aop.framework.ProxyFactory;

public class ProxyFactoryClass {
    public static void main(String[] args) {
        Telephone2ProductImpl  telephone2Product = new Telephone2ProductImpl();
        ProxyFactory  proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(telephone2Product);
        proxyFactory.setTargetClass(Telephone2ProductImpl.class);
        proxyFactory.addInterface(Product2Service.class);
        Product2Service proxy = (Product2Service) proxyFactory.getProxy();
        proxy.downProduct();
    }



}

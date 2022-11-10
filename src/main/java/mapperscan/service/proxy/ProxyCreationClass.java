package mapperscan.service.proxy;

import mapperscan.service.Impl.WatchProductImpl;
import mapperscan.service.ProductsService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class ProxyCreationClass implements InvocationHandler {

    private WatchProductImpl target = new WatchProductImpl();

    public ProxyCreationClass() {

    }

    public ProxyCreationClass(WatchProductImpl target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("createProduct")) {
            System.out.println("进入代理类");
            method.invoke(target, args);
            System.out.println("代理类执行结束");
        }
        System.out.println(proxy.getClass().getInterfaces());
        return proxy;
    }

    public ProductsService createProxy() {
        return (ProductsService) Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        ProxyCreationClass proxyCreationClass = new ProxyCreationClass();
        ProductsService watchProduct = proxyCreationClass.createProxy();
        watchProduct.createProduct();
        watchProduct.createProduct1();
        WatchProductImpl watchProduct1 = proxyCreationClass.create(proxyCreationClass.target);
        watchProduct1.createProduct();
        watchProduct1.createProduct1();
    }

    public WatchProductImpl create(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());//设置父类
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("进入CGLIB代理类");
                method.invoke(target, args);
                System.out.println("代理类CGLIB执行结束");
                System.out.println("进入CGLIB代理类");
                proxy.invokeSuper(obj, args);
                System.out.println("代理类CGLIB执行结束");
                return null;
            }
        });
        return (WatchProductImpl) enhancer.create();
    }

}

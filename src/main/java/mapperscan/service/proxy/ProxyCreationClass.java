package mapperscan.service.proxy;

import mapperscan.service.Impl.WatchProductImpl;
import mapperscan.service.ProductsService;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class ProxyCreationClass implements InvocationHandler {

    private WatchProductImpl target;

    public ProxyCreationClass(WatchProductImpl target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("createProduct")){
            System.out.println("进入代理类");
            method.invoke(target,args);
            System.out.println("代理类执行结束");
        }
        return null;
    }

    public ProductsService createProxy() {
        return (ProductsService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

    }

}

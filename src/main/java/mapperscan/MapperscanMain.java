package mapperscan;

import mapperscan.annotation.MyScanAnnotation;
import mapperscan.annotation.MyTestAnntation;
import mapperscan.service.FactoryService;
import mapperscan.service.Impl.WatchFactoryImpl;
import mapperscan.service.Impl.WatchProductImpl;
import mapperscan.service.Product2Service;
import mapperscan.service.ProductsService;
import mapperscan.service.proxy.ProxyCreationClass;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImplFactory;
import java.nio.channels.ServerSocketChannel;

@SpringBootApplication
@MapperScan(basePackages = {"mapperscan.dao"})
@MyScanAnnotation(basePackages = {"mapperscan.service"},
        annotationClass = MyTestAnntation.class)
public class MapperscanMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MapperscanMain.class, args);
        FactoryService factoryService = new WatchFactoryImpl();
        ProductsService productsService = factoryService.createProduct();
        Product2Service product2Service = factoryService.createProduct2();
        product2Service.downProduct();
        productsService.createProduct();
        WatchProductImpl watchProduct = new WatchProductImpl();
        ProxyCreationClass proxyCreationClass = new ProxyCreationClass(watchProduct);
        proxyCreationClass.createProxy().createProduct();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();

        ServerSocket serverSocket = new ServerSocket();
        ServerSocketChannel.open();
        synchronized (MapperscanMain.class){

        }
//        Socket socket = serverSocket.accept();
//        while (true){
//            if ()
//        }

//        ProxyFactory  proxyFactory = new ProxyFactory();
//        proxyFactory.getProxy();
    }

    //    //读取资源
//    Resource resource = new ClassPathResource("spring-bean.xml");
//    //初始化容器
//    XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);


}

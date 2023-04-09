package mapperscan.service.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring3BugDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext ();
        //注册到容器中
        applicationContext.register (BugInvoker.class);

        applicationContext.addApplicationListener (new ApplicationListener() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println ("测试"+event);
            }
        });

        applicationContext.refresh ();
        applicationContext.close ();
    }
}

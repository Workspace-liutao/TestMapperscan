package mapperscan.controller;

import mapperscan.dao.TestUser;
import mapperscan.service.BaseService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.applet.AppletContext;
import java.security.cert.X509Certificate;

@RequestMapping("/index")
@Controller
public class TestController {
    @Autowired
    ApplicationContext applicationContext;

    @ResponseBody
    @RequestMapping("/testAnn")

    public void testAnnotation() {

        try {
            BaseService s1 = (BaseService) applicationContext.getBean("baseITestI");
            s1.getInfo();
        } catch (Exception ex) {
            System.out.println("1.There is something error:" + ex.getMessage());
        }

        try {
            BaseService s2 = (BaseService) applicationContext.getBean("baseITestII");
            s2.getInfo();
        } catch (Exception ex) {
            System.out.println("2.There is something error :" + ex.getMessage());
        }

        try {
            BaseService s3 = (BaseService) applicationContext.getBean("baseITestIII");
            s3.getInfo();
        } catch (Exception ex) {
            System.out.println("3.There is something error:" + ex.getMessage());
        }

        try {
            BaseService s4 = (BaseService) applicationContext.getBean("baseIITestI");
            s4.getInfo();
        } catch (Exception ex) {
            System.out.println("4.There is something error:" + ex.getMessage());
        }
    }

    @RequestMapping("/testUser")
    public void testUser() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(TestController.class);
        TestUser testUser1 = (TestUser) applicationContext.getBean("testUser1");
        System.out.println("TestUser1={}" + testUser1);
        TestUser testUser2 = (TestUser) applicationContext.getBean("testUser2");
        System.out.println("TestUser2={}" + testUser2);
        TestUser testUser3= (TestUser) applicationContext.getBean("testUser3");
        XmlBeanFactory  xmlBeanFactory = new XmlBeanFactory(new ClassPathResource(""));
        ApplicationContext  applicationContext = new ClassPathXmlApplicationContext("");
    }

}

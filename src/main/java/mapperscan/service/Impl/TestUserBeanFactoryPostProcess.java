package mapperscan.service.Impl;

import mapperscan.dao.TestUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class TestUserBeanFactoryPostProcess implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(TestUser.class);
        genericBeanDefinition.getPropertyValues().addPropertyValue("userName", "userName2");
        genericBeanDefinition.getPropertyValues().addPropertyValue("phone", "222222222");
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableListableBeanFactory;
        defaultListableBeanFactory.registerBeanDefinition("testUser1", genericBeanDefinition);
    }
}

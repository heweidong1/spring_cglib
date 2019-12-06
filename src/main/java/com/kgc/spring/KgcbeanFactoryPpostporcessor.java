package com.kgc.spring;

import com.kgc.dao.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * bean 的后置处理器  从map 中 拿到   userdao的BeanDefinition 从而改变类的实例
 *
 */
@Component
public class KgcbeanFactoryPpostporcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //获取 orderdao的 beanDefinition
       //GenericBeanDefinition orderDao  = (GenericBeanDefinition) beanFactory.getBeanDefinition("orderDao");
       //改变该类的实例
       //orderDao.setBeanClass(UserDao.class);

        //拿出配置文件 appfig
        GenericBeanDefinition appfig = (GenericBeanDefinition)beanFactory.getBeanDefinition("appfig");
        String[] attrs = appfig.attributeNames();
        for (String attr : attrs) {
            System.out.println("key----->"+attr);
            System.out.println("value---->"+appfig.getAttribute(attr));

        }



    }
}

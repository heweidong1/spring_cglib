package com.kgc.app;

import com.kgc.dao.OrderDao;
import com.kgc.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

//加上configuration之后  该类会被spring动态代理
//确保该类中的bean  是单例的

/**
 * 当加上configuration   会生成代理对象  那么该类定义的bean  就是单例的
 * 当没有加configuraion  那么就是原生的类 会按照自己写逻辑进行 创造bean
 */
@Configuration
@ComponentScan("com.kgc")
public class Appfig {
      @Bean
      public OrderDao orderDao()
      {

          new UserDao();
          return new OrderDao();
      }

      @Bean
      public UserDao userDao()
      {
          return new UserDao();
      }

}

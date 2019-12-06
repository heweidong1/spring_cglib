package com.kgc.test;
import com.kgc.dao.Proxyhandler;
import com.kgc.dao.UserDao;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;

public class KgcTest
{
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ac
//                         = new AnnotationConfigApplicationContext(Appfig.class);
        //Appfig 才是配置类  register注册
        //ac.register(Appfig.class);

       //System.out.print(ac.getBean(OrderDao.class).getClass().getSimpleName());
//        System.out.print(ac.getBean(UserDao.class));
//        System.out.print(ac.getBean(UserDao.class));
        //bean 是 cglib代理类
        //Appfig bean = ac.getBean(Appfig.class);

        //cglib 动态代理userDao
        //增强类
        Enhancer enhancer = new Enhancer();
        //增强父类 cglib是基于继承的 为 UserDao完成代理
        enhancer.setSuperclass(UserDao.class);

        //代理名字策略
        enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
        /**
         * public xxx entends xxxxx
         * {
         *     public xxx()
         *     {
         *         //自己的逻辑
         *         aaa.xxx()
         *         super.query()
         *     }
         *
         *
         * }
         */
        enhancer.setCallback( new Proxyhandler());
        UserDao o = (UserDao) enhancer.create();
        System.out.println(o.query2());


    }
}

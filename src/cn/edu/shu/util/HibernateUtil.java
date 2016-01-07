package cn.edu.shu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by jxxiangwen on 16-1-7.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    /**
     * 静态初始化静态属性，初始化SessionFactory
     */
    static {
        //4.3以后
        //创建配置对象
        Configuration config = new Configuration().configure();
        //创建服务注册对象
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        StandardServiceRegistry registry = builder.build();
        //创建会话工厂
        sessionFactory = config.buildSessionFactory(registry);
    }

    /**
     * 获取SessionFactory
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * 获取Session
     * @return Session
     */
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    /**
     * 关闭Session
     */
    public static void closeSession() {
        if (null != session){
            session.close();
        }
    }

}

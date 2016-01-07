package cn.edu.shu.entity.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by jxxiangwen on 16-1-7.
 * @version 0.1
 */
public class AnnotationSessionTest {

    @Test
    public void openSessionTest() {
        //创建配置对象
        Configuration config = new Configuration().configure();
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //创建会话工厂
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        //打开会话:openSession需要手动关闭，getCurrentSession不需要
        Session session = sessionFactory.openSession();
        if (null != session) {
            System.out.println("Session创建成功");
        } else {
            System.out.println("Session创建失败");
        }
    }

    @Test
    public void getCurrentSessionTest() {
        //创建配置对象
        Configuration config = new Configuration().configure();
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //创建会话工厂
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        //打开会话:openSession需要手动关闭，getCurrentSession不需要
        //需要在hibernate.cfg.xml中配置
        //<!--如果是本地事务（jdbc事务）-->
        // <property name="hibernate.current_session_context_class">thread</property>
        //<!--如果是全局事务（jta事务）-->
        //<!--<property name="hibernate.current_session_context_class">jta</property>-->
        Session session = sessionFactory.getCurrentSession();
        if (null != session) {
            System.out.println("Session创建成功");
        } else {
            System.out.println("Session创建失败");
        }
    }

    /**
     * 测试getCurrentSession每次连接对象不同，session如果没有手动关闭，多次之后会导致连接池溢出
     */
    @Test
    public void testSaveStudentWithOpenSession() {
        //创建配置对象
        Configuration config = new Configuration().configure();
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //创建会话工厂
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        //打开会话:openSession需要手动关闭，getCurrentSession不需要
        Session session1 = sessionFactory.openSession();
        //打开事务
        Transaction transaction = session1.beginTransaction();
        AnnotationStudent annotationStudent = new AnnotationStudent(1, "邹祥文", "男", new Date(), new AnnotationAddress("333300","13120733363","江西省乐平市"));
        session1.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("connection HashCode:" + connection.hashCode());
            }
        });
        session1.save(annotationStudent);
        //提交事务
        transaction.commit();

        Session session2 = sessionFactory.openSession();
        transaction = session2.beginTransaction();
        annotationStudent = new AnnotationStudent(2, "韩露", "女", new Date(), new AnnotationAddress("333300","13120733363","江西省乐平市"));
        session2.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("connection HashCode:" + connection.hashCode());
            }
        });
        session2.save(annotationStudent);
        //提交事务
        transaction.commit();
        //关闭会话工厂
        sessionFactory.close();
    }

    /**
     * 测试getCurrentSession每次连接对象相同
     */
    @Test
    public void testSaveStudentWithGetCurrentSession() {
        //创建配置对象
        Configuration config = new Configuration().configure();
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //创建会话工厂
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        //打开会话:openSession需要手动关闭，getCurrentSession不需要
        Session session1 = sessionFactory.getCurrentSession();
        //打开事务
        Transaction transaction = session1.beginTransaction();
        AnnotationStudent annotationStudent = new AnnotationStudent(1, "邹祥文", "男", new Date(), new AnnotationAddress("333300","13120733363","江西省乐平市"));
        session1.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("connection HashCode:" + connection.hashCode());
            }
        });
        session1.save(annotationStudent);
        //提交事务
        transaction.commit();

        Session session2 = sessionFactory.getCurrentSession();
        transaction = session2.beginTransaction();
        annotationStudent = new AnnotationStudent(2, "韩露", "女", new Date(), new AnnotationAddress("333300","13120733363","江西省乐平市"));
        session2.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("connection HashCode:" + connection.hashCode());
            }
        });
        session2.save(annotationStudent);
        //提交事务
        transaction.commit();
        //关闭会话工厂
        sessionFactory.close();
    }
}
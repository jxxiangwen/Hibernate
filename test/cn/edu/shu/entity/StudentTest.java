package cn.edu.shu.entity;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by jxxiangwen on 16-1-7.
 * @version 0.1
 */
public class StudentTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    /**
     * 创建session并且打开事务
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
//        4.3以前
        //创建配置对象
        Configuration config = new Configuration().configure();
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //创建会话工厂
        sessionFactory = config.buildSessionFactory(serviceRegistry);
        //打开会话:openSession需要手动关闭，getCurrentSession不需要
        session = sessionFactory.openSession();
        //打开事务
        transaction = session.beginTransaction();
    }

    /**
     * 提交事务并且关闭session
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        //提交事务
        transaction.commit();
        //关闭会话
        session.close();
        //关闭会话工厂
        sessionFactory.close();
    }

    /**
     * 对象保存
     */
    @Test
    public void saveStudentTest() {
        Student student = new Student(1, "邹祥文", "男", new Date(), new Address("333300", "13120733363", "江西省乐平市"));
        //不开启事务需要调用doWork,设置connection.setAutoCommit(true);并且调用session.flush();
//        session.doWork(
//                new Work() {
//                    @Override
//                    public void execute(Connection connection) throws SQLException {
//                        connection.setAutoCommit(true);
//                    }
//                }
//        );
        session.save(student);
        //session.flush();
    }

    /**
     * Blob对象保存
     */
    @Test
    public void writeBlobTest() {
        Student student = new Student(1, "邹祥文", "男", new Date(), new Address("333300", "13120733363", "江西省乐平市"));
        String bashDir = System.getProperty("user.dir");
        String picturePath = bashDir + File.separator + "resource" + File.separator + "Screenshot1.png";
        System.out.println(bashDir);//user.dir指定了当前的路径
        File f = new File(picturePath);
        InputStream inputStream = null;
        Blob image = null;
        try {
            inputStream = new FileInputStream(f);
            image = Hibernate.getLobCreator(session).createBlob(inputStream, inputStream.available());
        } catch (Exception e) {
            e.printStackTrace();
        }
        student.setPicture(image);
        session.save(student);
    }

    /**
     * 对象查询
     */
    @Test
    public void getStudentTest() {
        Student student = (Student) session.get(Student.class, 1);
        System.out.println(student);
        System.out.println(student.getClass().getName());
    }

    /**
     * 对象查询
     */
    @Test
    public void loadStudentTest() {
        int studentId = 3;
        Student student = (Student) session.load(Student.class, studentId);
        ;
        try {
            System.out.println(student.getClass().getName());
            System.out.println(student);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
            System.out.println("编号为" + studentId + "的学生不存在");
        }
    }


    /**
     * 对象更新
     */
    @Test
    public void updateStudentTest() {
        Student student = (Student) session.get(Student.class, 1);
        student.setAddress(new Address("333300", "13120733363", "上海市"));
        session.update(student);
    }

    /**
     * 对象删除
     */
    @Test
    public void deleteStudentTest() {
        Student student = (Student) session.get(Student.class, 1);
        session.delete(student);
    }
}
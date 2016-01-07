package cn.edu.shu.entity;

import cn.edu.shu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Date;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by jxxiangwen on 16-1-7.
 *
 * @version 0.1
 */
public class GradeTest {

    /**
     * 一对多测试
     * 对象保存
     */
    @Test
    public void saveGradeTestOneToManyTest() {
        Grade grade = new Grade(1,"Java一班","Java软件开发一班");
        Student student1 = new Student(1, "邹祥文", "男", new Date(), new Address("333300", "13120733363", "江西省乐平市"));
        Student student2 = new Student(1, "韩露", "女", new Date(), new Address("333300", "13120733362", "江西省乐平市"));
        grade.getStudents().add(student1);
        grade.getStudents().add(student2);

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(grade);
        session.save(student1);
        session.save(student2);
        transaction.commit();
        HibernateUtil.closeSession();
    }

    /**
     * 一对多测试
     * 对象保存
     */
    @Test
    public void saveGradeTestManyToOneTest() {
        Grade grade = new Grade(1,"Java二班","Java软件开发二班");
        Student student1 = new Student(1, "邹祥文", "男", new Date(), new Address("333300", "13120733363", "江西省乐平市"));
        Student student2 = new Student(1, "韩露", "女", new Date(), new Address("333300", "13120733362", "江西省乐平市"));
        student1.setGrade(grade);
        student2.setGrade(grade);

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(grade);
        session.save(student1);
        session.save(student2);
        transaction.commit();
        HibernateUtil.closeSession();
    }

    /**
     * 一对多测试
     * 通过班级查询学生
     */
    @Test
    public void getStudentByGradeManyToOneTest(){
        //得到session
        Session session = HibernateUtil.getSession();
        //创建事务
        Transaction transaction = session.beginTransaction();
        Grade grade = (Grade) session.load(Grade.class,1);
        System.out.println(grade.getGradeName() + "," + grade.getGradeDesc());
        Iterator<Student> it = grade.getStudents().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //提交事务
        transaction.commit();
        //关闭session
        HibernateUtil.closeSession();
    }
}
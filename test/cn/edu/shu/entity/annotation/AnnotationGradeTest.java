package cn.edu.shu.entity.annotation;

import cn.edu.shu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Date;
import java.util.Iterator;

/**
 * Created by jxxiangwen on 16-1-7.
 *
 * @version 0.1
 */
public class AnnotationGradeTest {

    /**
     * 一对多测试
     * 对象保存
     */
    @Test
    public void saveGradeOneToManyTest() {
        AnnotationGrade annotationGrade = new AnnotationGrade("Java一班","Java软件开发一班");
        AnnotationStudent annotationStudent1 = new AnnotationStudent("邹祥文", "男", new Date(), new AnnotationAddress("333300", "13120733363", "江西省乐平市"));
        AnnotationStudent annotationStudent2 = new AnnotationStudent("韩露", "女", new Date(), new AnnotationAddress("333300", "13120733362", "江西省乐平市"));
        annotationGrade.getAnnotationStudent().add(annotationStudent1);
        annotationGrade.getAnnotationStudent().add(annotationStudent2);
        annotationStudent1.setAnnotationGrade(annotationGrade);
        annotationStudent2.setAnnotationGrade(annotationGrade);

        //得到session
        Session session = HibernateUtil.getSession();
        //创建事务
        Transaction transaction = session.beginTransaction();
        session.save(annotationStudent1);
        session.save(annotationStudent2);
        session.save(annotationGrade);

        //提交事务
        transaction.commit();
        //关闭session
        HibernateUtil.closeSession();
    }

    /**
     * 多对一测试
     * 对象保存
     */
    @Test
    public void saveGradeManyToOneTest() {
        AnnotationGrade annotationGrade = new AnnotationGrade("Java二班","Java软件开发二班");
        AnnotationStudent annotationStudent1 = new AnnotationStudent("邹祥文", "男", new Date(), new AnnotationAddress("333300", "13120733363", "江西省乐平市"));
        AnnotationStudent annotationStudent2 = new AnnotationStudent("韩露", "女", new Date(), new AnnotationAddress("333300", "13120733362", "江西省乐平市"));
        annotationGrade.getAnnotationStudent().add(annotationStudent1);
        annotationGrade.getAnnotationStudent().add(annotationStudent2);
        annotationStudent1.setAnnotationGrade(annotationGrade);
        annotationStudent2.setAnnotationGrade(annotationGrade);

        //得到session
        Session session = HibernateUtil.getSession();
        //创建事务
        Transaction transaction = session.beginTransaction();
        session.save(annotationGrade);
        session.save(annotationStudent1);
        session.save(annotationStudent2);
        //提交事务
        transaction.commit();
        //关闭session
        HibernateUtil.closeSession();
    }

    /**
     * 一对多测试
     * 通过班级查询学生
     */
    @Test
    public void getStudentByGradeOneToManyTest(){
        //得到session
        Session session = HibernateUtil.getSession();
        //创建事务
        Transaction transaction = session.beginTransaction();
        AnnotationGrade annotationGrade = (AnnotationGrade) session.load(AnnotationGrade.class,2);
        System.out.println(annotationGrade.getAnnotationGradeName() + "," + annotationGrade.getAnnotationGradeDesc());
        Iterator<AnnotationStudent> it = annotationGrade.getAnnotationStudent().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //提交事务
        transaction.commit();
        //关闭session
        HibernateUtil.closeSession();
    }
}
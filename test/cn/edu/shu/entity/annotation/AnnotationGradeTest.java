package cn.edu.shu.entity.annotation;

import cn.edu.shu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.Date;

/**
 * Created by jxxiangwen on 16-1-7.
 *
 * @version 0.1
 */
public class AnnotationGradeTest {

    /**
     * 对象保存
     */
    @Test
    public void saveGradeTest() {
        AnnotationGrade annotationGrade = new AnnotationGrade(1,"Java一班","Java软件开发一班");
        AnnotationStudent student1 = new AnnotationStudent(1, "邹祥文", "男", new Date(), new AnnotationAddress("333300", "13120733363", "江西省乐平市"));
        AnnotationStudent student2 = new AnnotationStudent(1, "韩露", "女", new Date(), new AnnotationAddress("333300", "13120733362", "江西省乐平市"));
        annotationGrade.getAnnotationStudents().add(student1);
        annotationGrade.getAnnotationStudents().add(student2);

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(annotationGrade);
        session.save(student1);
        session.save(student2);
        transaction.commit();
        HibernateUtil.closeSession();
    }
}
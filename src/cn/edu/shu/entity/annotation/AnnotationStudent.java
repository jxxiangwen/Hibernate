package cn.edu.shu.entity.annotation;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by jxxiangwen on 16-1-7.
 * @version 0.1
 */
@Entity
@Table(name = "a_student")
public class AnnotationStudent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private int studentId;//学生id
    @Basic
    @Column(name = "student_name", nullable = true, length = 20)
    private String studentName;//姓名
    @Basic
    @Column(name = "gender", length = 4)
    private String gender;//性别
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birthday", length = 20)
    private Date birthday;//出生日期
    @Embedded
    private AnnotationAddress annotationAddress;//地址
    @Lob
    @Column(name = "picture")
    private Blob picture;//头像

    public AnnotationStudent() {

    }

    public AnnotationStudent(int studentId, String studentName, String gender, Date birthday, AnnotationAddress annotationAddress) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.birthday = birthday;
        this.annotationAddress = annotationAddress;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public AnnotationAddress getAnnotationAddress() {
        return annotationAddress;
    }

    public void setAnnotationAddress(AnnotationAddress annotationAddress) {
        this.annotationAddress = annotationAddress;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "AnnotationStudent{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", annotationAddress=" + annotationAddress +
                ", picture=" + picture +
                '}';
    }
}

package cn.edu.shu.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by jxxiangwen on 16-1-7.
 * @version 0.1
 */
public class Student implements Serializable {
    private int studentId;//学生Id
    private String studentName;//新姓名
    private String gender;//性别
    private Date birthday;//出生日期
    private Address address;//地址
    private Blob picture;//头像

    //多对一使用
    private Grade grade;

    public Student() {

    }

    public Student(int studentId, String studentName, String gender, Date birthday, Address address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "AnnotationStudent{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address=" + address +
                ", picture=" + picture +
                '}';
    }
}

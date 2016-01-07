package cn.edu.shu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jxxiangwen on 16-1-7.
 */
public class Grade {
    private int gradeId;//年纪号
    private String gradeName;//班级名称
    private String gradeDesc;//班级描述信息

    //一对多使用
    private Set<Student> students = new HashSet<>();

    public Grade() {

    }

    public Grade(int gradeId, String gradeName, String gradeDesc) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.gradeDesc = gradeDesc;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGradeDesc() {
        return gradeDesc;
    }

    public void setGradeDesc(String gradeDesc) {
        this.gradeDesc = gradeDesc;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", gradeName='" + gradeName + '\'' +
                ", gradeDesc='" + gradeDesc + '\'' +
                '}';
    }
}

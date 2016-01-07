package cn.edu.shu.entity.annotation;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jxxiangwen on 16-1-7.
 */
@Entity
@Table(name = "a_grade")
public class AnnotationGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grade_id")
    private int gradeId;//年纪号
    @Column(name = "grade_name", nullable = true, length = 20)
    private String gradeName;//年纪名称
    @Column(name = "grade_desc")
    private String gradeDesc;//

    @OneToMany
    @JoinColumn(name="grade_id")
    private Set<AnnotationStudent> annotationStudents = new HashSet<>();

    public AnnotationGrade() {

    }

    public AnnotationGrade(int gradeId, String gradeName, String gradeDesc) {
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

    public Set<AnnotationStudent> getAnnotationStudents() {
        return annotationStudents;
    }

    public void setAnnotationStudents(Set<AnnotationStudent> annotationStudents) {
        this.annotationStudents = annotationStudents;
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

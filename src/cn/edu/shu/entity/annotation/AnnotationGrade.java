package cn.edu.shu.entity.annotation;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @Column(name = "annotation_grade_id")
    private int annotationGradeId;//年纪号
    @Basic
    @Column(name = "annotation_grade_name", nullable = false, length = 20)
    private String annotationGradeName;//年纪名称
    @Basic
    @Column(name = "annotation_grade_desc", nullable = true)
    private String annotationGradeDesc;//

    //由多方的annotationGrade来维护
    @OneToMany(mappedBy="annotationGrade",targetEntity = AnnotationStudent.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<AnnotationStudent> annotationStudent = new HashSet<>();//一对多使用

    public AnnotationGrade() {

    }

    public AnnotationGrade( String annotationGradeName, String annotationGradeDesc) {
        this.annotationGradeName = annotationGradeName;
        this.annotationGradeDesc = annotationGradeDesc;
    }

    public int getAnnotationGradeId() {
        return annotationGradeId;
    }

    public void setAnnotationGradeId(int annotationGradeId) {
        this.annotationGradeId = annotationGradeId;
    }

    public String getAnnotationGradeName() {
        return annotationGradeName;
    }

    public void setAnnotationGradeName(String annotationGradeName) {
        this.annotationGradeName = annotationGradeName;
    }

    public String getAnnotationGradeDesc() {
        return annotationGradeDesc;
    }

    public void setAnnotationGradeDesc(String annotationGradeDesc) {
        this.annotationGradeDesc = annotationGradeDesc;
    }

    public Set<AnnotationStudent> getAnnotationStudent() {
        return annotationStudent;
    }

    public void setAnnotationStudents(Set<AnnotationStudent> annotationStudent) {
        this.annotationStudent = annotationStudent;
    }


    @Override
    public String toString() {
        return "AnnotationGrade{" +
                "annotationGradeId=" + annotationGradeId +
                ", annotationGradeName='" + annotationGradeName + '\'' +
                ", annotationGradeDesc='" + annotationGradeDesc + '\'' +
                '}';
    }
}

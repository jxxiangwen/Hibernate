package cn.edu.shu.entity.annotation;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by jxxiangwen on 16-1-7.
 * @version 0.1
 */
@Embeddable
public class AnnotationAddress implements Serializable {
    @Column(name = "post_code")
    private String postCode;//邮政编码
    @Column(name = "phone")
    private String phone;//电话
    @Column(name = "annotation_address")
    private String annotationAddress;//地址

    public AnnotationAddress() {

    }

    public AnnotationAddress(String postCode, String phone, String annotationAddress) {
        this.postCode = postCode;
        this.phone = phone;
        this.annotationAddress = annotationAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAnnotationAddress() {
        return annotationAddress;
    }

    public void setAnnotationAddress(String annotationAddress) {
        this.annotationAddress = annotationAddress;
    }

    @Override
    public String toString() {
        return "AnnotationAddress{" +
                "postCode='" + postCode + '\'' +
                ", phone='" + phone + '\'' +
                ", annotationAddress='" + annotationAddress + '\'' +
                '}';
    }
}

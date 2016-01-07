package cn.edu.shu.entity;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by jxxiangwen on 16-1-7.
 * @version 0.1
 */
public class Address implements Serializable {
    private String postCode;//邮政编码
    private String phone;//电话
    private String address;//地址

    public Address() {

    }

    public Address(String postCode, String phone, String address) {
        this.postCode = postCode;
        this.phone = phone;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AnnotationAddress{" +
                "postCode='" + postCode + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

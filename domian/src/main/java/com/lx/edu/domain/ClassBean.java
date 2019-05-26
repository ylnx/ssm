package com.lx.edu.domain;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-02 20:16
 */
public class ClassBean {
    private Long cla_id;
    private String cla_name;
    private String cla_teacher;
    private String cla_teacher_phone;

    public Long getCla_id() {
        return cla_id;
    }

    public void setCla_id(Long cla_id) {
        this.cla_id = cla_id;
    }

    public String getCla_name() {
        return cla_name;
    }

    public void setCla_name(String cla_name) {
        this.cla_name = cla_name;
    }

    public String getCla_teacher() {
        return cla_teacher;
    }

    public void setCla_teacher(String cla_teacher) {
        this.cla_teacher = cla_teacher;
    }

    public String getCla_teacher_phone() {
        return cla_teacher_phone;
    }

    public void setCla_teacher_phone(String cla_teacher_phone) {
        this.cla_teacher_phone = cla_teacher_phone;
    }


    @Override
    public String toString() {
        return "ClassBean{" +
                "cla_id=" + cla_id +
                ", cla_name='" + cla_name + '\'' +
                ", cla_teacher='" + cla_teacher + '\'' +
                ", cla_teacher_phone='" + cla_teacher_phone + '\'' +
                '}';
    }
}

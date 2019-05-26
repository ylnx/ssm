package com.lx.edu.domain;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-02 20:15
 */
public class StudentBean {
    private Long stu_id;
    private String stu_name;
    private String stu_parent_name;
    private String stu_parent_relative;
    private String stu_parent_phone;
    private String stu_class_name;
    private Integer stu_lesson_period_total;
    private Integer stu_lesson_period_remainder;
    private Long stu_create_time;
    private Long stu_cla_id;
    private Long stu_pac_id;

    public Long getStu_id() {
        return stu_id;
    }

    public void setStu_id(Long stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_parent_name() {
        return stu_parent_name;
    }

    public void setStu_parent_name(String stu_parent_name) {
        this.stu_parent_name = stu_parent_name;
    }

    public String getStu_parent_relative() {
        return stu_parent_relative;
    }

    public void setStu_parent_relative(String stu_parent_relative) {
        this.stu_parent_relative = stu_parent_relative;
    }

    public String getStu_parent_phone() {
        return stu_parent_phone;
    }

    public void setStu_parent_phone(String stu_parent_phone) {
        this.stu_parent_phone = stu_parent_phone;
    }

    public String getStu_class_name() {
        return stu_class_name;
    }

    public void setStu_class_name(String stu_class_name) {
        this.stu_class_name = stu_class_name;
    }

    public Integer getStu_lesson_period_total() {
        if (stu_lesson_period_total == null){
            return 0;
        }
        return stu_lesson_period_total;
    }

    public void setStu_lesson_period_total(Integer stu_lesson_period_total) {
        this.stu_lesson_period_total = stu_lesson_period_total;
    }

    public Integer getStu_lesson_period_remainder() {
        if (stu_lesson_period_remainder == null){
            return 0;
        }
        return stu_lesson_period_remainder;
    }

    public void setStu_lesson_period_remainder(Integer stu_lesson_period_remainder) {
        this.stu_lesson_period_remainder = stu_lesson_period_remainder;
    }

    public Long getStu_cla_id() {
        return stu_cla_id;
    }

    public void setStu_cla_id(Long stu_cla_id) {
        this.stu_cla_id = stu_cla_id;
    }

    public Long getStu_pac_id() {
        return stu_pac_id;
    }

    public void setStu_pac_id(Long stu_pac_id) {
        this.stu_pac_id = stu_pac_id;
    }

    public Long getStu_create_time() {
        return stu_create_time;
    }

    public void setStu_create_time(Long stu_create_time) {
        this.stu_create_time = stu_create_time;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_parent_name='" + stu_parent_name + '\'' +
                ", stu_parent_relative='" + stu_parent_relative + '\'' +
                ", stu_parent_phone='" + stu_parent_phone + '\'' +
                ", stu_class_name='" + stu_class_name + '\'' +
                ", stu_lesson_period_total=" + stu_lesson_period_total +
                ", stu_lesson_period_remainder=" + stu_lesson_period_remainder +
                ", stu_create_time=" + stu_create_time +
                ", stu_cla_id=" + stu_cla_id +
                ", stu_pac_id=" + stu_pac_id +
                '}';
    }
}

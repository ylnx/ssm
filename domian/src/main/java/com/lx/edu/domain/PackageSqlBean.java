package com.lx.edu.domain;

import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-04 10:04
 */
public class PackageSqlBean {
    private Long pac_id;
    private Integer pac_duration;
    private String pac_content;
    private List<StudentBean> students;

    public Long getPac_id() {
        return pac_id;
    }

    public void setPac_id(Long pac_id) {
        this.pac_id = pac_id;
    }

    public Integer getPac_duration() {
        return pac_duration;
    }

    public void setPac_duration(Integer pac_duration) {
        this.pac_duration = pac_duration;
    }

    public String getPac_content() {
        return pac_content;
    }

    public void setPac_content(String pac_content) {
        this.pac_content = pac_content;
    }

    public List<StudentBean> getStudents() {
        return students;
    }

    public void setStudents(List<StudentBean> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "PackageSqlBean{" +
                "pac_id=" + pac_id +
                ", pac_duration=" + pac_duration +
                ", pac_content='" + pac_content + '\'' +
                ", students=" + students +
                '}';
    }
}

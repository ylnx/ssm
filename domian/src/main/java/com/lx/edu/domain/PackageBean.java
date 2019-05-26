package com.lx.edu.domain;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-02 20:16
 */
public class PackageBean {
    private Long pac_id;
    private Integer pac_duration;
    private String pac_content;

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

    @Override
    public String toString() {
        return "PackageBean{" +
                "pac_id=" + pac_id +
                ", pac_duration=" + pac_duration +
                ", pac_content='" + pac_content + '\'' +
                '}';
    }
}

package com.lx.edu.domain;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-15 10:48
 */
public class OptionBean {
    private Long id;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "OptionBean{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}

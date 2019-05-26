package com.lx.edu.domain;

import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-05 9:02
 */
public class ListJsonBean<T> {
    private Integer total;
    private List<T> list;

    public ListJsonBean() {
    }

    public ListJsonBean(Integer total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

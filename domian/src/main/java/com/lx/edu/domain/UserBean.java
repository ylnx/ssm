package com.lx.edu.domain;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-19 15:01
 */
public class UserBean {
    public Long u_id;
    public String u_name;
    public Long u_password;


    public Long getU_id() {
        return u_id;
    }

    public void setU_id(Long u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public Long getU_password() {
        return u_password;
    }

    public void setU_password(Long u_password) {
        this.u_password = u_password;
    }
}

package com.lx.edu.dao;

import com.lx.edu.domain.UserBean;

import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-19 15:06
 */
public interface UserDao {
    public List<UserBean> login(UserBean userBean);
}

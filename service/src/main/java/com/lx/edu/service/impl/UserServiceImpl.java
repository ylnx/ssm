package com.lx.edu.service.impl;

import com.lx.edu.dao.UserDao;
import com.lx.edu.domain.UserBean;
import com.lx.edu.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-19 15:07
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public boolean login(UserBean userBean) {
        List<UserBean> login = userDao.login(userBean);
        return login != null&&login.size()>0;
    }
}

package com.lx.edu.controller;

import com.lx.edu.domain.UserBean;
import com.lx.edu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-19 14:40
 */
@Controller
@RequestMapping("/user")
public class UserController implements IController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession session, UserBean userBean){
        System.out.println("login 执行了");
        boolean login = userService.login(userBean);
        if (login){
            session.setAttribute("user",userBean.u_name);
            return "redirect:/index.html";
        }else {
            return "redirect:/jsp/loginerror.jsp";
        }
    }
}

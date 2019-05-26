package com.lx.edu.controller;

import com.lx.edu.domain.ClassBean;
import com.lx.edu.domain.ClassSqlBean;
import com.lx.edu.domain.OptionBean;
import com.lx.edu.service.ClassService;
import com.lx.edu.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-03 14:40
 */
@Controller
@RequestMapping("/class")
public class ClassController implements IController{

    @Resource(name = "classService")
    private ClassService classService;

    @ResponseBody
    @RequestMapping("/save")
    public String save(ClassBean classBean){
        if (classBean.getCla_name() == null || classBean.getCla_name().equals("")){
            throw new RuntimeException("参数错误");
        }
        if (classBean.getCla_teacher() == null || classBean.getCla_teacher().equals("")){
            throw new RuntimeException("参数错误");
        }
        if (classBean.getCla_teacher_phone() == null || classBean.getCla_teacher_phone().equals("")){
            throw new RuntimeException("参数错误");
        }
        Long id = classService.save(classBean);
        return JsonUtil.toJson(id);
    }
    @ResponseBody
    @RequestMapping("/update")
    public String update(ClassBean classBean){
        if (classBean.getCla_name() == null || classBean.getCla_name().equals("")){
            throw new RuntimeException("参数错误");
        }
        if (classBean.getCla_teacher() == null || classBean.getCla_teacher().equals("")){
            throw new RuntimeException("参数错误");
        }
        if (classBean.getCla_teacher_phone() == null || classBean.getCla_teacher_phone().equals("")){
            throw new RuntimeException("参数错误");
        }
        Long id = classService.update(classBean);
        return JsonUtil.toJson(SUCCESS);
    }
    @ResponseBody
    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable("id") int id){
        ClassBean bean = classService.findById(id);
        return JsonUtil.toJsonPure(bean);
    }
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        classService.delete(id);
        return JsonUtil.toJson(SUCCESS);
    }


    @ResponseBody
    @RequestMapping("/list")
    public String list(Integer page,Integer rows){
        if (page == null && rows == null){
            return JsonUtil.toJsonPureList(classService.list());
        }else {
            return JsonUtil.toJsonList(classService.list(page-1,rows));
        }
//        List<ClassBean> list = classService.list(pageNo * pageSize, pageSize);
//        return JsonUtil.toJson(list);
    }

    @ResponseBody
    @RequestMapping("/findStudentsById/{id}")
    public String findStudentsById(@PathVariable("id")int id){
        ClassSqlBean bean = classService.findStudentsById(id);
        return JsonUtil.toJson(bean);
    }

    @ResponseBody
    @RequestMapping("/findClassforOption")
    public String findClassforOption(){
        List<OptionBean> classforOption = classService.findClassforOption();
        return JsonUtil.toJsonPureList(classforOption);
    }
}

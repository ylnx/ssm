package com.lx.edu.controller;

import com.lx.edu.domain.StudentBean;
import com.lx.edu.service.StudentService;
import com.lx.edu.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-03 20:48
 */
@Controller
@RequestMapping("/student")
public class StudentContoller implements IController {

    @Resource(name = "studentService")
    private StudentService studentService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(StudentBean studentBean){
        Long id = studentService.save(studentBean);
        return JsonUtil.toJson(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(StudentBean studentBean){
        System.out.println(studentBean);
        studentService.update(studentBean);
        return JsonUtil.toJson(SUCCESS);
    }

    @ResponseBody
    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable("id") int id){
       return JsonUtil.toJsonPure(studentService.findById(id));
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        studentService.delete(id);
        return JsonUtil.toJson(SUCCESS);
    }

    @ResponseBody
    @RequestMapping("/list")
    public String list(Integer page,Integer rows){
        if (page == null && rows == null){
            return JsonUtil.toJsonList(studentService.list());
        }else {
            return JsonUtil.toJsonList(studentService.list(page-1,rows));
        }
    }

    @ResponseBody
    @RequestMapping("/findPackageById/id")
    public String findPackageById(@PathVariable("id") Integer id){
        return JsonUtil.toJson(studentService.findPackageById(id));
    }

    @ResponseBody
    @RequestMapping(value = "/periodReduce",method = RequestMethod.POST)
    public String periodReduce(@RequestParam("ids[]") ArrayList<Integer> ids){
        System.out.println(ids);
        if (ids!=null&&ids.size()>0){
            studentService.updateToLessonDuration(ids);
        }
        return JsonUtil.toJson(SUCCESS);
    }

    @ResponseBody
    @RequestMapping(value = "/renew")
    public String renew(StudentBean studentBean){
        System.out.println(studentBean);
        studentService.renew(studentBean);
        return JsonUtil.toJson(SUCCESS);
    }

    @ResponseBody
    @RequestMapping(value = "/sms",method = RequestMethod.POST)
    public String sms(@RequestParam("ids[]") ArrayList<Integer> ids){
        System.out.println(ids);
        if (ids!=null&&ids.size()>0){
//            studentService.updateToLessonDuration(ids);
        }
        return JsonUtil.toJson(SUCCESS);
    }
}

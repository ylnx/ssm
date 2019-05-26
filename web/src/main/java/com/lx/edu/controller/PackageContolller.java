package com.lx.edu.controller;

import com.lx.edu.domain.OptionBean;
import com.lx.edu.domain.PackageBean;
import com.lx.edu.domain.PackageSqlBean;
import com.lx.edu.service.PackageService;
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
 * @create 2019-05-04 10:33
 */
@Controller
@RequestMapping("/package")
public class PackageContolller implements IController {

    @Resource(name = "packageService")
    private PackageService packageService;


    @ResponseBody
    @RequestMapping("/save")
    public String save(PackageBean packageBean){
        if (packageBean.getPac_content()==null||packageBean.getPac_content().equals("")){
            throw new RuntimeException("参数错误");
        }
        if (packageBean.getPac_duration()==null||packageBean.getPac_duration() == 0){
            throw new RuntimeException("参数错误");
        }
        Long id = packageService.save(packageBean);
        return JsonUtil.toJson(id);
    }

    @ResponseBody
    @RequestMapping("/update")
    public String update(PackageBean packageBean){
        if (packageBean.getPac_content()==null||packageBean.getPac_content().equals("")){
            throw new RuntimeException("参数错误");
        }
        if (packageBean.getPac_duration()==null||packageBean.getPac_duration() == 0){
            throw new RuntimeException("参数错误");
        }
        packageService.update(packageBean);
        return JsonUtil.toJson(SUCCESS);
    }

    @ResponseBody
    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable("id") int id){
        PackageBean bean = packageService.findById(id);
        return JsonUtil.toJsonPure(bean);
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        packageService.delete(id);
        return JsonUtil.toJson(SUCCESS);
    }


    @ResponseBody
    @RequestMapping("/list")
    public String list(Integer page,Integer rows){
        if (page == null && rows == null){
            return JsonUtil.toJson(packageService.list());
        }else {
            return JsonUtil.toJsonList(packageService.list(page-1, rows));
        }
//        List<PackageBean> list = packageService.list(pageNo * pageSize, pageSize);
//        return JsonUtil.toJson(list);
    }

    @ResponseBody
    @RequestMapping("/findStudentsById/{id}")
    public String findStudentsById(@PathVariable("id") int id){
        PackageSqlBean bean = packageService.findStudentsById(id);
        return JsonUtil.toJson(bean);
    }

    @ResponseBody
    @RequestMapping("/findPackageforOption")
    public String findClassforOption(){
        List<OptionBean> classforOption = packageService.findPackageforOption();
        return JsonUtil.toJsonPureList(classforOption);
    }
}

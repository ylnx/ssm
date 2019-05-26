package com.lx.edu.service.impl;

import com.lx.edu.dao.ClassDao;
import com.lx.edu.dao.PackageDao;
import com.lx.edu.dao.StudentDao;
import com.lx.edu.domain.*;
import com.lx.edu.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-03 20:45
 */

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Resource(name = "packageDao")
    private PackageDao packageDao;

    @Resource(name = "classDao")
    private ClassDao classDao;

    @Override
    public Long save(StudentBean studentBean) {
        if (studentBean.getStu_cla_id()== null||studentBean.getStu_cla_id()== 0){
            throw new RuntimeException("请选择班级");
        }
        ClassBean classBean = classDao.findById(studentBean.getStu_cla_id().intValue());
        studentBean.setStu_class_name(classBean.getCla_name());
        studentBean.setStu_create_time(System.currentTimeMillis());
        if (studentBean.getStu_lesson_period_total()!=0&&
                studentBean.getStu_lesson_period_remainder()!=0){
            studentDao.save(studentBean);
            studentDao.saveToClass(studentBean.getStu_id(),studentBean.getStu_cla_id());
            return studentBean.getStu_id();
        }

        if (studentBean.getStu_pac_id()== null||studentBean.getStu_pac_id()== 0){
            throw new RuntimeException("请选择套餐");
        }

        PackageBean packageBean = packageDao.findById(studentBean.getStu_pac_id().intValue());
        studentBean.setStu_lesson_period_total(packageBean.getPac_duration());
        studentBean.setStu_lesson_period_remainder(packageBean.getPac_duration());

        studentDao.save(studentBean);
        studentDao.saveToClass(studentBean.getStu_id(),studentBean.getStu_cla_id());
        studentDao.saveToPackage(studentBean.getStu_id(),studentBean.getStu_pac_id());
        return studentBean.getStu_id();
    }

    @Override
    public Long update(StudentBean studentBean) {
        //更新时，先查询id对应学生表中的stu_cla_id,stu_pac_id
        StudentBean bean = studentDao.findById(studentBean.getStu_id().intValue());
        if (bean.getStu_cla_id()!=null&&studentBean.getStu_cla_id() != null){
            if (bean.getStu_cla_id().longValue() != studentBean.getStu_cla_id().longValue()){
                //修改了班级，更新表stu_cla
                studentDao.updateToClass(studentBean.getStu_id(),studentBean.getStu_cla_id());
            }
        }
        if (bean.getStu_pac_id()!=null&&studentBean.getStu_pac_id() != null){
            if (bean.getStu_pac_id().longValue() != studentBean.getStu_pac_id().longValue()){
                //修改了套餐，更新表stu_pac
                studentDao.updateToPackage(studentBean.getStu_id(),bean.getStu_pac_id(),studentBean.getStu_cla_id());
            }
        }

        if ((bean.getStu_cla_id() == null||bean.getStu_cla_id().longValue()==0)
        &&(studentBean.getStu_cla_id()!=null&&studentBean.getStu_cla_id().longValue()!=0)){
            //数据库中没有stu_cla_id并且参数中有stu_cla_id 存入stu_cla
            studentDao.saveToClass(studentBean.getStu_id(),studentBean.getStu_cla_id());
        }
        if ((bean.getStu_pac_id() == null||bean.getStu_pac_id().longValue()==0)
                &&(studentBean.getStu_pac_id()!=null&&studentBean.getStu_pac_id().longValue()!=0)){
            //数据库中没有stu_pac_id并且参数中有stu_pac_id 存入stu_pac
            studentDao.saveToPackage(studentBean.getStu_id(),studentBean.getStu_pac_id());
        }
        if (studentBean.getStu_cla_id() != null||studentBean.getStu_cla_id().longValue()!=0){
            ClassBean classBean = classDao.findById(studentBean.getStu_cla_id().intValue());
            studentBean.setStu_class_name(classBean.getCla_name());
        }
        studentDao.update(studentBean);
        return studentBean.getStu_id();
    }

    @Override
    public StudentBean findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public void delete(int id) {
        StudentBean bean = studentDao.findById(id);
        bean.setStu_create_time(System.currentTimeMillis());
        studentDao.saveToDel(bean);
        studentDao.delete(id);
    }

    @Override
    public ListJsonBean list() {
        Integer count = studentDao.count();
        List<StudentBean> list = studentDao.list();
        ListJsonBean jsonBean = new ListJsonBean();
        jsonBean.setList(list);
        jsonBean.setTotal(count);
        return jsonBean;
    }

    @Override
    public ListJsonBean list(Integer pageNo, Integer pageSize) {
        Integer count = studentDao.count();
        List<StudentBean> list = studentDao.list(pageNo*pageSize,pageSize);
        return new ListJsonBean(count,list);
    }

    @Override
    public StudentSqlBean findPackageById(Integer id) {
        return studentDao.findPackageById(id);
    }

    @Override
    public void updateToLessonDuration(List<Integer> ids) {
        studentDao.updateToLessonDuration(ids);
    }

    @Override
    public void renew(StudentBean studentBean) {
        // 套餐续费
        // 修改总课时和剩余课时和套餐id
        // 学生套餐表存入一条新数据
        PackageBean packageBean = packageDao.findById(studentBean.getStu_pac_id().intValue());
        studentDao.updateToDurationRenew(studentBean.getStu_id(),studentBean.getStu_pac_id(),packageBean.getPac_duration());
        studentDao.saveToPackage(studentBean.getStu_id(),studentBean.getStu_pac_id());
    }
}

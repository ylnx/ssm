package com.lx.edu.service.impl;

import com.lx.edu.dao.ClassDao;
import com.lx.edu.dao.StudentDao;
import com.lx.edu.domain.ClassBean;
import com.lx.edu.domain.ClassSqlBean;
import com.lx.edu.domain.ListJsonBean;
import com.lx.edu.domain.OptionBean;
import com.lx.edu.service.ClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-03 10:39
 */
@Service(value = "classService")
@Transactional
public class ClassServiceImpl implements ClassService {

    @Resource(name = "classDao")
    private ClassDao classDao;

    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Override
    public Long save(ClassBean classBean) {
        classDao.save(classBean);
        return classBean.getCla_id();
    }

    @Override
    public Long update(ClassBean classBean) {
        ClassBean bean = classDao.findById(classBean.getCla_id().intValue());
        if (classBean.getCla_name()!=null&&!classBean.getCla_name().equals(bean.getCla_name())){
            //修改了班级名称，该班级所有学生班级名称需要修改
            studentDao.updateToClassName(classBean.getCla_id().intValue(),classBean.getCla_name());
        }
        classDao.update(classBean);
        return classBean.getCla_id();
    }

    @Override
    public ClassBean findById(int id) {
        return classDao.findById(id);
    }

    @Override
    public void delete(int id) {
        studentDao.deleteToClass(new Long(id));
        classDao.delete(id);
    }

    @Override
    public List<ClassBean> list() {
        return classDao.list();
    }

    @Override
    public ListJsonBean list(Integer pageNo, Integer pageSize) {
        Integer count = classDao.count();
        List<ClassBean> list = classDao.list(pageNo * pageSize, pageSize);
        return new ListJsonBean(count,list);
    }

    @Override
    public ClassSqlBean findStudentsById(int id) {
        return classDao.findStudentsById(id);
    }

    @Override
    public List<OptionBean> findClassforOption() {
        return classDao.findClassforOption();
    }
}

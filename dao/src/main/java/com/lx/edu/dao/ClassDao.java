package com.lx.edu.dao;

import com.lx.edu.domain.ClassBean;
import com.lx.edu.domain.ClassSqlBean;
import com.lx.edu.domain.OptionBean;

import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-02 20:18
 */
public interface ClassDao {
    public Integer save(ClassBean classBean);
    public Integer update(ClassBean classBean);
    public ClassBean findById(int id);
    public void delete(int id);
    public List<ClassBean> list();
    public List<ClassBean> list(Integer pageNo,Integer pageSize);
    public List<ClassSqlBean> findStudents();
    public ClassSqlBean findStudentsById(int id);
    public List<OptionBean> findClassforOption();
    public Integer count();

}

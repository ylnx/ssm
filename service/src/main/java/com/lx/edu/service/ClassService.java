package com.lx.edu.service;

import com.lx.edu.domain.ClassBean;
import com.lx.edu.domain.ClassSqlBean;
import com.lx.edu.domain.ListJsonBean;
import com.lx.edu.domain.OptionBean;

import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-03 10:36
 */
public interface ClassService {
    public Long save(ClassBean classBean);
    public Long update(ClassBean classBean);
    public ClassBean findById(int id);
    public void delete(int id);
    public List<ClassBean> list();
    public ListJsonBean list(Integer pageNo, Integer pageSize);
    public ClassSqlBean findStudentsById(int id);
    public List<OptionBean> findClassforOption();
}

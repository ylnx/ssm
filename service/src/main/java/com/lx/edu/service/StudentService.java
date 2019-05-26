package com.lx.edu.service;

import com.lx.edu.domain.ListJsonBean;
import com.lx.edu.domain.StudentBean;
import com.lx.edu.domain.StudentSqlBean;

import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-03 10:37
 */
public interface StudentService {
    public Long save(StudentBean studentBean);
    public Long  update(StudentBean classBean);
    public StudentBean findById(int id);
    public void delete(int id);
    public ListJsonBean list();
    public ListJsonBean list(Integer pageNo,Integer pageSize);
    public StudentSqlBean findPackageById(Integer id);
    public void updateToLessonDuration(List<Integer> ids);
    public void renew(StudentBean studentBean);

}

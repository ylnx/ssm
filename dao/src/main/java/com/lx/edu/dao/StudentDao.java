package com.lx.edu.dao;

import com.lx.edu.domain.StudentBean;
import com.lx.edu.domain.StudentSqlBean;

import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-02 20:18
 */
public interface StudentDao {
    public void save(StudentBean studentBean);
    public void saveToDel(StudentBean studentBean);
    public void update(StudentBean studentBean);
    public void updateToClassName(int cla_id,String cla_name);
    public void updateToDuration(int pac_id,int duration);
    public void updateToDurationRenew(Long stu_id,Long pac_id,int duration);
    public StudentBean findById(int id);
    public void delete(int id);
    public Integer count();
    public void saveToClass(Long stu_id,Long cla_id);
    public void updateToClass(Long stu_id,Long cla_id);
    public void deleteToClass(Long cla_id);
    public void saveToPackage(Long stu_id,Long pac_id);
    public void updateToPackage(Long stu_id,Long old_pac_id,Long pac_id);
    public void deleteToPackage(Long pac_id);
    public void updateToLessonDuration(List<Integer> ids);
    public List<StudentBean> list();
    public List<StudentBean> list(Integer pageNo,Integer pageSize);
    public List<StudentSqlBean> findClasses();
    public StudentSqlBean findClassesById(Integer id);
    public List<StudentSqlBean> findPackages();
    public StudentSqlBean findPackageById(Integer id);
    public List<StudentSqlBean> findClassesAndPackages();
    public List<StudentSqlBean> findClassesAndPackages(int id);
}

package com.lx.edu.dao;


import com.lx.edu.domain.OptionBean;
import com.lx.edu.domain.PackageBean;
import com.lx.edu.domain.PackageSqlBean;

import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-02 20:18
 */
public interface PackageDao {
    public Integer save(PackageBean packageBean);
    public Integer update(PackageBean classBean);
    public PackageBean findById(int id);
    public void delete(int id);
    public Integer count();
    public List<PackageBean> list();
    public List<PackageBean> list(Integer pageNo,Integer pageSize);
    public List<PackageSqlBean> findStudents();
    public PackageSqlBean findStudentsById(int id);
    public List<OptionBean> findPackageforOption();
}

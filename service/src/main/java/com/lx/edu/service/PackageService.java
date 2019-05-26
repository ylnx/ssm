package com.lx.edu.service;

import com.lx.edu.domain.ListJsonBean;
import com.lx.edu.domain.OptionBean;
import com.lx.edu.domain.PackageBean;
import com.lx.edu.domain.PackageSqlBean;

import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-03 10:37
 */
public interface PackageService {
    public Long save(PackageBean packageBean);
    public Long update(PackageBean packageBean);
    public PackageBean findById(int id);
    public void delete(int id);
    public List<PackageBean> list();
    public ListJsonBean list(Integer pageNo, Integer pageSize);
    public PackageSqlBean findStudentsById(int id);
    public List<OptionBean> findPackageforOption();

}

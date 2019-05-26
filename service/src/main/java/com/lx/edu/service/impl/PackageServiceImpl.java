package com.lx.edu.service.impl;

import com.lx.edu.dao.PackageDao;
import com.lx.edu.dao.StudentDao;
import com.lx.edu.domain.ListJsonBean;
import com.lx.edu.domain.OptionBean;
import com.lx.edu.domain.PackageBean;
import com.lx.edu.domain.PackageSqlBean;
import com.lx.edu.service.PackageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-03 20:46
 */
@Service("packageService")
@Transactional
public class PackageServiceImpl implements PackageService {

    @Resource(name = "packageDao")
    private PackageDao packageDao;
    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Override
    public Long save(PackageBean packageBean) {
        packageDao.save(packageBean);
        return packageBean.getPac_id();
    }

    @Override
    public Long update(PackageBean packageBean) {
        PackageBean bean = packageDao.findById(packageBean.getPac_id().intValue());
        if (packageBean.getPac_duration()!=null&&!(packageBean.getPac_duration() == bean.getPac_duration())){
            //修改了套餐时长，所有使用该套餐的学生时长都要修改
            int duration =packageBean.getPac_duration() - bean.getPac_duration();
            studentDao.updateToDuration(packageBean.getPac_id().intValue(),duration);
        }
        packageDao.update(packageBean);
        return packageBean.getPac_id();
    }

    @Override
    public PackageBean findById(int id) {
        return packageDao.findById(id);
    }

    @Override
    public void delete(int id) {
        studentDao.deleteToPackage(new Long(id));
        packageDao.delete(id);
    }

    @Override
    public List<PackageBean> list() {
        return packageDao.list();
    }

    @Override
    public ListJsonBean list(Integer pageNo, Integer pageSize) {
        Integer count = packageDao.count();
        List<PackageBean> list = packageDao.list(pageNo*pageSize, pageSize);
        return new ListJsonBean<>(count,list);
    }

    @Override
    public PackageSqlBean findStudentsById(int id) {
        return packageDao.findStudentsById(id);
    }

    @Override
    public List<OptionBean> findPackageforOption() {
        return packageDao.findPackageforOption();
    }
}

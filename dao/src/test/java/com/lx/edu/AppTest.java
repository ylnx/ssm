package com.lx.edu;

import com.lx.edu.dao.StudentDao;
import com.lx.edu.domain.StudentBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
//    /**
//     * Rigorous Test :-)
//     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
//
//    @Test
//    public void testSave() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//        ClassDao dao = session.getMapper(ClassDao.class);
//        ClassBean bean = new ClassBean();
//        bean.setCla_name("高龄班");
//        bean.setCla_teacher("小袁老师");
//        bean.setCla_teacher_phone("188888888");
//        dao.save(bean);
//        session.commit();
//        session.close();
//        inputStream.close();
//    }
//    @Test
//    public void testfindbyid() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//        ClassDao dao = session.getMapper(ClassDao.class);
//        System.out.println(dao.findById(11));
//        session.commit();
//        session.close();
//        inputStream.close();
//    }
//
//    @Test
//    public void testUpdate() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//        ClassDao dao = session.getMapper(ClassDao.class);
//        ClassBean bean = new ClassBean();
//        bean.setCla_name("高龄班2");
//        bean.setCla_teacher("小袁老师2");
//        bean.setCla_teacher_phone("188888888");
//        dao.update(bean);
//        session.commit();
//        session.close();
//        inputStream.close();
//    }
//    @Test
//    public void testdelete() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//        ClassDao dao = session.getMapper(ClassDao.class);
//        session.commit();
//        session.close();
//        inputStream.close();
//    }
//    @Test
//    public void testlist() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//        ClassDao dao = session.getMapper(ClassDao.class);
////        ClassBean bean = new ClassBean();
////        bean.setCla_id(10);
////        bean.setCla_name("高龄班2");
////        bean.setCla_teacher("小袁老师2");
////        bean.setCla_teacher_phone("188888888");
////        dao.update(bean);
//        List<ClassBean> list = dao.list();
//        for (ClassBean b :
//                list) {
//            System.out.println(b);
//        }
//        session.commit();
//        session.close();
//        inputStream.close();
//    }
//
//    @Test
//    public void testfindStudent() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//        ClassDao dao = session.getMapper(ClassDao.class);
//        for (ClassBean b :
//                list) {
//            System.out.println(b);
//        }
//        session.commit();
//        session.close();
//        inputStream.close();
//    }
//    @Test
//    public void testfindStudentFROMPACKAGE() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//        PackageDao dao = session.getMapper(PackageDao.class);
//        List<PackageBean> list = dao.findStudents();
//        for (PackageBean b :
//                list) {
//            System.out.println(b);
//        }
//        session.commit();
//        session.close();
//        inputStream.close();
//    }
//    @Test
//    public void testfindStudentById() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//        ClassDao dao = session.getMapper(ClassDao.class);
//        ClassBean studentsById = dao.findStudentsById(1);
//        System.out.println(studentsById);
//        session.commit();
//        session.close();
//        inputStream.close();
//    }
//
//    @Test
//    public void testfindStudentByIdformPackage() throws IOException {
//        PackageDao dao = session.getMapper(PackageDao.class);
//        PackageBean studentsById = dao.findStudentsById(1);
//        System.out.println(studentsById);
//    }
//
//    @Test
//    public void testfindclasses() throws IOException {
//        StudentDao dao = session.getMapper(StudentDao.class);
//        List<StudentBean> classes = dao.findClasses();
//        for (StudentBean b:
//             classes) {
//            System.out.println(b);
//        }
//    }
//
//    @Test
//    public void testfindclassee() throws IOException {
//        StudentDao dao = session.getMapper(StudentDao.class);
//        Integer count = dao.count();
//        System.out.println(count);
//    }
//
//    @Test
//    public void testfindpackageById() throws IOException {
//        StudentDao dao = session.getMapper(StudentDao.class);
//        StudentBean studentsById = dao.findPackageById(2);
//        System.out.println(studentsById);
//    }
//
//    @Test
//    public void testfindpackag() throws IOException {
//        StudentDao dao = session.getMapper(StudentDao.class);
//        List<StudentBean> studentsById = dao.findPackages();
//        for (StudentBean b:
//             studentsById) {
//            System.out.println(b);
//        }
//        System.out.println(studentsById);
//    }
//
//    @Test
//    public void testfindpackagandclass() throws IOException {
//        StudentDao dao = session.getMapper(StudentDao.class);
//        List<StudentBean> studentsById = dao.findClassesAndPackages();
//        for (StudentBean b:
//                studentsById) {
//            System.out.println(b);
//        }
//    }

    @Test
    public void saveStudent() throws IOException {
        StudentDao dao = session.getMapper(StudentDao.class);
        StudentBean bean= new StudentBean();
        bean.setStu_name("台历2");
        bean.setStu_parent_name("台历2他爸");
        bean.setStu_parent_relative("父亲");
        bean.setStu_parent_phone("18888888888");
//        dao.save(bean);
        Integer count = dao.count();
        System.out.println("//"+count);
    }

    private InputStream inputStream;
    private SqlSession session;
    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        session = sqlSessionFactory.openSession();
    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        inputStream.close();
    }
}

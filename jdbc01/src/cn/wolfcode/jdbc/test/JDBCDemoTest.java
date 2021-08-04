package cn.wolfcode.jdbc.test;

import cn.wolfcode.jdbc.dao.IStudentDAO;
import cn.wolfcode.jdbc.dao.impl.StudentDAOImpl;
import cn.wolfcode.jdbc.domain.Student;

public class JDBCDemoTest {
    public static void main(String[] args) {
        IStudentDAO studentDAO = new StudentDAOImpl();
        Student student01 = new Student();
        student01.setName("lisi");
        student01.setEmail("lisi@qq.com");
        student01.setAge(18);
//        studentDAO.insert(student01);
        Student student02 = new Student();
        student02.setId(2);
        student02.setName("wangwu");
//        studentDAO.update(student02);
//        studentDAO.delete(2);
        studentDAO.selectOne(1);
    }
}

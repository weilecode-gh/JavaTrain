package cn.wolfcode.jdbc.dao;

import cn.wolfcode.jdbc.domain.Student;

public interface IStudentDAO {
    void insert(Student student);
    void update(Student student);
    void delete(long StudentID);
    Student selectOne(long StudentID);
}

package cn.wolfcode.mybatis.mapper;

import cn.wolfcode.mybatis.domain.Student;
import cn.wolfcode.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {

    /**
     * add stu
     * @param student
     */
    void addStu(Student student);

    /**
     * select stu
     * @param id
     * @return
     */
    Student selectStu(Long id);

    /**
     * update stu info
     * @param student
     */
    void updateStu(Student student);

    /**
     * delete stu
     * @param ids
     */
    void deleteStu(@Param("ids")Long[] ids);
}

package cn.wolfcode.mybatis.mapper;

import cn.wolfcode.mybatis.domain.Employee;

import java.util.List;

public interface EmployeeMapper {

    /**
     *
     * @param employee
     */
    void save(Employee employee);
}

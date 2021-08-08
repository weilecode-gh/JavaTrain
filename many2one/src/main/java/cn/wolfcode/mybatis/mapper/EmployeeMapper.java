package cn.wolfcode.mybatis.mapper;

import cn.wolfcode.mybatis.domain.Employee;

import java.util.List;

public interface EmployeeMapper {
    /**
     * save employee
     * @param employee
     */
    void save(Employee employee);

    /**
     * select
     * @param id
     * @return
     */
    Employee get(Long id);

    /**
     * select all
     * @return
     */
    List<Employee> listAll();
}

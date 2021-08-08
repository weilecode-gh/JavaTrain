package cn.wolfcode.mybatis.mapper;

import cn.wolfcode.mybatis.domain.Department;

public interface DepartmentMapper {

    /**
     * save department
     * @param dept
     */
    void save(Department dept);

    /**
     * select dept
     * @param id
     * @return
     */
    Department get(Long id);
}

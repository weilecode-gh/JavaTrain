package cn.wolfcode.mybatis.mapper;

import cn.wolfcode.mybatis.domain.Department;

public interface DepartmentMapper {
    /**
     *
     * @param dept
     */
    void save(Department dept);

    /**
     *
     * @param id
     * @return
     */
    Department get(Long id);
}

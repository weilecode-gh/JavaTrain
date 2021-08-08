package cn.wolfcode.mybatis.mapper;

import cn.wolfcode.mybatis.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeMapper {
    /**
     * select salary Greater than or equal to
     * @param minSalary
     * @return
     */
    List<Employee> queryByMinSalary(@Param("minSalary")BigDecimal minSalary);

    /**
     * sealect in salary range
     * @param minSalary
     * @param MaxSalary
     * @return
     */
    List<Employee> queryByMinSalaryAndMaxSalary(@Param("minSalary")BigDecimal minSalary, @Param("maxSalary")BigDecimal MaxSalary);

    /**
     * update
     * @param employee
     */
    void update(Employee employee);

    /**
     * delete
     * @param ids
     */
    void batchDelete(@Param("ids")Long[] ids);
}

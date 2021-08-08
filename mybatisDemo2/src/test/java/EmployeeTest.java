import cn.wolfcode.mybatis.domain.Employee;
import cn.wolfcode.mybatis.mapper.EmployeeMapper;
import cn.wolfcode.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeTest {
    @Test
    public void testQueryByMinSalary(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.queryByMinSalary(new BigDecimal(1000));
        System.out.println(employeeList);
        sqlSession.close();
    }

    @Test
    public void testQueryByMinSalaryAndMaxSalary(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.queryByMinSalaryAndMaxSalary(new BigDecimal(1000), new BigDecimal(1300));
        System.out.println(employeeList);
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setSalary(new BigDecimal(10000));
        employee.setId(6L);
        employeeMapper.update(employee);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void batchDeleteTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        employeeMapper.batchDelete(new Long[] {1L, 2L});
        sqlSession.commit();
        sqlSession.close();
    }
}

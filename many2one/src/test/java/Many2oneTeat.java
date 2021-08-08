import cn.wolfcode.mybatis.domain.Department;
import cn.wolfcode.mybatis.domain.Employee;
import cn.wolfcode.mybatis.mapper.DepartmentMapper;
import cn.wolfcode.mybatis.mapper.EmployeeMapper;
import cn.wolfcode.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Many2oneTeat {


    //save department,one to many
    @Test
    public void saveTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department dept = new Department();
        dept.setName("后勤部");
        departmentMapper.save(dept);

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee1 = new Employee();
        employee1.setName("hanshiyi");
        employee1.setDept(dept);

        Employee employee2 = new Employee();
        employee2.setName("yangshier");
        employee2.setDept(dept);

        employeeMapper.save(employee1);
        employeeMapper.save(employee2);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.get(1L);

//        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
//        Department department = departmentMapper.get(employee.getDept().getId());
//        employee.setDept(department);

        sqlSession.commit();
        System.out.println(employee);
        sqlSession.close();
    }

    @Test
    public void listAllTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employeeList = employeeMapper.listAll();
        for (Employee list : employeeList ){
            System.out.println(list);
        }
        sqlSession.close();
    }

}

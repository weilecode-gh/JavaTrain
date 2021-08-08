import cn.wolfcode.mybatis.domain.Department;
import cn.wolfcode.mybatis.domain.Employee;
import cn.wolfcode.mybatis.mapper.DepartmentMapper;
import cn.wolfcode.mybatis.mapper.EmployeeMapper;
import cn.wolfcode.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class One2manyTest {
    @Test
    public void saveTest(){
        Department dept = new Department();
        dept.setName("开发部");

        Employee employee1 = new Employee();
        employee1.setName("zhaoyi");
        Employee employee2 = new Employee();
        employee2.setName("qianer");

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        departmentMapper.save(dept);

        employee1.setDeptId(dept.getId());
        employee2.setDeptId(dept.getId());

        employeeMapper.save(employee1);
        employeeMapper.save(employee2);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = departmentMapper.get(1L);
        System.out.println(department);
        sqlSession.close();
    }
}

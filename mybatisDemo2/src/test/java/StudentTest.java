import cn.wolfcode.mybatis.domain.Student;
import cn.wolfcode.mybatis.mapper.StudentMapper;
import cn.wolfcode.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentTest {
    @Test
    public void addStuTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("fengsan");
        student.setAge(18);
        student.setEmail("student@stu.com");
        studentMapper.addStu(student);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectStuTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Long id = 4L;
        studentMapper.selectStu(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateStuTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setEmail("@qq.com");
        student.setId(4L);
        studentMapper.updateStu(student);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteStuTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.deleteStu(new Long[] {4L, 5L});
        sqlSession.commit();
        sqlSession.close();
    }
}

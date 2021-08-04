package cn.wolfcode.jdbc.dao.impl;

import cn.wolfcode.jdbc.dao.IStudentDAO;
import cn.wolfcode.jdbc.domain.Student;
import cn.wolfcode.jdbc.util.DruidUtil;
import cn.wolfcode.jdbc.util.JDBCUtil;

import java.sql.*;

public class StudentDAOImpl implements IStudentDAO {
    @Override
    public void insert(Student student) {

        try{
            /*//1.加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.创建数据库连接
            String url = "jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT&&rewriteBatchedStatements=true";
            String username = "root";
            String password = "2333";
            Connection connection = DriverManager.getConnection(url, username, password);*/
            Connection connection = JDBCUtil.getConnection();
            //3.获取语句对象
            Statement statement = connection.createStatement();
            //4.执行sql语句
            String sql = "insert into student(name,email,age) values(" +
                    "'" + student.getName() + "','" + student.getEmail() + "'," + student.getAge() + ")";
            statement.executeUpdate(sql);
            //5.释放sql连接
            JDBCUtil.close(connection, statement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Student student) {
        try{
            /*//1.load DB driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.create db con
            String url = "jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT&&rewriteBatchedStatements=true";
            String username = "root";
            String password = "2333";
            Connection connection = DriverManager.getConnection(url, username, password);*/
            Connection connection = JDBCUtil.getConnection();
            //3.get statement obj
            String sql = "update student set name = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //set value of ? in sql
            preparedStatement.setString(1, student.getName());
            preparedStatement.setLong(2, student.getId());
            //4.execute sql
            preparedStatement.executeUpdate();
            //5.release resource
            preparedStatement.close();
            JDBCUtil.close(connection,preparedStatement,null);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(long StudentID) {
        try {
            /*//load DB driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create DB connection
            String url = "jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT&&rewriteBatchedStatements=true";
            String username = "root";
            String password = "2333";
            Connection connection = DriverManager.getConnection(url, username, password);*/
            Connection connection = JDBCUtil.getConnection();
            //get statement object
            String sql = "delete from student where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, StudentID);
            //execute sql
            preparedStatement.executeUpdate();
            //release resource
            preparedStatement.close();
            JDBCUtil.close(connection,preparedStatement,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student selectOne(long StudentID) {
        try {
            /*//load Db driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create DB connection
            String url = "jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT&&rewriteBatchedStatements=true";
            String username = "root";
            String password = "2333";
            Connection connection = DriverManager.getConnection(url, username, password);*/
            Connection connection = DruidUtil.getConnection();
            //get statement object
            String sql = "select * from student where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,StudentID);
            //execute sql
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = new Student();
            while (resultSet.next()){
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                int age = resultSet.getInt(4);
                student.setId(id);
                student.setName(name);
                student.setEmail(email);
                student.setAge(age);
                System.out.println(student);
            }
            //release resource
            JDBCUtil.close(connection,preparedStatement,resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

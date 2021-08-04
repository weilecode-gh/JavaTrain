import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JDBCTest test01 = new JDBCTest();
        test01.addStudent();
    }
    public static void addStudent() throws ClassNotFoundException, SQLException {
        //1.加载数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.创建数据库连接
        String url = "jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT&&rewriteBatchedStatements=true";
        String username = "root";
        String password = "2333";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.获取语句对象
        Statement statement = connection.createStatement();
        //4.执行sql语句
        String sql = "insert into student(name,email,age) values('zhangsan', 'zhangsan@qq.com',19)";
        statement.executeUpdate(sql);
        //5.释放sql连接
        statement.close();
        connection.close();
    }

}

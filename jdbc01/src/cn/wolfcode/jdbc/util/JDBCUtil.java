package cn.wolfcode.jdbc.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * util ,method should be defined as static type
 */

public class JDBCUtil {

    private static Properties properties = new Properties();

    static {
        //load Db driver
        try {
            InputStream in = new FileInputStream("E:/Java/JavaTrain/jdbc01/resources/db.properties");
            properties.load(in);
            String driverName = properties.getProperty("driverClassName");
//            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception{
        //create DB connection
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getProperty("driverClassName"));
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
//        dataSource.setInitialSize(5);
        Connection connection = dataSource.getConnection();
        /*String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, username, password);*/
        return connection;
    }

    /**
     *
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }else if (statement != null) {
                statement.close();
            }else if (connection != null) {
                connection.close();
            }
        }catch (Exception throwables) {
                throwables.printStackTrace();
            }

    }

}

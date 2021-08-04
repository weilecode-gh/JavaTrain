package cn.wolfcode.jdbc.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtil {
    public DruidUtil() {
    }

    private static DataSource dataSource = null;

    static {
        try{
            InputStream in = new FileInputStream("E:/Java/JavaTrain/jdbc01/resources/db.properties");
            Properties properties = new Properties();
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}

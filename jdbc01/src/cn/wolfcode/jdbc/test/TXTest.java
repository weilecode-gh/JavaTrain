package cn.wolfcode.jdbc.test;

import cn.wolfcode.jdbc.util.JDBCUtil;

import java.math.BigDecimal;
import java.sql.*;

public class TXTest {
    public static void main(String[] args) {
        transfer();
    }

    /**
     * transfer
     */
    public static void transfer(){
        //check account
        //
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);
            String sql = "select * from account where name = ? and balance > ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "zhangsan");
            preparedStatement.setBigDecimal(2, new BigDecimal(1000));
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                //-1000
                String multiSql = "update account set balance = balance - ? where name = ?";
                PreparedStatement mulPst = connection.prepareStatement(multiSql);
                mulPst.setBigDecimal(1, new BigDecimal(1000));
                mulPst.setString(2, "Zhangsan");
                mulPst.executeUpdate();

//                int a = 100/0;
                //+1000
                String addSql = "update account set balance = balance + ? where name = ?";
                PreparedStatement addPst = connection.prepareStatement(addSql);
                addPst.setBigDecimal(1, new BigDecimal(1000));
                addPst.setString(2, "lisi");
                addPst.executeUpdate();

                //commit transaction
                connection.commit();

                //release resource
                JDBCUtil.close(connection,preparedStatement,resultSet);

            }else{
                System.out.println("余额不足");
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}

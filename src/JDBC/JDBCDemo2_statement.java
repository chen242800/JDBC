package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo2_statement {
    public static void main(String[] args) throws Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver"); mysql 5+  can ignore
        //2. connect
//        String url = "jdbc:mysql://127.0.0.1:3306/company";
        String url = "jdbc:mysql://127.0.0.1:3306/company?useSSL=false";
        String username = "root";
        String password = "19930918chen";
        Connection conn = DriverManager.getConnection(url,username,password);

        //3. define sql
        String sql = "update employee set salary = 4000 where id = 1";
        String sql2 = "update employee set salary = 4000 where id = 2";

        //4.
        Statement statement = conn.createStatement();

        try {
            //A. start transaction
            conn.setAutoCommit(false);

            //5.execute statement
            int count = statement.executeUpdate(sql);//tuples be affected
            int count2 = statement.executeUpdate(sql2);//tuples be affected

            //6. show result
            if (count>0&&count2>0){
                System.out.println("update successfully");
            }else {
                System.out.println("update failed");

            }

            //B. commit
            conn.commit();
        } catch (Exception throwables) {
            //C. rollback
            conn.rollback();
            throwables.printStackTrace();
        }

        //7.
        statement.close();
        conn.close();
    }
}

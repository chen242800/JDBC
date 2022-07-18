package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo3_ResultSet {
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
        String sql = "select * from employee";

        //4.
        Statement stmt = conn.createStatement();

        //5.ResultSet执行
        ResultSet rs =stmt.executeQuery(sql);

        //6.遍历结果
        //光标向下移一行，判断是否有数据
        while (rs.next()){
            System.out.println("--------");
            //获取数据
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int salary = rs.getInt(3);
            System.out.println(id);
            System.out.println(name);
            System.out.println(salary);

        }

//        //6.遍历结果
//        //光标向下移一行，判断是否有数据
//        while (rs.next()){
//            System.out.println("--------");
//            //获取数据
//            int id = rs.getInt("id");
//            String name = rs.getString("e_name");
//            int salary = rs.getInt("salary");
//            System.out.println(id);
//            System.out.println(name);
//            System.out.println(salary);
//        }

        //7.
        rs.close();
        stmt.close();
        conn.close();
    }
}

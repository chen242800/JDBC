package JDBC;

import java.sql.*;

public class JDBCDemo6_PreparedStatement {
    public static void main(String[] args) throws Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver"); mysql 5+  can ignore
        //2. connect
//        String url = "jdbc:mysql://127.0.0.1:3306/company";
        String url = "jdbc:mysql://127.0.0.1:3306/company?useSSL=false";
        String username = "root";
        String password = "19930918chen";
        Connection conn = DriverManager.getConnection(url,username,password);


        //接收用户输入的用户名和密码
        String name = "zhangsan";
        String psw = "1231232";

        //3. define sql
        String sql = "select * from user where username = ? and password = ?";

        //4.
        PreparedStatement pstmt  = conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,psw);

        //5.ResultSet执行
        ResultSet rs =pstmt.executeQuery();



        //6.判断是否登录成功
        //光标向下移一行，判断是否有数据
        if (rs.next()){
            System.out.println("login successfully");
        }else {
            System.out.println("login failed ");
        }
        //7.
        rs.close();
        pstmt.close();
        conn.close();
    }
}

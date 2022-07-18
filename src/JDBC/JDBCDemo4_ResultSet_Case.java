package JDBC;

import POJO.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo4_ResultSet_Case {
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


        List<Employee> employeeList = new ArrayList<>();
        //6.遍历结果
        //光标向下移一行，判断是否有数据
        while (rs.next()){
            Employee e = new Employee();

            //获取数据
            e.setId(rs.getInt("id"));
            e.setName(rs.getString("e_name"));
            e.setSalay(rs.getInt("salary"));
            employeeList.add(e);
        }
        System.out.println(employeeList);
        //7.
        rs.close();
        stmt.close();
        conn.close();
    }
}

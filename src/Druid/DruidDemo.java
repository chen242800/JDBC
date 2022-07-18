package Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1. 导入jar包

        //2.定义配置文件

        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        //4. 获取链接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5. 获取对应的数据库连接connection
        Connection conn = dataSource.getConnection();

        System.out.println(conn);
    }


}

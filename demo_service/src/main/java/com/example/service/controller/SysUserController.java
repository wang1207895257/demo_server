package com.example.service.controller;

import com.example.model.po.SysUser;
import com.example.service.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@RequestMapping("userController")
@RestController
public class SysUserController {

    @Value("${test.value}")
    private String testValue;
    @Value("${mysql.host}")
    private String host;
    @Value("${mysql.port}")
    private String port;
    @Value("${mysql.dbName}")
    private String dbName;
    @Value("${mysql.username}")
    private String username;
    @Value("${mysql.password}")
    private String pwd;

    @Autowired
    private ISysUserService service;

    @GetMapping("testMysql")
    public void testMysql() {
        System.err.println(testValue);
        // 声明Connection对象
        Connection con;
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        // MySQL配置时的用户名
        String user = username;
        // MySQL配置时的密码
        String password = pwd;
        // 遍历查询结果集
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句
            String sql = "select * from sys_user";
            // 3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println("姓名" + "\t" + "职称");
            System.out.println("-----------------");
            while (rs.next()) {
                String id = rs.getString("id");
                String userName = rs.getString("user_name");
                String identityCode = rs.getString("identity_code");
                String identityCodeType = rs.getString("identity_code_type");
                // 输出结果
                System.out.println(id + "\t" + userName + "\t" + identityCode + "\t" + identityCodeType);
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("getUser")
    public List<SysUser> getUsers() {
        List<SysUser> users = service.getUsers();
        return users;
    }

    @GetMapping("saveUser")
    public void saveUser() {
        service.saveUser();
    }
}

package com.dfbz.dao;

import com.dfbz.entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class LoginDao {
    private static  String DRIVER = "";
    private static  String USER = "";
    private static  String NAME = "";
    private static  String PASSWORD = "";
    private static Connection conn = null;
    private static PreparedStatement sql = null;

    //配置内容
    static {
        Properties p=new Properties();
        try {
            p.load(LoginDao.class.getResourceAsStream("/com/dfbz/config.properties"));
            DRIVER=p.getProperty("DRIVER");
            USER = p.getProperty("USER");
            NAME=p.getProperty("NAME");
            PASSWORD=p.getProperty("PASSWORD");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //连接数据库
    public static void link() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(USER, NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    //通过账号查密码
    public static String select(String account) {
        link();
        String s3="";
        String select = "select * from user where account = ?";
        try {
            sql = conn.prepareCall(select);
            sql.setObject(1, account);
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                s3 = rs.getString("pw");
                return s3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            return s3;
        }
    }

    //查找有没有重复的账号
    public static String show(String account) {
        link();
        String s3="";
        String select = "select * from user where account = ?";
        try {
            sql = conn.prepareCall(select);
            sql.setObject(1, account);
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                s3 = rs.getString("account");
                return s3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            return s3;
        }
    }

    //修改密码
    public static void update(String account,String pw) {
        link();
        String update = "update user set pw=? where account=?";
        try {
            sql = conn.prepareCall(update);
            sql.setObject(1,pw);
            sql.setObject(2,account);
            sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sql.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //添加用户
    public static void add(User user) {
        link();
        String add = "insert into user (name ,account,pw,age,born,createtime) values(?,?,?,?,?,?)";
        try {
            Date date=new Date();
            sql = conn.prepareCall(add);
            sql.setObject(1,user.getName());
            sql.setObject(2,user.getAccount());
            sql.setObject(3,user.getPw());
            sql.setObject(4,user.getAge());
            sql.setObject(5,user.getBorn());
            sql.setObject(6,date);
            sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sql.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

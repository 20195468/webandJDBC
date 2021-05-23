package com.org.dao;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @program: webLearn
 * @description
 * @author: 李星泽
 * @create: 2021-05-22 15:04
 **/
public class BaseDao {

    // 静态块，在加载类的时候只进行一次
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String dbDriver = bundle.getString("dbDriver");
        dbUrl = bundle.getString("dbUrl");//根据实际情况变化
        dbUser = bundle.getString("dbUser");
        dbPass = bundle.getString("dbPass");
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection conn;
    // 常量的值表示不能改变地址值
    private static final String dbUrl;
    private static final String dbUser;
    private static final String dbPass;
    private PreparedStatement pm;
    private ResultSet rs;

    // 获取连接
    public void open() {
        try {
            this.conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // 关闭连接 要先判读是否为空
    public void close() {
        if (rs != null) {
            try {
                this.rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                // 使其值为空，让虚拟机删去垃圾内存
                this.rs = null;
            }
        }
        if (pm != null) {
            try {
                this.pm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                // 使其值为空，让虚拟机删去垃圾内存
                this.pm = null;
            }
        }
        if (conn != null) {
            try {
                this.conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                // 使其值为空，让虚拟机删去垃圾内存
                this.conn = null;
            }
        }
    }

    public void makeStatement(String sql, Object... param) {
        try {
            this.pm = this.conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                this.pm.setObject(i + 1, param[i]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int execDML(String sql, Object... param) {
        try {
            this.makeStatement(sql, param);
            return this.pm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return -1;
    }

    public ResultSet execDQL(String sql, Object... param) {
        try {
            this.makeStatement(sql, param);
            return this.pm.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

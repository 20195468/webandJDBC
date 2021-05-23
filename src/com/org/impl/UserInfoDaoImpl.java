package com.org.impl;

import com.org.dao.BaseDao;
import com.org.entity.UserInfo;
import com.org.services.UserinfoDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: webLearn
 * @description 数据的封装
 * @author: 李星泽
 * @create: 2021-05-22 16:37
 **/
public class UserInfoDaoImpl implements UserinfoDao {

    private final BaseDao baseDao = new BaseDao();

    public List<UserInfo> selectAll() {
        String sql = "select * from userinfo";
        List<UserInfo> list = new ArrayList<>();
        baseDao.open();
        ResultSet rs = baseDao.execDQL(sql);
        try {
            while (rs.next()) {
                list.add(new UserInfo(
                        rs.getInt("userid"),
                        rs.getString("usercode"),
                        "******",
                        rs.getString("nickname")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        baseDao.close();
        return list;
    }

    @Override
    public UserInfo selectByUsercodeAndUserpwd(UserInfo user) {
        String sql = "select * from userinfo where usercode=? and userpwd=?";
        UserInfo userinfo = null;
        baseDao.open();
        ResultSet rs  = baseDao.execDQL(sql,user.getUsercode(),user.getUserpwd());

        try {
            if(rs.next())
            {
                userinfo = new UserInfo(rs.getInt("userid"),
                        user.getUsercode(),
                        user.getUserpwd(),
                        rs.getString("nickname"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        baseDao.close();

        return userinfo;
    }
}

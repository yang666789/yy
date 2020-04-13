package com.yy.Dao.impl;

import com.yy.DBUtils.DBUtils;
import com.yy.Dao.IUserDao;
import com.yy.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public List<User> getUsers() {
        List<User> list=new ArrayList<>();
        String sql="select*from users_tb";
        try {
            PreparedStatement pst= DBUtils.getConnection().prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User getUser(String uname) {
        String sql="select*from users_tb where username=?";
        User user=null;
        try {
            PreparedStatement pst= DBUtils.getConnection().prepareStatement(sql);
            pst.setString(1,uname);
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}

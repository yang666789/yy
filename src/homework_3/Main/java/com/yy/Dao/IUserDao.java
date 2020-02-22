package com.yy.Dao;

import com.yy.entity.User;

import java.util.List;

public interface IUserDao {

    List<User> getUsers();

    User getUser(String uname);
}

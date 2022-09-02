package com.neu.user.biz;

import com.neu.user.entity.User;

import java.util.List;

public interface UserBiz {
    public User login(String uname, String upwd);
    public List<User> findUser(int index, int size);
    public List<User> findUserMo(int index, int size,String uname);
    public boolean delUser(int id);
    public boolean addUser(User user);
    public User findById(int id);
    public boolean updateUser(User user);
}

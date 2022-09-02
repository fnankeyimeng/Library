package com.neu.user.biz.impl;

import com.neu.user.biz.UserBiz;
import com.neu.user.entity.User;
import com.neu.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("userBiz")
public class UserBizImpl implements UserBiz {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String uname, String upwd) {
        User user=userMapper.login(uname,upwd);
        return user;
    }

    @Override
    public List<User> findUser(int index, int size) {
        //创建map将参数存入map集合中
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("index",index);
        map.put("size", size);
        List<User> list= userMapper.findUser(map);
        return list;
    }

    @Override
    public List<User> findUserMo(int index, int size, String uname) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("index",index);
        map.put("size", size);
        map.put("uname", uname);
        List<User> list=userMapper.findUserMo(map);
        return list;
    }

    @Override
    public boolean delUser(int id) {
        return userMapper.delUser(id);
    }

    @Override
    public boolean addUser(User user) {

        return userMapper.addUser(user);
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
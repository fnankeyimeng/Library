package com.neu.user.mapper;

import com.neu.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    public User login(@Param("uname") String uname, @Param("upwd") String upwd);
    public List<User> findUser(Map<String,Object> map);
    public List<User> findUserMo(Map<String,Object> map);
    public boolean delUser(int id);
    public boolean addUser(User user);
    public User findById(int id);
    public boolean updateUser(User user);
}

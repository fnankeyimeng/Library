package com.neu.user.controller;

import com.neu.user.biz.UserBiz;
import com.neu.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600) //解决跨域问题
public class UserController {
    @Autowired
    private UserBiz userBiz;

    @RequestMapping(value="/login")
    @ResponseBody
    public User login(String uname, String upwd, HttpSession session) {
        User user = userBiz.login(uname, upwd);
        if(user!=null){
            String username=user.getUname();
            session.setAttribute("username",username);
            //获取用户Id
            int uid =user.getId();
            session.setAttribute("uid",uid);
        }
        return user;
    }

    @RequestMapping(value="/findUser")
    @ResponseBody
    public Map<String,Object> findUser(Integer index){
        if(index==null){
            index=1;
        }
        int size=4;
        //调用业务层的方法
        List<User> list=userBiz.findUser(index,size);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("list",list);
        map.put("index",index);
        return map;

    }
    @RequestMapping(value="/findUserMo")
    @ResponseBody
    public Map<String,Object> findUserMo(Integer index,String uname){
        if(index==null){
            index=1;
        }
        int size=4;
        //调用业务层的方法
        List<User> list=userBiz.findUserMo(index,size,uname);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("list",list);
        map.put("index",index);
        map.put("uname",uname);
        return map;

    }
    @RequestMapping(value="/delUser")
    @ResponseBody
    public Boolean delUser( int id){
        Boolean bo =userBiz.delUser(id);
        return bo;
    }
    @RequestMapping(value="/addUser")
    @ResponseBody
    public Boolean addUser(int id,String uname,String upwd,int type){
        User user =new User(id,uname,upwd,type);
        Boolean bo=userBiz.addUser(user);
        return bo;
    }
    @RequestMapping(value="/findById")
    @ResponseBody
    public User findById(int id){
        User user=userBiz.findById(id);
        return user;

    }
    @RequestMapping(value="/updateUser")
    @ResponseBody
    public Boolean updateUser(int id,String uname,String upwd,int type){
        User user=new User(id,uname,upwd,type);
        Boolean bo=userBiz.updateUser(user);
        return bo;
    }
}

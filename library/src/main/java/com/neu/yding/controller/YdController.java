package com.neu.yding.controller;

import com.neu.book.biz.BookBiz;
import com.neu.book.entity.Book;
import com.neu.yding.biz.YdBiz;
import com.neu.yding.entity.Yding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("yding")
@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600) //解决跨域问题
public class YdController {
    @Autowired
    private YdBiz ydBiz;
    @Autowired
    private BookBiz bookBiz;
    @RequestMapping(value="/addyd")
    @ResponseBody
    public Boolean addyd(int u_id, int b_id, Date ystarttime, Date yendtime, String status){
        Book book =new Book();
        book.setStatus(status);
        book.setBid(b_id);
        //修改状态方法
        bookBiz.updateStatus(book);
        //添加预定
        Yding yDing=new Yding(ystarttime,yendtime,u_id,b_id,status);
        Boolean bo=ydBiz.addYD(yDing);
        return bo;
    }
    @RequestMapping(value = "/findYD")
    @ResponseBody
    public Map<String ,Object> findYD(HttpSession session){
        int u_id=(int)session.getAttribute("uid");
        //调用查询的方法
        List<Yding> list=ydBiz.findYD(u_id);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("list",list);
        return map;

    }
    @RequestMapping(value = "/delYD")
    @ResponseBody
    public boolean delYD(int b_id){
        Book book=new Book();
        book.setStatus("未借");
        book.setBid(b_id);
        bookBiz.updateStatus(book);
        //删除
        Boolean bo= ydBiz.delYD(b_id);
        return bo;
    }
    @RequestMapping(value="/findAllYD")
    @ResponseBody
    public Map<String,Object> findAllYD(Integer index){
        if(index==null){
            index=1;
        }
        int size=4;
        //调用业务层的方法
        List<Yding> list=ydBiz.findAllYD(index,size);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("list",list);
        map.put("index",index);
        return map;

    }
}

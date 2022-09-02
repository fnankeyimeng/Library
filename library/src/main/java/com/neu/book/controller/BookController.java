package com.neu.book.controller;

import com.neu.book.biz.BookBiz;
import com.neu.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("book")
@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600) //解决跨域问题
public class BookController {
    @Autowired
    private BookBiz bookBiz;

    @RequestMapping("/findBook")
    @ResponseBody
    public Map<String,Object> findBook(Integer index) {
        if (index == null) {
            index = 1;
        }
        int size = 4;
        //调用业务层的方法
        List<Book> list = bookBiz.findBook(index, size);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("index", index);
        return map;
    }
    @RequestMapping("/findBookMo")
    @ResponseBody
    public Map<String,Object> findBook(Integer index,String bname) {
        if (index == null) {
            index = 1;
        }
        int size = 4;
        //调用业务层的方法
        List<Book> list = bookBiz.findBookMo(index, size,bname);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("index", index);
        map.put("bname",bname);
        return map;
    }

    @RequestMapping("/findByBookId")
    @ResponseBody
    public Book findByBookId(int bid){
        Book book=bookBiz.findByBookId(bid);
        return book;

    }
    @RequestMapping(value="/updateBook")
    @ResponseBody
    public Boolean updateBook(int bid,String bname,String bauthor,String status,String bpic){
        Book book=new Book(bid,bname,bauthor,status,bpic);
        Boolean bo=bookBiz.updateBook(book);
        return bo;
    }
    @RequestMapping(value="/addBook")
    @ResponseBody
    public Boolean addBook(int bid,String bname,String bauthor,String status,String bpic){
        Book book=new Book(bid,bname,bauthor,status,bpic);
        Boolean bo=bookBiz.addBook(book);
        return bo;
    }
    @RequestMapping(value = "/delBook")
    @ResponseBody
    public Boolean delBook(int bid){
        Boolean bo=bookBiz.delBook(bid);
        return bo;
    }


}

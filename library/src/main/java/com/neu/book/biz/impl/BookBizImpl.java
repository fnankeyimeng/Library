package com.neu.book.biz.impl;

import com.neu.book.biz.BookBiz;
import com.neu.book.entity.Book;
import com.neu.book.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bookBiz")
public class BookBizImpl  implements BookBiz {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> findBook(int index, int size) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("index",index);
        map.put("size",size);
        List<Book> list=bookMapper.findBook(map);
        return list;
    }

    @Override
    public List<Book> findBookMo(int index, int size, String bname) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("index",index);
        map.put("size",size);
        map.put("bname",bname);
        List<Book> list=bookMapper.findBookMo(map);
        return list;
    }

    @Override
    public Book findByBookId(int bid) {
        return bookMapper.findByBookId(bid);
    }


    @Override
    public boolean updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public boolean addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public boolean delBook(int bid) {
        return bookMapper.delBook(bid);
    }

    @Override
    public boolean updateStatus(Book book) {
        return bookMapper.updateStatus(book);
    }
}

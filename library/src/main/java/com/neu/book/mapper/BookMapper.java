package com.neu.book.mapper;

import com.neu.book.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {
    public List<Book> findBook(Map<String,Object> map);
    public List<Book> findBookMo(Map<String,Object> map);
    public Book findByBookId(int bid);
    public boolean updateBook(Book book);
    public boolean addBook(Book book);
    public boolean delBook(int bid);
    public boolean updateStatus(Book book);

}

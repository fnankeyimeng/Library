package com.neu.book.biz;

import com.neu.book.entity.Book;

import java.util.List;

public interface BookBiz {
    public List<Book> findBook(int index, int size);
    public List<Book> findBookMo(int index, int size,String bname);
    public Book findByBookId(int bid);

    public boolean updateBook(Book book);
    public boolean addBook(Book book);
    public boolean delBook(int bid);
    public boolean updateStatus(Book book);
}

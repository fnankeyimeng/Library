package com.neu.book.entity;

public class Book {
    private int bid;
    private String bname;
    private String bauthor;
    private String status;
    private String bpic;

    public Book() {
    }

    public Book(int bid, String bname, String bauthor, String status, String bpic) {
        this.bid = bid;
        this.bname = bname;
        this.bauthor = bauthor;
        this.status = status;
        this.bpic = bpic;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBpic() {
        return bpic;
    }

    public void setBpic(String bpic) {
        this.bpic = bpic;
    }
}
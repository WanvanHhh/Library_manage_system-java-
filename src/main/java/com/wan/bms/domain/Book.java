package com.wan.bms.domain;

import java.math.BigDecimal;

public class Book {
    private Long id;

    private String sn;

    private String name;

    private String author;

    private BigDecimal price;

    private Long dirid;

    private Directory directory;

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getDirid() {
        return dirid;
    }

    public void setDirid(Long dirid) {
        this.dirid = dirid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", dirid=" + dirid +
                ", directory=" + directory +
                '}';
    }
}
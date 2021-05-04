package com.wan.bms.service.impl;

import com.wan.bms.domain.Book;
import com.wan.bms.domain.Directory;
import com.wan.bms.mapper.DirectoryMapper;
import com.wan.bms.util.BeanUtil;
import com.wan.bms.util.MybatisUtil;
import com.wan.bms.util.Result;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;


public class BookServiceImplTest {

    private BookServiceImpl bookService = new BookServiceImpl();

    @Test
    public void addBook(){
        Book books = new Book();
        books.setId(32L);
        books.setName("qwerty");
        books.setAuthor("mnbvc");
        books.setDirid(5183L);
        books.setPrice(new BigDecimal("89456"));
        books.setSn("8925");
//        Result book = bookService.addBook(books);
        Result result = bookService.updateBookData(books);
        System.out.println(result);
    }

    @Test
    public void BeanUtil(){
        BeanUtil<Book> beanUtil = new BeanUtil<>()  ;
        beanUtil.jsonToBean(Book.class);
    }

    @Test
    public void testDirectory(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper mapper = sqlSession.getMapper(DirectoryMapper.class);
        Directory directory = new Directory();
        directory.setName("wang");
        directory.setDescribes("faskdh");
        mapper.insert(directory);
//        sqlSession.commit();
        sqlSession.close();

    }

}
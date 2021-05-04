package com.wan.bms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wan.bms.domain.Book;
import com.wan.bms.mapper.BookMapper;
import com.wan.bms.service.IBookService;
import com.wan.bms.util.query.BookQuery;
import com.wan.bms.util.MybatisUtil;
import com.wan.bms.util.Result;
import com.wan.bms.util.base.PageInfo;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.List;

public class BookServiceImpl implements IBookService {

    public BookServiceImpl(){
        Class<BookServiceImpl> bookServiceClass = BookServiceImpl.class;
        Method[] methods = bookServiceClass.getDeclaredMethods();
        for (Method method: methods) {
            METHOD_MAP.put(method.getName(), method);
        }
    }

    @Override
    public Result addBook(Book book) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        bookMapper.insert(book);
        sqlSession.commit();
        sqlSession.close();
        return new Result();
    }

    @Override
    public Result deleteBook(Book book) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        bookMapper.delete(book.getId());
        sqlSession.commit();
        sqlSession.close();
        return new Result();
    }

    @Override
    public Result updateBookData(Book book) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        System.out.println(book);
        bookMapper.update(book);
        sqlSession.commit();
        sqlSession.close();
        return new Result();
    }

    @Override
    public Result selectByBookID(Book book) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        Book b_result = bookMapper.selectOne(book.getId());
        Result rs = new Result(b_result);
        return rs;
    }

    @Override
    public Result selectBookList(BookQuery query) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        Page<Object> data = PageHelper.startPage(query.getCurrent(), query.getPageSize());
        List books = bookMapper.selectList(query);
        Long count = bookMapper.selectCount(query);
        PageInfo page = new PageInfo(data.getPageNum(),data.getPageSize(),count,books);
        Result rs = new Result(page);
        return rs;
    }
}

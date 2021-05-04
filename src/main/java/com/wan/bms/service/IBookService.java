package com.wan.bms.service;

import com.wan.bms.domain.Book;
import com.wan.bms.util.query.BookQuery;
import com.wan.bms.util.Result;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public interface IBookService {
    /**
     * 存储方法的map
     */
    Map<String, Method> METHOD_MAP = new HashMap<>();
    /**
     * 增加新书
     * @param book
     */
    Result addBook(Book book);

    /**
     * 删除书籍信息
     * @param book
     */
    Result deleteBook(Book book);

    /**
     * 更新书籍信息
     * @param book
     */
    Result updateBookData(Book book);

    /**
     * 根据id查询书籍信息
     * @param book
     * @return
     */
    Result selectByBookID(Book book);

    /**
     * 查询图书馆所有书籍信息
     * @param query
     * @return
     */
    Result selectBookList(BookQuery query);

}

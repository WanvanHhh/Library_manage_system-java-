package com.wan.bms.mapper;

import com.wan.bms.domain.Book;
import com.wan.bms.util.query.BookQuery;

import java.util.List;


/**
 * @author 万佳林
 * @created 2021-04-20 18:00
 * @describes
 */
public interface BookMapper {
    /**
     * 增加一条书籍信息
     * @param book
     */
    void insert(Book book);

    /**
     * 删除一条书籍信息
     * @param id
     */
    void delete(Long id);

    /**
     * 更新一条书籍信息
     * @param book
     */
    void update(Book book);

    /**
     * 查询出满足条件的数据总数（分页显示数据总数使用）
     * @param query
     * @return
     */
    Long selectCount(BookQuery query);

    /**
     * 根据id查询书籍信息
     * @param id
     * @return
     */
    Book selectOne(Long id);

    /**
     * 查询所有书籍信息
     * @param query
     * @return
     */
    List<Book> selectList(BookQuery query);
}
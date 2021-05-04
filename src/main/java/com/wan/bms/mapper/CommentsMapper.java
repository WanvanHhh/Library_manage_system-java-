package com.wan.bms.mapper;

import com.wan.bms.domain.Comments;
import com.wan.bms.util.query.CommentsQuery;

import java.util.List;

/**
 * @author 万佳林
 * @created 2021-04-24 15:00
 * @describes
 */
public interface CommentsMapper {
    /**
     * 通过id删除一条数据
     * @param id
     */
    void delete(Long id);

    /**
     * 插入一条新数据
     * @param comments
     */
    void insert(Comments comments);

    /**
     * 更新一条数据
     * @param comments
     */
    void update(Comments comments);

    /**
     * 根据id查询一条数据
     * @param id
     * @return
     */
    Comments selectOne(Long id);

    /**
     * 查询符合条件数据的总数
     * @param query
     * @return
     */
    Long selectCount(CommentsQuery query);

    /**
     * 查询所有
     * @param query
     * @return
     */
    List<Comments> selectList(CommentsQuery query);
}
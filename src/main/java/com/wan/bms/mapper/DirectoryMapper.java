package com.wan.bms.mapper;

import com.wan.bms.domain.Directory;
import com.wan.bms.util.query.Query;

import java.util.List;


/**
 * @author 万佳林
 * @created 2021-04-22 16:40
 * @describes
 */
public interface DirectoryMapper {

    /**
     * 通过id上述一条数据
     * @param directory
     */
    void delete(Directory directory);

    /**
     * 新增一条图书类型数据
     * @param directory
     */
    void insert(Directory directory);

    /**
     * 更新一条图书类型数据
     * @param directory
     */
    void update(Directory directory);

    /**
     * 通过id查询一条图书数据
     * @param directory
     * @return
     */
    Directory selectOne(Directory directory);

    /**
     * 选择类型数据列表
     * @param query
     * @return
     */
    List<Directory> selectList(Query query);

    /**
     * 查询数据总数
     * @param query
     * @return
     */
    Long selectCount(Query query);
}
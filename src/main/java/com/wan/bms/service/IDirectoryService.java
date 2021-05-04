package com.wan.bms.service;

import com.wan.bms.domain.Directory;
import com.wan.bms.util.Result;
import com.wan.bms.util.query.Query;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public interface IDirectoryService {

    Map<String, Method> METHOD_MAP = new HashMap<>();
    /**
     * 增加新书
     * @param directory
     */
    Result addDirectory(Directory directory);

    /**
     * 删除书籍信息
     * @param directory
     */
    Result deleteDirectory(Directory directory);

    /**
     * 更新书籍信息
     * @param directory
     */
    Result updateDirectoryData(Directory directory);

    /**
     * 根据id查询书籍信息
     * @param directory
     * @return
     */
    Result selectByDirectoryID(Directory directory);

    /**
     * 查询图书馆所有书籍信息
     * @param query
     * @return
     */
    Result selectDirectoryList(Query query);

}

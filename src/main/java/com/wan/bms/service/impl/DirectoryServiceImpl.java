package com.wan.bms.service.impl;

import com.github.pagehelper.PageHelper;
import com.wan.bms.domain.Directory;
import com.wan.bms.mapper.DirectoryMapper;
import com.wan.bms.service.IDirectoryService;
import com.wan.bms.util.MybatisUtil;
import com.wan.bms.util.Result;
import com.wan.bms.util.base.PageInfo;
import com.wan.bms.util.query.Query;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.List;

public class DirectoryServiceImpl implements IDirectoryService {

    public DirectoryServiceImpl(){
        Class<DirectoryServiceImpl> directoryServiceClass = DirectoryServiceImpl.class;
        Method[] methods = directoryServiceClass.getDeclaredMethods();
        for (Method method: methods) {
            METHOD_MAP.put(method.getName(), method);
        }
    }

    @Override
    public Result addDirectory(Directory directory) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);

        directoryMapper.insert(directory);
        sqlSession.commit();
        sqlSession.close();
        return new Result();
    }

    @Override
    public Result deleteDirectory(Directory directory) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);

        directoryMapper.delete(directory);
        sqlSession.commit();
        sqlSession.close();
        return new Result();
    }

    @Override
    public Result updateDirectoryData(Directory directory) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);

        directoryMapper.update(directory);
        sqlSession.commit();
        sqlSession.close();
        return new Result();
    }

    @Override
    public Result selectByDirectoryID(Directory directory) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);

        Directory data = directoryMapper.selectOne(directory);
        sqlSession.close();
        return new Result(data);
    }

    @Override
    public Result selectDirectoryList(Query query) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);

        PageHelper.startPage(query.getCurrent(), query.getPageSize());

        List directories = directoryMapper.selectList(query);
        Long count = directoryMapper.selectCount(query);
        PageInfo page = new PageInfo(query.getCurrent(),query.getPageSize(),count,directories);
        sqlSession.close();
        return new Result(page);
    }
}

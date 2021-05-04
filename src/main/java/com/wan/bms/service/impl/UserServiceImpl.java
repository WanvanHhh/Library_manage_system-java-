package com.wan.bms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wan.bms.domain.Comments;
import com.wan.bms.domain.User;
import com.wan.bms.mapper.CommentsMapper;
import com.wan.bms.mapper.UserMapper;
import com.wan.bms.service.IUserService;
import com.wan.bms.util.CodeMsg;
import com.wan.bms.util.MybatisUtil;
import com.wan.bms.util.Result;
import com.wan.bms.util.base.PageInfo;
import com.wan.bms.util.query.CommentsQuery;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.List;

public class UserServiceImpl implements IUserService {

    public UserServiceImpl(){
        Class<UserServiceImpl> userServiceClass = UserServiceImpl.class;
        Method[] methods = userServiceClass.getDeclaredMethods();
        for (Method method: methods) {
            METHOD_MAP.put(method.getName(), method);
        }
    }

    @Override
    public Result Login(User user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String password = user.getPassword();
        User value = mapper.selectOne(user);
        Result result;

        if(value != null){
            if(value.getPassword().equals(password)){
                result = new Result();
            }else {
                result = new Result(CodeMsg.LOGIN_FAILD_WRONG_PASSWORD);
            }
        }else {
            result = new Result(CodeMsg.LOGIN_FAILD_ACCOUNT_NOT_REGISTERED);
        }

        sqlSession.close();
        return result;
    }

    @Override
    public Result comments(Comments comments) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CommentsMapper mapper = sqlSession.getMapper(CommentsMapper.class);
        mapper.insert(comments);

        sqlSession.commit();
        sqlSession.close();
        return new Result();
    }

    @Override
    public Result checkComments(CommentsQuery query){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CommentsMapper mapper = sqlSession.getMapper(CommentsMapper.class);

        Page<Object> data = PageHelper.startPage(query.getCurrent(), query.getPageSize());

        List commentsList = mapper.selectList(query);
        Long count = mapper.selectCount(query);
        PageInfo page = new PageInfo(query.getCurrent(),query.getPageSize(),count,commentsList);
        System.out.println(page);
        sqlSession.close();
        return new Result(page);
    }

}

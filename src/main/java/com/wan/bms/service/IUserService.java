package com.wan.bms.service;

import com.wan.bms.domain.Comments;
import com.wan.bms.domain.User;
import com.wan.bms.util.Result;
import com.wan.bms.util.query.CommentsQuery;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public interface IUserService {
    /**
     * 存储方法的map
     */
    Map<String, Method> METHOD_MAP = new HashMap<>();

    /**
     * 登录
     * @param user
     * @return
     */
    Result Login(User user);

    /**
     * 对某个书进行评论
     * @param comments
     * @return
     */
    Result comments(Comments comments);

    /**
     * 查看评论
     * @param query
     * @return
     */
    Result checkComments(CommentsQuery query);
}

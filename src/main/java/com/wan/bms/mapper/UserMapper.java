package com.wan.bms.mapper;

import com.wan.bms.domain.User;
import org.apache.ibatis.annotations.Param;

import java.sql.ResultSet;

/**
 * @author 万佳林
 * @created 2021-04-24 20:00
 * @describes
 */
public interface UserMapper {

    /**
     * 根据username查询用户信息
     * @param user
     * @return
     */
    User selectOne(User user);
}
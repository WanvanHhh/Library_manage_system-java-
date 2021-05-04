package com.wan.bms.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 万佳林
 * @created 2021-04-21 15:23
 * @describes mybatis工具类，用于获取SqlSession对象
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static InputStream input = null;

    static {
        try {
            //读取mybatis主配置文件
            input = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭输入流
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 返回SqlSession对象
     * @return  SqlSession对象
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * 释放链接对象
     * @param conn 链接对象
     */
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

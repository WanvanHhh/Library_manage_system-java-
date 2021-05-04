package com.wan.bms.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 万佳林
 * @created 2021-04-22 16:45
 * @describes 这个类是用来将前端的传过来的参数封装成bean
 * @param <T>
 */
public class BeanUtil<T> {

    /**
     * 将前端传入的参数封装成实体类对象
     * @param req
     * @param tClass
     * @return
     */
    public T jsonToBean(HttpServletRequest req,Class<T> tClass){
        T result = null;
        try {
            //创建实体类对象
            T object = tClass.getDeclaredConstructor().newInstance();
            //获取实体类对象中的参数集合
            Field[] declaredFields = tClass.getDeclaredFields();
            Map<String,String> map = new HashMap<>();
            for (Field f: declaredFields) {
                //设置可以操作私有变量
                f.setAccessible(true);
                //根据对象中的字段取出前端数据
                String key = f.getName();
                String value = req.getParameter(key);
                //封装进map对象
                map.put(key,value);
            }
            //封装完后再讲map对象转换为实体类对象
            result = JSON.parseObject(JSON.toJSONString(map), tClass);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回封装好的数据
        return result;
    }

    //这个一个测试方法，不是主要代码
    public T jsonToBean(Class<T> tClass){
        T t = null;
        try {
            //创建实体类对象
            t = tClass.getDeclaredConstructor().newInstance();
            //获取实体类对象中的参数集合
            Field[] declaredFields = tClass.getDeclaredFields();

            String ob = "5";
            Integer i = Integer.valueOf(ob);
            Long L = java.lang.Long.valueOf(ob);

//            BigDecimal b = new BigDecimal(ob);
            System.out.println(i);
            for (Field f: declaredFields) {
                f.setAccessible(true);
                System.out.println(f.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }


}

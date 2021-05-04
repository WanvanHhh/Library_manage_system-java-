package com.wan.bms.servlet;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.wan.bms.domain.Directory;
import com.wan.bms.service.impl.DirectoryServiceImpl;
import com.wan.bms.util.BeanUtil;
import com.wan.bms.util.Result;
import com.wan.bms.util.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 万佳林
 * @created 2021-04-22 17:36
 * @describes 图书类别Servlet
 */
@WebServlet("/Directory")
public class DirectoryServlet extends HttpServlet {
    DirectoryServiceImpl directoryService = new DirectoryServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这里是DirectoryServlet");
        //获取BeanUtil工具类对象
        BeanUtil<Directory> beanUtil = new BeanUtil<>();
        //转换前端数据为Directory实体类对象
        Directory directory = beanUtil.jsonToBean(req, Directory.class);
        //获取需要进行的操作对象
        String action = req.getParameter("action");
        //获得进行操作的方法对象
        Method method = DirectoryServiceImpl.METHOD_MAP.get(action);

        System.out.println("这里是DirectoryServlet打印的Session："+req.getSession().getAttribute("username"));

        if(action != null){
            try {
                Result invoke = null;
                if("selectDirectoryList".equals(action)){    //查询页面数据
                    BeanUtil<Query> beanUtil2 = new BeanUtil<>();
                    Query query = beanUtil2.jsonToBean(req,Query.class);
                    checkPageInfo(req,query);
                    System.out.println("查询条件打印"+query.getCurrent()+" 一页显示条数:"+query.getPageSize());

                    invoke = (Result) method.invoke(directoryService,query);
                }else{
                    invoke = (Result) method.invoke(directoryService,directory);
                }
                //响应数据
                resp.getWriter().write(JSONObject.toJSONString(invoke));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 封装页码和每页显示条数
     * 当前端传过来的当前页码current为空时，使用默认设定的current=1
     * 当前端传过来的当前页码pageSize为空时，使用默认设定的pageSize=10
     * @param req
     * @param query
     */
    public void checkPageInfo(HttpServletRequest req, Query query){
        String current = req.getParameter("current");
        String pageSize = req.getParameter("pageSize");

        if(StringUtil.isNotEmpty(current)){
            query.setCurrent(Integer.valueOf(current));
        };

        if(StringUtil.isNotEmpty(pageSize)){
            query.setPageSize(Integer.valueOf(pageSize));
        };
    }
}

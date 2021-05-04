package com.wan.bms.servlet;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.wan.bms.domain.Comments;
import com.wan.bms.domain.User;
import com.wan.bms.service.impl.UserServiceImpl;
import com.wan.bms.util.BeanUtil;
import com.wan.bms.util.Result;
import com.wan.bms.util.query.CommentsQuery;
import com.wan.bms.util.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 万佳林
 * @created 2021-04-24 15:35
 * @describes 用户Servlet，登录系统，查看评论等
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这里是DirectoryServlet");
        //获取需要进行的操作对象
        String action = req.getParameter("action");
        //获得进行操作的方法对象
        Method method = UserServiceImpl.METHOD_MAP.get(action);

        if(action != null){
            try {
                Result invoke = null;
                if("Login".equals(action)){
                    //获取BeanUtil工具类对象
                    BeanUtil<User> beanUtil = new BeanUtil<>();
                    //转换前端数据为Directory实体类对象
                    User user = beanUtil.jsonToBean(req, User.class);

                    //存储Session
                    System.out.println("正在执行Login方法，在这里存储Session");
                    HttpSession session = req.getSession();
                    session.setAttribute("username",user.getUsername());
                    System.out.println("sessionID: "+session.getId());
                    invoke = (Result) method.invoke(userService,user);
                }else if("comments".equals(action)){
                    String username = (String) req.getSession().getAttribute("username");

                    BeanUtil<Comments> beanUtil2 = new BeanUtil<>();
                    Comments comments = beanUtil2.jsonToBean(req, Comments.class);
                    //封装评论人username
                    comments.setUsername("wan");
                    //封住评论时间（即当前访问端口的时间）
                    Date date = new Date();
                    comments.setDate(date);

                    invoke = (Result) method.invoke(userService,comments);
                }else if("checkComments".equals(action)){
                    BeanUtil<CommentsQuery> beanUtil = new BeanUtil<>();
                    CommentsQuery commentsQuery = beanUtil.jsonToBean(req, CommentsQuery.class);
                    checkPageInfo(req, commentsQuery);  //封装页码和每页显示条数

                    invoke = (Result) method.invoke(userService,commentsQuery);
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
    public void checkPageInfo(HttpServletRequest req, CommentsQuery query){
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

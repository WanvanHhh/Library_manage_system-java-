package com.wan.bms.servlet;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.wan.bms.domain.Book;
import com.wan.bms.service.impl.BookServiceImpl;
import com.wan.bms.util.BeanUtil;
import com.wan.bms.util.query.BookQuery;
import com.wan.bms.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 万佳林
 * @created 2021-04-20 15:00
 * @describes 图书Servlet
 */
@WebServlet("/Book")
public class BookServlet extends HttpServlet {

    private BookServiceImpl bookService = new BookServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这里是BookServlet");
        //获取需要进行的操作对象
        String action = req.getParameter("action");
        //获得进行操作的方法对象
        Method method = BookServiceImpl.METHOD_MAP.get(action);

        System.out.println("============"+req.getCookies());

        System.out.println("这里是BookServlet打印的SessionID："+req.getSession().getId());

        if(action != null){
            try {
                Result invoke = null;
                if("selectBookList".equals(action)){    //查询页面数据
                    BeanUtil<BookQuery> beanUtil2 = new BeanUtil<>();   //加载beanUtil
                    BookQuery query = beanUtil2.jsonToBean(req,BookQuery.class);    //封装前端传过来的参数
                    checkPageInfo(req, query);//封装页码和每页显示条数
                    System.out.println( "查询条件打印："+ query.getCurrent()+query.getPageSize());

                    invoke = (Result) method.invoke(bookService,query);
                }else{
                    //获取BeanUtil工具类对象
                    BeanUtil<Book> beanUtil = new BeanUtil<>();
                    //转换前端数据为Book实体类对象
                    Book book = beanUtil.jsonToBean(req, Book.class);
                    invoke = (Result) method.invoke(bookService,book);
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
    public void checkPageInfo(HttpServletRequest req, BookQuery query){
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

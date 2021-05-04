package com.wan.bms.components;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author 万佳林
 * @created 2021-04-20 15:30
 * @describes 过滤器，处理前端请求
 */
@WebFilter("/*")
public class CorsFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.displayName());

        res.addHeader("Access-Control-Allow-Origin", "*");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json;charset=utf-8");
        res.addHeader("Access-Control-Allow-Credentials", "true");
        res.addHeader("Access-Control-Allow-Methods", "*");
        res.addHeader("Access-Control-Allow-Headers", "*");
        res.setHeader("Access-Control-Max-Age", "3600");

        chain.doFilter(req, res);
    }
}

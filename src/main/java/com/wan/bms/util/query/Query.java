package com.wan.bms.util.query;

/**
 * @author 万佳林
 * @created 2021-04-21 16:45
 * @describes 查询条件基类
 */
public class Query {
    /**
     * 页码默认为1
     */
    Integer current=1;
    /**
     * 查询数据从条数据开始
     */
    Integer start;
    /**
     * 每页的数据默认为长度为10
     */
    Integer pageSize=10;

    public Integer getStart() {
        return ((current-1)*pageSize);
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

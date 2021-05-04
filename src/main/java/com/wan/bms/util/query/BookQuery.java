package com.wan.bms.util.query;

/**
 * @author 万佳林
 * @created 2021-04-24 15:35
 * @describes 图书查询条件封装
 */
public class BookQuery extends Query {
    private String keyword;
    private Long dirid;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getDirid() {
        return dirid;
    }

    public void setDirid(Long dirid) {
        this.dirid = dirid;
    }

    @Override
    public String toString() {
        return "BookQuery{" +
                "keyword='" + keyword + '\'' +
                ", dirid=" + dirid +
                '}';
    }
}

package com.wan.bms.util.query;

/**
 * @author 万佳林
 * @created 2021-04-24 21:45
 * @describes 封装评论查询条件
 */
public class CommentsQuery extends Query {
    private Long bookId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "CommentsQuery{" +
                "bookId=" + bookId +
                ", current=" + current +
                ", start=" + start +
                ", pageSize=" + pageSize +
                '}';
    }
}

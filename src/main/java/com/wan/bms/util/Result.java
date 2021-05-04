package com.wan.bms.util;

/**
 * @author 万佳林
 * @created 2021-04-21 20:45
 * @describes 返回结果对象，可封装业务码，业务信息，以及业务数据
 */
public class Result {

    /**
     * 业务编码
     */
    private Integer code;
    /**
     * 业务信息
     */
    private String msg;
    /**
     * 业务数据
     */
    private Object data;

    /**
     * 正常没有数据的返回结果
     */
    public Result(){
        this.code = CodeMsg.SUCCESS.CODE;
        this.msg = CodeMsg.SUCCESS.MSG;
    }

    /**
     * 不正常没有数据的Result
     * @param codeMsg 业务码
     */
    public Result(CodeMsg codeMsg){
        this.code = codeMsg.CODE;
        this.msg = codeMsg.MSG;
    }

    /**
     * 正常带数据的Result
     * @param data
     */
    public Result(Object data){
        this(); //调用无参构造函数
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

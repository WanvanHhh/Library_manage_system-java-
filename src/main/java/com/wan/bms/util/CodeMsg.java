package com.wan.bms.util;

/**
 * @author 万佳林
 * @created 2021-04-21 16:45
 * @describes 枚举业务码和业务信息
 */
public enum CodeMsg {
    SUCCESS(200,"成功"),
    ERROR(110,"程序员相亲去了"),
    LOGIN_FAILD_WRONG_PASSWORD(110,"密码错误"),
    LOGIN_FAILD_ACCOUNT_NOT_REGISTERED(404,"账号未注册");

    /**
     * 业务码
     */
    public Integer CODE;

    /**
     * 业务信息
     */
    public String MSG;

    CodeMsg(Integer code,String msg){
        this.CODE = code;
        this.MSG = msg;
    }
}

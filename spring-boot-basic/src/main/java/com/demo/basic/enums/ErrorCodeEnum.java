package com.demo.basic.enums;

/**
 * 自定义的异常枚举类
 *
 * @author xielx at 2019/11/25 20:45
 */
public enum ErrorCodeEnum {
    PARAM_ERROR(1000,"参数不正确"),
    SESSION_IN_VALIDATE(1001,"无效会话"),
    UNKNOWN_ACCOUNT(1002,"未知账户"),
    UNKNOWN_ERROR(1010,"系统异常");
    
    private Integer code;
    private String msg;
    
    ErrorCodeEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
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
}

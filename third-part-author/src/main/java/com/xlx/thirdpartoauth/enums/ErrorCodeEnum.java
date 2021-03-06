package com.xlx.thirdpartoauth.enums;

/**
 * 错误信息提示枚举类
 *
 * @author xielx at 2020/3/7 22:24
 */
public enum ErrorCodeEnum {
    
    SYSTEM_ERROR(9999,"系统异常"),
    AUTHORIZED_FAILED(1001,"授权失败"),
    GET_USER_INFO_FAILED(1002,"获取用户信息失败"),
    PARAMS_VALIDATE_ERROR(1003,"参数检验错误")
    ;
    
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    
    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}

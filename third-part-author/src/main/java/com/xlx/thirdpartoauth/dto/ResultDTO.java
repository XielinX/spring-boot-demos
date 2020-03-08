package com.xlx.thirdpartoauth.dto;

import com.xlx.thirdpartoauth.enums.ErrorCodeEnum;

import java.util.Objects;

/**
 * 统一操作结果
 *
 * @author xielx on 2019/7/13
 */

public class ResultDTO {
    
    private static final String SUCCESS = "操作成功";
    private static final String FAILURE = "操作失败";
    
    // 状态码
    private Integer code;
    
    // 提示信息
    private String message;
    
    //携带参数
    private Object data;
    
    
    public ResultDTO(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    public ResultDTO(ErrorCodeEnum errorCodeEnum, Object data) {
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getMessage();
        this.data = data;
    }
    
    
    /**
     * 默认成功
     * @return dto
     */
    public static ResultDTO success(){
        return new ResultDTO(200,ResultDTO.SUCCESS,null);
    }
    
    /**
     * 自定义提示信息
     * @param message msg
     * @return dto
     */
    public static ResultDTO success(String message){
        return new ResultDTO(200,message,null);
    }
    
    /**
     * 携带参数
     * @param object obj
     * @return dto
     */
    public static ResultDTO success(Object object){
        return new ResultDTO(200,ResultDTO.SUCCESS,object);
    }
    
    /**
     * 自定义信息+携带参数
     * @param message msg
     * @param object obj
     * @return dto
     */
    public static ResultDTO success(String message,Object object){
        return new ResultDTO(200,message,object);
    }
    
    
    /**
     * 默认失败
     * @return dto
     */
    public static ResultDTO failed(){
        return new ResultDTO(400,ResultDTO.FAILURE,null);
    }
    
    public static ResultDTO failed(String message){
        return new ResultDTO(400,message,null);
    }
    
    
    public static ResultDTO failed(Integer code,String message){
        return new ResultDTO(code,message,null);
    }
    /**
     * 失败
     * @param errorCodeEnum 枚举参数
     * @return dto
     */
    public static ResultDTO failed(ErrorCodeEnum errorCodeEnum){
        return new ResultDTO(errorCodeEnum.getCode(),errorCodeEnum.getMessage(),null);
    }
    
    
    public static ResultDTO failed(ErrorCodeEnum errorCodeEnum, Object data){
        return new ResultDTO(errorCodeEnum.getCode(),errorCodeEnum.getMessage(),data);
    }
    
    
    
    
    
    public static String getSUCCESS() {
        return SUCCESS;
    }
    
    public static String getFAILURE() {
        return FAILURE;
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
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
}

package com.demo.basic.dto;

import com.demo.basic.enums.ErrorCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 统一操作结果
 *
 * @author xielx on 2019/7/13
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDTO {
    
    /**
     * 处理是否成功
     */
    private Boolean success;
    /**
     * 状态码
     */
    private Integer code;
    
    /**
     * 提示信息
     */
    private String message;
    
    /**
     * 参数
     */
    private Object data;
    
    private ResultDTO(){}
    
    private ResultDTO(Boolean success,Integer code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
    
    /**
     * 默认成功
     */
    public  static ResultDTO success() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(true);
        return resultDTO;
    }
    
    /**
     * 自定义提示信息
     */
    public static ResultDTO success(String message) {
        return new ResultDTO(true, null,message, null);
    }
    
    /**
     * 携带参数
     */
    public static ResultDTO success(Object data) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(true);
        resultDTO.setData(data);
        return resultDTO;
    }
    
    /**
     * 自定义信息+携带参数
     */
    public static ResultDTO success(String message, Object object) {
        return new ResultDTO(true,null, message, object);
    }
    
    /**
     * ************************
     * 默认失败
     * ************************
     */
    public static ResultDTO failed() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(false);
        return resultDTO;
        
    }
    
    
    /**
     * 状态码 + 提示信息
     */
    public static ResultDTO failed(ErrorCodeEnum errorCode) {
        return new ResultDTO(false,errorCode.getCode(), errorCode.getMsg(), null);
    }
    
    
    /**
     * 传参
     *
     * @param object 参数
     * @return obj
     */
    public static ResultDTO failed(ErrorCodeEnum errorCode,Object object) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(false);
        resultDTO.setCode(errorCode.getCode());
        resultDTO.setMessage(errorCode.getMsg());
        resultDTO.setData(object);
        return resultDTO;
    }
    
    
    
}

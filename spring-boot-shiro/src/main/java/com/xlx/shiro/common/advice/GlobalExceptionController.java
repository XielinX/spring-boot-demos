package com.xlx.shiro.common.advice;

import com.xlx.shiro.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * spring-boot的全局异常处理
 *
 * @author xielx on 2019/7/14
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {


  //浏览器/其他客户端访问都是返回json信息
  @ExceptionHandler(Exception.class)
  public ResultDTO errorHandler(HttpServletRequest request,Throwable t){

    HttpStatus status = getStatus(request);
    if (status.is4xxClientError()){
      //4
      log.error("状态码:[{}],错误信息[{}]:" , status.value(),t.getMessage());
      return ResultDTO.failed(status.value(),t.getMessage());
    }else if (status.is5xxServerError()){
      //5
      log.error("状态码:[{}],错误信息[{}]:" , status.value(),t.getMessage());
      return ResultDTO.failed(status.value(),t.getMessage());
    }else {
      //其他
      log.error("状态码:[{}],错误信息[{}]:" , status.value(),t.getMessage());
      return ResultDTO.failed(status.value(),t.getMessage());
    }
  }

  /**
   * 获取响应的状态码
   * @param request re
   * @return .
   */
  private HttpStatus getStatus(HttpServletRequest request){
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
    if (statusCode == null){
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    try{
      return HttpStatus.valueOf(statusCode);
    }catch (Exception e){
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }
  }
}

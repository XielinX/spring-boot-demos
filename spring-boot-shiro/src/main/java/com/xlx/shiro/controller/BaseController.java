package com.xlx.shiro.controller;

import com.xlx.shiro.common.util.DateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

/**
 * 通用
 *
 * @author xielx on 2019/7/27
 */
@Slf4j
public class BaseController {


	public void initBind(WebDataBinder binder){
		binder.registerCustomEditor(Date.class,new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				try {
					setValue(DateUtil.parseStringToFullTime(text));
				} catch (ParseException e) {
					log.error("日期解析失败:[{}]",e.getMessage(),e);
				}
			}
		});
	}
}

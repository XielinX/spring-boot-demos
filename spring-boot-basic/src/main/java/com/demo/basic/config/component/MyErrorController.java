package com.demo.basic.config.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 自定义的ErrorController
 *
 * @author xielx at 2019/11/25 19:45
 */
//@Component
public class MyErrorController extends DefaultErrorAttributes {
    
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","atxlx");
    
        Object ext = webRequest.getAttribute("ext", 0);
        map.put("ext",ext);
        return map;
    }
}

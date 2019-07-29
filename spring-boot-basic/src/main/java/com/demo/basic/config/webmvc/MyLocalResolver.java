package com.demo.basic.config.webmvc;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化
 *
 * @author xielx on 2019/7/29
 */
public class MyLocalResolver implements LocaleResolver {
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String language = request.getParameter("l");
		Locale locale = Locale.getDefault();
		if (!StringUtils.isEmpty(language)){
			String[] s = language.split("_");
			locale = new Locale(s[0],s[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

	}
}

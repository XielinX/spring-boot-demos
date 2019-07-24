package com.xlx.shiro.common.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.xlx.shiro.shiro.credentials.RetryLimitHashedCredentialsMatcher;
import com.xlx.shiro.shiro.filter.SysUserFilter;
import com.xlx.shiro.shiro.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro注解配置
 *
 * @author xielx on 2019/7/23
 */
@Configuration
public class ShiroConfig {


	/**
	 * 自定义Realm
	 */
	@Bean(name = "userRealm")
	public UserRealm userRealm() {
		UserRealm userRealm = new UserRealm();
		//使用自定义的CredentialsMatcher
		userRealm.setCredentialsMatcher(credentialsMatcher());
		userRealm.setCachingEnabled(false);
		return new UserRealm();
	}


	/**
	 * 会话管理 SessionManager
	 * @return obj
	 */
	@Bean
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
		//设置全局session超时时间,单位/毫秒,此处30min
		defaultWebSessionManager.setGlobalSessionTimeout(1800000);
		defaultWebSessionManager.setDeleteInvalidSessions(true);
		defaultWebSessionManager.setSessionValidationSchedulerEnabled(true);
		//Quartz
		defaultWebSessionManager.setSessionValidationScheduler(sessionValidationScheduler());
		//SessionDAO
		defaultWebSessionManager.setSessionDAO(sessionDAO());
		//SessionIdCookie
		defaultWebSessionManager.setSessionIdCookieEnabled(true);
		defaultWebSessionManager.setSessionIdCookie(sessionIdCookie());
		return defaultWebSessionManager;
	}

	/**
	 * 安全管理器 SecurityManager
	 * @return obj
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		// Realm
		defaultWebSecurityManager.setRealm(userRealm());
		//SessionManager
		defaultWebSecurityManager.setSessionManager(sessionManager());
		//CacheManager
		defaultWebSecurityManager.setCacheManager(cacheManager());
		//RememberMeManager
		defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
		return defaultWebSecurityManager;
	}

	/**
	 * 会话验证调度器 sessionValidationScheduler
	 * @return obj
	 */
	@Bean
	public QuartzSessionValidationScheduler sessionValidationScheduler(){
		QuartzSessionValidationScheduler quartz = new QuartzSessionValidationScheduler();
		//session刷新时间间隔,单位/毫秒,此处设置30min
		quartz.setSessionValidationInterval(1800000);
		//SessionManager
		quartz.setSessionManager(sessionManager());
		return quartz;
	}

	/**
	 * 缓存管理器 CacheManager
	 */
	@Bean
	public CacheManager cacheManager() {
		EhCacheManager ehCacheManager = new EhCacheManager();
		ehCacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
		return ehCacheManager;
	}

	/**
	 * 凭证匹配器 HashedCredentialsMatcher
	 */
	@Bean
	public HashedCredentialsMatcher credentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher(cacheManager());
		//密码匹配设置:采用的加密算法md5,迭代次数2,使用16进制编码存储密码
		hashedCredentialsMatcher.setHashAlgorithmName("md5");
		hashedCredentialsMatcher.setHashIterations(2);
		hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
		return hashedCredentialsMatcher;
	}



	/**
	 * 会话ID生成器 SessionIdGenerator
	 * @return obj
	 */
	@Bean
	public JavaUuidSessionIdGenerator sessionIdGenerator(){
		return new JavaUuidSessionIdGenerator();
	}

	/**
	 * 会话Cookie模板 sessionIdCookie
	 * @Return I
	 */
	@Bean
	public Cookie sessionIdCookie(){
		SimpleCookie simpleCookie = new SimpleCookie("sessionId");
		simpleCookie.setHttpOnly(true);
		//单位:秒,此处设置浏览器关闭即失效
		simpleCookie.setMaxAge(-1);
		simpleCookie.setPath("/");
		return simpleCookie;
	}

	/**
	 * 记住我 RememberMeCookie
	 * @Return I
	 */
	@Bean
	public Cookie rememberMeCookie(){
		SimpleCookie simpleCookie = new SimpleCookie();
		simpleCookie.setHttpOnly(true);
		//单位:秒;此处设置7天
		simpleCookie.setMaxAge(7*24*60*60);
		simpleCookie.setPath("/");
		return simpleCookie;
	}

	/**
	 * 记住我管理器 RememberMeManager
	 * @return obj
	 */
	@Bean
	public CookieRememberMeManager rememberMeManager(){
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		//cookie加密的密钥
		cookieRememberMeManager.setCipherKey(Base64.decode("c3ByaW5nYm9vcnNoaXJv"));
		//RememberMeCookie
		cookieRememberMeManager.setCookie(rememberMeCookie());
		return cookieRememberMeManager;
	}


	/**
	 * 会话DAO SessionDAO
	 * @return obj
	 */
	@Bean
	public SessionDAO sessionDAO(){
		EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
		enterpriseCacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
		//SessionIdGenerator
		enterpriseCacheSessionDAO.setSessionIdGenerator(sessionIdGenerator());
		return enterpriseCacheSessionDAO;
	}

	/**
	 * 安全管理器工厂 Factory
	 * 相当于:SecurityUtils.setSecurityManager(securityManager)
	 * @return obj
	 */
	@Bean
	public MethodInvokingFactoryBean factoryBean(){
		MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
		methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
		//SecurityManager
		methodInvokingFactoryBean.setArguments(securityManager());
		return methodInvokingFactoryBean;
	}


	/**
	 * 基于Form表单的身份验证过滤器 FormAuthenticationFilter
	 * @return obj
	 */
	@Bean
	public FormAuthenticationFilter formAuthenticationFilter(){
		FormAuthenticationFilter formFilter = new FormAuthenticationFilter();
		formFilter.setUsernameParam("username");
		formFilter.setPasswordParam("password");
		formFilter.setRememberMeParam("rememberMe");
		formFilter.setLoginUrl("/login");
		return formFilter;
	}


	/**
	 * 自定义过滤器
	 * @return obj
	 */
	@Bean
	public PathMatchingFilter sysUserFilter(){
		return new SysUserFilter();
	}
	/**
	 * Shiro的Web过滤器 ShiroFilterFactoryBean
	 * @return obj
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactory() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		//登录url
		shiroFilterFactoryBean.setLoginUrl("/login");
		//登录成功后跳转url
		//未授权跳转url
		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");


		//设置过滤器
		Map<String, Filter> filters = new LinkedHashMap<>();
		filters.put("authc",formAuthenticationFilter());
		filters.put("sysUser",sysUserFilter());
		shiroFilterFactoryBean.setFilters(filters);

		//设置过滤链
		Map<String,String> filterChainDefinitions = new LinkedHashMap<>();
		filterChainDefinitions.put("/static/**","anon");
		filterChainDefinitions.put("/login","authc");
		filterChainDefinitions.put("/logout","logout");
		filterChainDefinitions.put("/authenticated","authc");
		filterChainDefinitions.put("/**","user,sysUser");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitions);
		return shiroFilterFactoryBean;
	}


	/**
	 * 开启shiro的权限注解
	 * @return obj
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor shiroAnnotation(){
		AuthorizationAttributeSourceAdvisor attributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		//SecurityManager
		attributeSourceAdvisor.setSecurityManager(securityManager());
		return attributeSourceAdvisor;
	}

	/**
	 * thymeleaf使用shiro标签
	 * @return obj
	 */
	@Bean
	public ShiroDialect dialectForThymeleaf(){
		return new ShiroDialect();
	}
	/**
	 * Shiro的生命周期处理器 Lifecycle
	 * @return obj
	 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 自定义过滤器:
	 *   Form表单验证过滤
	 *   验证码过滤
	 */

}



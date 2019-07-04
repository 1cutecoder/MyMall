package com.cskaoyan.malldemo.config;

import com.cskaoyan.malldemo.shiro.CustomRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.HashMap;
import java.util.Properties;

/**
 * Created by cute coder
 * 2019/5/25 16:17
 */
@Configuration
public class ShiroConfig {

  @Bean
  public SecurityManager defaultWebSecurityManager(CustomRealm customRealm,SessionManager sessionManager) {
    DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
    webSecurityManager.setRealm(customRealm);
    webSecurityManager.setSessionManager(sessionManager);
    return webSecurityManager;
  }

  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    shiroFilterFactoryBean.setSecurityManager(securityManager);
    HashMap<String, String> filterMap = new HashMap<>();
    filterMap.put("/admin/auth/login", "anon");
    filterMap.put("/admin/auth/401", "anon");
    filterMap.put("/admin/auth/index", "anon");
    filterMap.put("/admin/auth/403", "anon");
    filterMap.put("/admin/index/index", "anon");
    filterMap.put("/admin/**", "authc");
    shiroFilterFactoryBean.setLoginUrl("/admin/auth/401");
    shiroFilterFactoryBean.setSuccessUrl("/admin/auth/index");
    shiroFilterFactoryBean.setUnauthorizedUrl("/admin/auth/403");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
    return shiroFilterFactoryBean;
  }

  @Bean
  public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
    SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
    Properties properties = new Properties();
    properties.setProperty("IncorrectCredentialsException", "/admin/login");
    properties.setProperty("AuthorizationException", "/logout");
    exceptionResolver.setExceptionMappings(properties);
    return exceptionResolver;
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
    return authorizationAttributeSourceAdvisor;
  }

  @Bean
  public SessionManager sessionManager() {
    AdminWebSessionManager mySessionManager = new AdminWebSessionManager();
    return mySessionManager;
  }

  @Bean
  public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
    return new LifecycleBeanPostProcessor();
  }

  @Bean
  @DependsOn("lifecycleBeanPostProcessor")
  public static DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
    DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
    creator.setProxyTargetClass(true);
    return creator;
  }

}

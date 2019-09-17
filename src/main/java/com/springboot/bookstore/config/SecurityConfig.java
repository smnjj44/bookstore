package com.springboot.bookstore.config;

import com.springboot.bookstore.bean.Customer;
import com.springboot.bookstore.bean.Manager;
import com.springboot.bookstore.dao.LoginMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.List;

/**
 * EnableGlobalMethodSecurity(prePostEnabled=true):
 * Spring Security默认是禁用注解的，要想开启注解，
 * 需要在继承WebSecurityConfigurerAdapter的类上加@EnableGlobalMethodSecurity注解，
 * 来判断用户对某个控制层的方法是否具有访问权限,使用表达式时间方法级别的安全性的4个注解可用
 * <p>
 * EnableWebSecurity完成的工作便是加载了WebSecurityConfiguration，AuthenticationConfiguration这两个核心配置类，
 * 也就此将spring security的职责划分为了配置安全信息，配置认证信息两部分。
 * <p>
 * csrf:这是一个web应用安全的问题，CSRF（Cross-site request forgery跨站请求伪造，也被称为“One Click Attack” 或者Session Riding，攻击方通过伪造用户请求访问受信任站点。
 * 我们知道，客户端与服务端在基于http协议在交互的数据的时候，由于http协议本身是无状态协议，后来引进了cookie的 方式进行记录服务端和客户端的之间交互的状态和标记。cookie里面
 * 一般会放置服务端生成的session id（会话ID）用来识别客户端访问服务端过 程中的客户端的身份标记。
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private LoginMapper loginMapper;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()// 由于使用的是JWT，我们这里不需要csrf
                .disable().authorizeRequests()
                .antMatchers("/favicon.ico", "/css/**", "/common/**", "/js/**", "/images/**", "/captcha.jpg", "/login", "/userLogin", "/login-error").permitAll()
                .antMatchers("/register.action","/login.action").permitAll().and().formLogin().loginPage("/login");
    }
}

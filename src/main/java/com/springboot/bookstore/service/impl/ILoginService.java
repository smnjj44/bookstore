package com.springboot.bookstore.service.impl;

import com.springboot.bookstore.bean.Customer;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author simonliang
 * @className ILoginService
 * @description
 * @date 2021/3/25 12:14 上午
 */
public interface ILoginService {
    String login(String name);

    boolean register(String realname, String nickname, String password, String mailbox, String address);

    boolean forgetPassword(String realname, String mailbox, String password);

    int rePassword(String name, String oldPasswd, String newPasswd, String reNewPasswd);

    Customer selectByCusName(String name);

    int cusRepassword(String name, String oldPasswd, String newPasswd, String reNewPasswd);

    boolean securityRegister(String realname, String nickname, String password, String mailbox, String address);

    UserDetails securityLogin(String name, String password);

    String getAuthByManName(String name);

    String getAuthByCusName(String realname);
}

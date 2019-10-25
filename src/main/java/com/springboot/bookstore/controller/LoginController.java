package com.springboot.bookstore.controller;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.springboot.bookstore.util.EncryptUtil;
import com.springboot.bookstore.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bookstore.bean.Customer;
import com.springboot.bookstore.service.LoginService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Resource
    private LoginService loginService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

//	@RequestMapping("/login")
//	public ModelAndView login(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		String pass = loginService.login(name);
//		String[] arr = pass.split("_");
//		if (arr.length != 0) {
//			if (arr[0].equals(password)) {
//				if(arr[1].equals("manager")) {
//					ModelAndView view = new ModelAndView("manager_main");
//					view.addObject("name", arr[2]);
//					session.setAttribute("manager_name", arr[2]);
//					return view;
//				}
//				if(arr[1].equals("customer")) {
//					ModelAndView view = new ModelAndView("customer_main");
//					session.setAttribute("customer_name", arr[2]);
//					Customer customer = new Customer();
//					customer=loginService.selectByCusName(arr[2]);
//					session.setAttribute("customer_cid", customer.getCid());
//					view.addObject("name", arr[2]);
//					return view;
//				}
//			}
//		}
//		ModelAndView view = new ModelAndView("login_fail");
//		return view;
//	}

//	@RequestMapping("/register")
//	public String register(String realname , String nickname , String password , String mailbox , String address) {
//		if(loginService.register(realname, nickname, password, mailbox, address)) {
//			return "index";
//		}
//		return "register_fail";
//	}

    @RequestMapping("/forgetps")
    public String forgetPassword(String realname, String mailbox, String newpassword) {
        if (loginService.forgetPassword(realname, mailbox, newpassword)) {
            return "index";
        }
        return "forgetps_fail";
    }

    @RequestMapping("/repassword")
    public String repassword(String name, String oldPasswd, String newPasswd, String reNewPasswd) {
        if (loginService.rePassword(name, oldPasswd, newPasswd, reNewPasswd) == 0) {
            return "index";
        }
        return "repass_fail";
    }

    @RequestMapping("/cusRepassword")
    public String cusRepassword(String name, String oldPasswd, String newPasswd, String reNewPasswd) {
        if (loginService.cusRepassword(name, oldPasswd, newPasswd, reNewPasswd) == 0) {
            return "index";
        }
        return "repass_fail";
    }

    @RequestMapping("/register")
    public String register(String realname, String nickname, String password, String mailbox, String address) {
        if (loginService.securityRegister(realname, nickname, password, mailbox, address)) {
            return "index";
        }
        return "register_fail";
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "name")String userName,@RequestParam(value = "password")String password,HttpSession httpSession) {
        UserDetails userDetails = loginService.securityLogin(userName, password);
        String token = jwtTokenUtil.generateToken(userDetails);
        String manName = loginService.getAuthByManName(userName);
        String cusName = loginService.getAuthByCusName(userName);
        if (token == null) {
           ModelAndView view = new ModelAndView("login_fail");
            return view;
        }
        if (manName != null){
            ModelAndView view = new ModelAndView("manager_main");
            httpSession.setAttribute("manager_name", userDetails.getUsername());
            httpSession.setAttribute("manager_token", token);
            return view;
        }
        if (cusName != null){
            ModelAndView view = new ModelAndView("customer_main");
            httpSession.setAttribute("customer_name", userDetails.getUsername());
            httpSession.setAttribute("customer_token", token);
            return view;
        }
        return null;
    }
}

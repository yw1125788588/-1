package com.imooc.wx.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登陆用户：" + name);

        return "index.html";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login.html";
    }

    @RequestMapping("/admin")
    @ResponseBody
  /*  @PreAuthorize("hasRole('ROLE_ADMIN')")*/
    @PreAuthorize("hasPermission('/admin','r')")
    public String printAdmin() {
        return "请求成功";
    }

    @RequestMapping("/admin/c")
    @ResponseBody
/*    @PreAuthorize("hasRole('ROLE_USER')")*/
    @PreAuthorize("hasPermission('/admin','c')")
    public String printUser() {
        return "拥有权限";
    }

    @RequestMapping("/login/error")
    public  void loginError(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        AuthenticationException exception =
                (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

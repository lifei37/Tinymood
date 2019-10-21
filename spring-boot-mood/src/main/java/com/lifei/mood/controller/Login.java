package com.lifei.mood.controller;

import com.lifei.mood.common.MD5Util;
import com.lifei.mood.entity.Response;
import com.lifei.mood.entity.UserInfo;
import com.lifei.mood.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class Login {

    @Autowired
    UserInfoService userInfoService;
    @PostMapping("/user/login")
    public Response login(@RequestBody UserInfo User, HttpServletRequest request){
        String password = (String) User.getPassword();
        User.setPassword(MD5Util.string2MD5(password));
        UserInfo user = userInfoService.loginUser(User);
        if(user != null){
            user.setPassword(null);
            HttpSession session = request.getSession();

            session.setAttribute("user", user);
            session.setMaxInactiveInterval(-1);
            return Response.ok("登录成功", user);
        }
        return Response.error("登录失败");
    }
}

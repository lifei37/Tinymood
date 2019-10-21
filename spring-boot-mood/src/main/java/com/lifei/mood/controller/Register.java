package com.lifei.mood.controller;

import com.lifei.mood.common.MD5Util;
import com.lifei.mood.entity.Response;
import com.lifei.mood.entity.UserInfo;
import com.lifei.mood.services.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class Register {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("hello")
    public String hello(){
        return "Hello word";
    }

    @PostMapping("hello2")
    public String hello2(int id){
        System.out.println(id + "666666666");
        return "Hello word2";
    }

    @PostMapping("/user/register")
    public Response register(@RequestBody Map Users){
        String rePassword = (String) Users.get("re_password");
        String password = (String) Users.get("password");
        String nickName = (String) Users.get("nickName");
        String userName = (String) Users.get("userName");
        System.out.println(rePassword.equals(""));
        if(rePassword.equals("")||password.equals("")||nickName.equals("")||userName.equals("")){
            return Response.error("有内容为空");
        }
        System.out.println(rePassword+"aaaaaaaaaa"+password);
        if(rePassword.equals(password)==false){
            return Response.error("两次密码不一致");
        }
        UserInfo User = new UserInfo();
        User.setPassword(MD5Util.string2MD5((String) Users.get("password")));
        User.setNickName((String) Users.get("nickName"));
        User.setUserName((String) Users.get("userName"));
        System.out.println(User.getUserName()+ User.getPassword());
        UserInfo user = userInfoService.selectUser(User);
        if(user == null){
            int resp = userInfoService.addUser(User);
            return Response.ok("注册成功");
        }
        return Response.error("注册失败,用户名重复");
    }
}

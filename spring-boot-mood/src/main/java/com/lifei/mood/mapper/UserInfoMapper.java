package com.lifei.mood.mapper;

import com.lifei.mood.controller.user.User;
import com.lifei.mood.entity.UserInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    // 添加用户
    Integer addUser(UserInfo User);
    // 查询用户
    UserInfo selectUser(UserInfo User);
    UserInfo loginUser(UserInfo User);
    // 获取用户简介
    UserInfo userDesc(int userId);
    // 更新头像
    int updateAvatar(UserInfo user);
    //更新个人信息
    int updateInfo(Map infoMap);
    //更改密码
    int updatePwd(UserInfo user);
}

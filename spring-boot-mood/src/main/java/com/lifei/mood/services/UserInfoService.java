package com.lifei.mood.services;

import com.lifei.mood.controller.user.User;
import com.lifei.mood.entity.UserInfo;
import com.lifei.mood.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserInfoService {
    @Autowired
    private UserInfoMapper userinfomapper;

    public int addUser(UserInfo User){
        Date nowTime = new Date();
        User.setAddTime(nowTime);
        User.setAvatar("moren.jpg");
        System.out.println(nowTime);
        int num = userinfomapper.addUser(User);
        return num;
    }

    public UserInfo selectUser(UserInfo User){
        UserInfo user = userinfomapper.selectUser(User);
        return user;
    }

    public UserInfo loginUser(UserInfo User){
        UserInfo user = userinfomapper.loginUser(User);
        return user;
    }

    public UserInfo userDesc(int userId){
        UserInfo user = userinfomapper.userDesc(userId);
        return user;
    }

    public int updateAvatar(UserInfo user){
        int u = userinfomapper.updateAvatar(user);
        return u;
    }

    public int updateInfo(Map infoMap){
        int u = userinfomapper.updateInfo(infoMap);
        return u;
    }

    public int updatePwd(UserInfo user){
        int u = userinfomapper.updatePwd(user);
        return u;
    }

}

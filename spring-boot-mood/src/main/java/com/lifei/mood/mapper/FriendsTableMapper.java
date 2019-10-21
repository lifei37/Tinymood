package com.lifei.mood.mapper;

import com.lifei.mood.entity.message.FriendsTable;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface FriendsTableMapper {


    List<FriendsTable> getFriends(int userId);

    // 添加好友
    int userAddFriend(Map friendMap);
    int friendAddUser(Map friendMap);
}

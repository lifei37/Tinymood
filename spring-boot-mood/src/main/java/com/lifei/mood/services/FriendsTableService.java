package com.lifei.mood.services;

import com.lifei.mood.entity.message.FriendsTable;
import com.lifei.mood.mapper.FriendsTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FriendsTableService {
    @Autowired
    FriendsTableMapper friendsTableMapper;
    public List<FriendsTable> getFriends(int userId){
        List<FriendsTable> friends =  friendsTableMapper.getFriends(userId);
        return friends;
    }

    public int addFriend(Map friendMap){
        friendMap.put("addTime", new Date());
        int f = friendsTableMapper.friendAddUser(friendMap);
        int u = friendsTableMapper.userAddFriend(friendMap);
        return f;
    }
}

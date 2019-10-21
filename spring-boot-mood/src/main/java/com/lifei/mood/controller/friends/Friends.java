package com.lifei.mood.controller.friends;

import com.lifei.mood.entity.Response;
import com.lifei.mood.entity.message.FriendsTable;
import com.lifei.mood.services.FriendsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Friends {

    @Autowired
    FriendsTableService friendsTableService;

    @GetMapping("/user/friends")
    public Response getFriends(int userId){
        List<FriendsTable> friends = friendsTableService.getFriends(userId);
        return Response.ok("成功", friends);
    }

    @PostMapping("/add/friend")
    public Response addFriend(@RequestBody Map friendMap){
        int f = friendsTableService.addFriend(friendMap);
        return Response.ok("成功");
    }
}

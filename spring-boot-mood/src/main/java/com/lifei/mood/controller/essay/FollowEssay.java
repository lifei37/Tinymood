package com.lifei.mood.controller.essay;


import com.lifei.mood.entity.Response;
import com.lifei.mood.entity.YourFollowTable;
import com.lifei.mood.services.YourFollowTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FollowEssay {
    @Autowired
    YourFollowTableService yourFollowTableService;

    @GetMapping("/user/follow")
    public Response getFollowEssay(int userId){
        List<YourFollowTable> followEssays = yourFollowTableService.getFollowEssay(userId);
        return Response.ok("成功",followEssays);
    }

    @GetMapping("/user/follow/list")
    public Response getFollowList(int userId){
        List<YourFollowTable> followList = yourFollowTableService.getFollowList(userId);
        return Response.ok("成功",followList);
    }

    @PostMapping("/add/follow")
    public Response addFollow(@RequestBody Map followMap){
        System.out.println(followMap);
       try {
           int y = yourFollowTableService.addFollow(followMap);

       }catch (Exception e){
           return Response.error("不成功");
       }
        return Response.ok("成功");
    }

}

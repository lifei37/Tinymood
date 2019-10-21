package com.lifei.mood.controller.essay;

import com.lifei.mood.entity.InformalEssay;
import com.lifei.mood.entity.Response;
import com.lifei.mood.entity.UserInfo;
import com.lifei.mood.services.InformalEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Essay {
    @Autowired
    InformalEssayService informalEssayService;

    @GetMapping("/user/essays")
    public Response getEssays(UserInfo user){
        if(user.getId()==0){
            List<InformalEssay> essays = informalEssayService.getEssays();
            return Response.ok("成功",essays);
        }else {
            List<InformalEssay> personEssays = informalEssayService.getPersonEssays(user);
            return Response.ok("成功",personEssays);
        }

    }
    @PostMapping("/user/postessay")
    public Response addEssay(@RequestBody InformalEssay essay){
        int i = informalEssayService.addEssay(essay);
        return Response.ok("成功");
    }

    @PostMapping("/user/getessaycount")
    public Response countEssay(@RequestBody InformalEssay essay){
        int essayCount = informalEssayService.countEssay(essay);
        return Response.ok("成功",essayCount);
    }

    @GetMapping("/essay/top")
    public Response getHeatTop10(){
        List<InformalEssay> top10Essay = informalEssayService.getHeatTop10();
        return Response.ok("成功", top10Essay);
    }
}

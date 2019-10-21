package com.lifei.mood.controller.essay;

import com.lifei.mood.entity.AgreeTable;
import com.lifei.mood.entity.Response;
import com.lifei.mood.services.AgreeTableService;
import com.lifei.mood.services.InformalEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ClickAgree {
    @Autowired
    AgreeTableService agreeTableService;
    @Autowired
    InformalEssayService informalEssayService;
    @PostMapping("/user/agree")
    public Response getAgreeTable(@RequestBody AgreeTable Agree){
        AgreeTable agreetable = agreeTableService.getAgreeTable(Agree);
        //还有一种用户从未点赞过的情况还要加纪录
        if(agreetable==null){
            //添加点赞记录
            Agree.setAddTime(new Date());
            Agree.setIsActive(1);
            int i = agreeTableService.addIsActiveAgree(Agree);
            //增加点赞记录后，随笔表点赞数+1
            if(i==1){
                int num = informalEssayService.addAgree(Agree.getEssayId());
            }
            return new Response(200,"增加点赞数",null);
        }else {
            if(agreetable.getIsActive()==0){
                int num = informalEssayService.addAgree(agreetable.getEssayId());
                if(num==1){
                    //要改变一下点赞状态
                    int i = agreeTableService.isActiveAgree(Agree);
                }
                return new Response(200,"增加点赞数",null);
            }else if(agreetable.getIsActive()==1){
                int num = informalEssayService.subAgree(agreetable.getEssayId());
                if(num==1){
                    //要改变一下点赞状态
                    int i = agreeTableService.disActiveAgree(Agree);
                }
                return new Response(300,"减少点赞数",null);

            }else {
                return new Response(500,"发生错误",null);
            }
        }

    }
}

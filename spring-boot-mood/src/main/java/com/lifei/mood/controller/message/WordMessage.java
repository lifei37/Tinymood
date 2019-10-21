package com.lifei.mood.controller.message;

import com.lifei.mood.entity.Response;
import com.lifei.mood.entity.message.PersonMessageTable;
import com.lifei.mood.entity.message.WordMessageTable;
import com.lifei.mood.services.PersonMessageTableService;
import com.lifei.mood.services.WordMessageTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WordMessage {
    @Autowired
    WordMessageTableService wordMessageTableService;
    @Autowired
    PersonMessageTableService personMessageTableService;

    @GetMapping("/message/All")
    public Response selectWordMessage(int id){
        Map<String, Object> map = new HashMap<>();
        map.put("userId", id);
        List<WordMessageTable> wordMsgs =  wordMessageTableService.selectWordMessage(map);
        return Response.ok("成功", wordMsgs);
    }
// 对查询和好友消息的接口！！！！！！！！！！！！！！！！！！！！！！！！！！！
    @GetMapping("/message/person")
    public Response selectYourMessage(PersonMessageTable personMessage){
        List<PersonMessageTable> yourMsgs =  personMessageTableService.getYourMsg(personMessage);
        return Response.ok("成功", yourMsgs);
    }
}

package com.lifei.mood.controller.message;

import com.lifei.mood.entity.Response;
import com.lifei.mood.entity.UserInfo;
import com.lifei.mood.entity.message.PersonMessageTable;
import com.lifei.mood.services.PersonMessageTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Contacts {
    @Autowired
    PersonMessageTableService personMessageTableService;

    @GetMapping("/message/contacts")
    public Response getContacts(UserInfo user){
        List<PersonMessageTable> contacts = personMessageTableService.getContacts(user);
        return Response.ok("成功",contacts);
    }


//    public Response getMsgData(){
//
//    }
}

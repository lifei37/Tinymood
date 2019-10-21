package com.lifei.mood.services;

import com.lifei.mood.entity.UserInfo;
import com.lifei.mood.entity.message.PersonMessageTable;
import com.lifei.mood.mapper.PersonMessageTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PersonMessageTableService {
    @Autowired
    PersonMessageTableMapper personMessageTableMapper;
    public List<PersonMessageTable> getContacts(UserInfo user){
        List<PersonMessageTable> contacts = personMessageTableMapper.getContacts(user);
        return contacts;
    }

    public List<PersonMessageTable> getYourMsg(PersonMessageTable personMessage){
        List<PersonMessageTable> yourmsgs = personMessageTableMapper.getYourMsg(personMessage);
        return yourmsgs;
    }
    public int insertPersonMessage(Map map1){
        map1.put("sendTime", new Date());
        int p = personMessageTableMapper.insertPersonMessage(map1);
        return p;
    }
}

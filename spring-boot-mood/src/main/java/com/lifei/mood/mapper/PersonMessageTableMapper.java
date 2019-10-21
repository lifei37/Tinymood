package com.lifei.mood.mapper;

import com.lifei.mood.entity.UserInfo;
import com.lifei.mood.entity.message.PersonMessageTable;

import java.util.List;
import java.util.Map;

public interface PersonMessageTableMapper {
    List<PersonMessageTable> getContacts(UserInfo user);
    // 查询对特定用户的聊天记录
    List<PersonMessageTable> getYourMsg(PersonMessageTable personMessage);
    // 插入个人消息
    int insertPersonMessage(Map map1);
}

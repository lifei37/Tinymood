package com.lifei.mood.mapper;

import com.lifei.mood.entity.message.WordMessageTable;

import java.util.List;
import java.util.Map;

public interface WordMessageTableMapper {
    int insertWordMessage(Map map1);
    //查询登录后的世界消息
    List<WordMessageTable> selectWordMessage(Map map);
}

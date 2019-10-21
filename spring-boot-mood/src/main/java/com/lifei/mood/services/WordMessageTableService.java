package com.lifei.mood.services;

import com.lifei.mood.entity.message.WordMessageTable;
import com.lifei.mood.mapper.WordMessageTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class WordMessageTableService {
    @Autowired
    WordMessageTableMapper wordMessageTableMapper;
    public int insertWordMessage(Map map1){
        map1.put("sendTime", new Date());
        int w = wordMessageTableMapper.insertWordMessage(map1);
        return w;
    }
    public List<WordMessageTable> selectWordMessage(Map map){
        List<WordMessageTable> msgs = wordMessageTableMapper.selectWordMessage(map);
        return msgs;
    }
}

package com.lifei.mood.services;

import com.lifei.mood.entity.AgreeTable;
import com.lifei.mood.mapper.AgreeTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreeTableService {
    @Autowired
    AgreeTableMapper agreeTableMapper;
    public AgreeTable getAgreeTable(AgreeTable Agree){
        AgreeTable agreetable = agreeTableMapper.getAgreeTable(Agree);
        return agreetable;
    }
    public int isActiveAgree(AgreeTable Agree){
        int i = agreeTableMapper.isActiveAgree(Agree);
        return i;
    }
    public int disActiveAgree(AgreeTable Agree){
        int i = agreeTableMapper.disActiveAgree(Agree);
        return i;
    }
    public int addIsActiveAgree(AgreeTable Agree){
        int i = agreeTableMapper.addIsActiveAgree(Agree);
        return i;
    }
}

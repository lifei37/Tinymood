package com.lifei.mood.mapper;

import com.lifei.mood.entity.AgreeTable;

public interface AgreeTableMapper {
    AgreeTable getAgreeTable(AgreeTable Agree);
    //改变点赞状态
    int isActiveAgree(AgreeTable Agree);
    int disActiveAgree(AgreeTable Agree);
    // 添加点赞记录
    int addIsActiveAgree(AgreeTable Agree);
}

package com.lifei.mood.mapper;

import com.lifei.mood.entity.CommentTable;
import com.lifei.mood.entity.InformalEssay;
import com.lifei.mood.entity.UserInfo;

import java.util.List;

public interface InformalEssayMapper {
    // 获取心情详情信息
    List<InformalEssay> getEssays();
    // 增加点赞数
    int addAgree(int essayId);
    // 减少点赞数
    int subAgree(int essayId);
    //增加评论数
    int addCommentNum(CommentTable comment);
    // 取指定用户的心情
    List<InformalEssay> getPersonEssays(UserInfo user);
    // 添加心情
    int addEssay(InformalEssay essay);
    //查询心情的数量
    int countEssay(InformalEssay essay);
    //获取心情热度前十的心情，目前按照点赞数排序，后面根据点赞评论算法排序
    List<InformalEssay> getHeatTop10();
}

package com.lifei.mood.mapper;

import com.lifei.mood.entity.YourFollowTable;

import java.util.List;
import java.util.Map;

public interface YourFollowTableMapper {
    List<YourFollowTable> getFollowEssay(int userId);
    // 获取关注人列表
    List<YourFollowTable> getFollowList(int userId);
    // 添加关注人
    int addFollow(Map followMap);
}

package com.lifei.mood.services;

import com.lifei.mood.entity.YourFollowTable;
import com.lifei.mood.mapper.YourFollowTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class YourFollowTableService {

    @Autowired
    YourFollowTableMapper yourFollowTableMapper;
    public List<YourFollowTable> getFollowEssay(int userId){
        List<YourFollowTable> followEssays =  yourFollowTableMapper.getFollowEssay(userId);
        return followEssays;
    }

    public List<YourFollowTable> getFollowList(int userId){
        List<YourFollowTable> followList =  yourFollowTableMapper.getFollowList(userId);
        return followList;
    }

    public int addFollow(Map followMap){
        followMap.put("followTime", new Date());
        int y = yourFollowTableMapper.addFollow(followMap);
        return y;
    }

}

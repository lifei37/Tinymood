package com.lifei.mood.services;

import com.lifei.mood.entity.CommentTable;
import com.lifei.mood.entity.InformalEssay;
import com.lifei.mood.entity.UserInfo;
import com.lifei.mood.mapper.InformalEssayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InformalEssayService {

    @Autowired
    InformalEssayMapper informalessaymapper;
    public List<InformalEssay> getEssays(){
        List<InformalEssay> essays = informalessaymapper.getEssays();
        return essays;
    }
    public int addAgree(int essayId){
        int num = informalessaymapper.addAgree(essayId);
        return num;
    }
    public int subAgree(int essayId){
        int num = informalessaymapper.subAgree(essayId);
        return num;
    }
    public int addCommentNum(CommentTable comment){
        int i = informalessaymapper.addCommentNum(comment);
        return i;
    }
    public List<InformalEssay> getPersonEssays(UserInfo user){
        List<InformalEssay> personEssays = informalessaymapper.getPersonEssays(user);
        return personEssays;
    }
    public int addEssay(InformalEssay essay){
        essay.setPublishTime(new Date());
        int i =informalessaymapper.addEssay(essay);
        return i;
    }
    public int countEssay(InformalEssay essay){
        int count = informalessaymapper.countEssay(essay);
        return count;
    }
    public List<InformalEssay> getHeatTop10(){
        List<InformalEssay> top10Essays = informalessaymapper.getHeatTop10();
        return top10Essays;
    }
}

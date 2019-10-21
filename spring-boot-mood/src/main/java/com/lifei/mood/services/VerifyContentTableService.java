package com.lifei.mood.services;

import com.lifei.mood.entity.VerifyContentTable;
import com.lifei.mood.mapper.VerifyContentTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class VerifyContentTableService {
    @Autowired
    VerifyContentTableMapper verifyContentTableMapper;

    public int addVerifyContent(Map verifyMap){
        verifyMap.put("sendTime", new Date());
        int v = verifyContentTableMapper.addVerifyContent(verifyMap);
        return v;
    }

    public List<VerifyContentTable> getVerifyContents(int userId){
        List<VerifyContentTable> verifycontents= verifyContentTableMapper.getVerifyContents(userId);
        return verifycontents;
    }
}

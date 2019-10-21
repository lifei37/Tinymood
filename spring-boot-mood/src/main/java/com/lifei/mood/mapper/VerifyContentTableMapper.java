package com.lifei.mood.mapper;

import com.lifei.mood.controller.verify.VerifyContent;
import com.lifei.mood.entity.VerifyContentTable;

import java.util.List;
import java.util.Map;

public interface VerifyContentTableMapper {
    //添加验证信息
    int addVerifyContent(Map verifyMap);
    // 查看自己的haoyou验证信息
    List<VerifyContentTable> getVerifyContents(int userId);
}

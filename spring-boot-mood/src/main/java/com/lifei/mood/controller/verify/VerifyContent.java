package com.lifei.mood.controller.verify;


import com.lifei.mood.entity.Response;
import com.lifei.mood.entity.VerifyContentTable;
import com.lifei.mood.services.VerifyContentTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class VerifyContent {
    @Autowired
    VerifyContentTableService verifyContentTableService;

    @PostMapping("/verify/content")
    public Response addVerifyContent(@RequestBody Map verifyMap){
        int v = verifyContentTableService.addVerifyContent(verifyMap);
        return Response.ok("成功");
    }

    @GetMapping("/verify/content/list")
    public Response getVerifyContents(int userId){
        List<VerifyContentTable> verifycontents = verifyContentTableService.getVerifyContents(userId);
        return Response.ok("成功", verifycontents);
    }
}

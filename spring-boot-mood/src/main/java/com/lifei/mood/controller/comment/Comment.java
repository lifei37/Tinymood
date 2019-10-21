package com.lifei.mood.controller.comment;

import com.lifei.mood.entity.CommentTable;
import com.lifei.mood.entity.Response;
import com.lifei.mood.services.CommentTableService;
import com.lifei.mood.services.InformalEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Comment {
    @Autowired
    CommentTableService commentTableService;
    @Autowired
    InformalEssayService informalEssayService;
    @GetMapping("/user/comment")
    public Response getComments(int essayId){
        System.out.println(essayId+"===============");
        List<CommentTable> comments = commentTableService.getComments(essayId);
        return Response.ok("成功", comments);
    }

    @PostMapping("/user/postcomment")
    public Response addComment(@RequestBody CommentTable comment){
        int c = commentTableService.addComment(comment);
        int i = informalEssayService.addCommentNum(comment);
        return Response.ok("添加成功");
    }
}

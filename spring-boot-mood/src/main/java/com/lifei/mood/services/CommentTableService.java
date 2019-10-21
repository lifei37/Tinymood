package com.lifei.mood.services;

import com.lifei.mood.entity.CommentTable;
import com.lifei.mood.mapper.CommentTableMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentTableService {
    @Autowired
    CommentTableMapper commentTableMapper;
    public List<CommentTable> getComments(int essayId){
        List<CommentTable> comments = commentTableMapper.getComments(essayId);
        return comments;
    }
    public int addComment(CommentTable comment){
        comment.setAddTime(new Date());
        int c =commentTableMapper.addComment(comment);
        return c;
    }
}

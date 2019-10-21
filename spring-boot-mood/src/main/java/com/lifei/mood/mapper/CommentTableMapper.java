package com.lifei.mood.mapper;

import com.lifei.mood.entity.CommentTable;

import java.util.List;

public interface CommentTableMapper {
    List<CommentTable> getComments(int essayId);
    //添加评论
    int addComment(CommentTable comment);
}

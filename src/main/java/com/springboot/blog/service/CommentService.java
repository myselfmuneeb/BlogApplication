package com.springboot.blog.service;

import com.springboot.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(Long postId, CommentDto commentDto);
    List<CommentDto> getAllCommentsByPostId(Long postId);
    CommentDto getCommentById(Long commentId, Long postId);
    CommentDto updateComment(Long commentId, Long postId, CommentDto commentDto);
    void deleteCommentById(Long commentId, Long postId);
}

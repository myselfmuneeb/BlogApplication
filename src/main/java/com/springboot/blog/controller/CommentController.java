package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    // creating comment
    @PostMapping("{postId}")
    public ResponseEntity<CommentDto> createComment(@PathVariable("postId") long postId,
                                                    @Valid @RequestBody CommentDto commentDto)
    {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    //getting all comments by a post id
    @GetMapping("/get/by/post/{postId}")
    public ResponseEntity<List<CommentDto>> getAllCommentsByPostId(@PathVariable("postId") long postId)
    {
        return ResponseEntity.ok((commentService.getAllCommentsByPostId(postId)));
    }

    //getting comments by comment and post id
    @GetMapping("/get/{commentId}/{postId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable("commentId") Long commentId,
                                                     @PathVariable("postId") Long postId)
    {
        return ResponseEntity.ok((commentService.getCommentById(commentId, postId)));
    }

    //update comment by comment and post id
    @PutMapping("/update/{commentId}/{postId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable("commentId") Long commentId,
                                                    @PathVariable("postId") Long postId,
                                                    @Valid @RequestBody CommentDto commentDto)
    {
        return ResponseEntity.ok((commentService.updateComment(commentId, postId, commentDto)));
    }

    //Deleting comment
    @DeleteMapping("/delete/{commentId}/{postId}")
    public ResponseEntity<String> deleteCommentById(@PathVariable("commentId") Long commentId,
                                                    @PathVariable("postId") Long postId)
    {
        commentService.deleteCommentById(commentId, postId);
        return new ResponseEntity<>("Comment is deleted", HttpStatus.OK);
    }

}

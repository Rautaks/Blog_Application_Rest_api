package com.Akshayblog.Services;

import com.Akshayblog.Payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	
	void deleteComment(Integer commentId);
	

}

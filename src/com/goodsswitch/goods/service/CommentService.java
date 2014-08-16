package com.goodsswitch.goods.service;

import java.util.List;

import com.goodsswitch.goods.model.pojo.CommentVO;

public interface CommentService {
	
	public CommentVO insert(CommentVO commentVO);
	
	public List<CommentVO> getComByGoodsPK(int pk); 
	
	public List<CommentVO> getComByProPK(int pk);
	
	public List<CommentVO> findByPage(int pk , int start , int size);
	
	public int getCount(int pk);
}

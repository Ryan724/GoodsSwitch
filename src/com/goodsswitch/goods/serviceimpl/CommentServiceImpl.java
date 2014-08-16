package com.goodsswitch.goods.serviceimpl;

import java.util.List;

import com.goodsswitch.goods.model.dao.CommentDAO;
import com.goodsswitch.goods.model.pojo.CommentVO;
import com.goodsswitch.goods.service.CommentService;

public class CommentServiceImpl implements CommentService{

	private CommentDAO commentDAO;
	
	@Override
	public CommentVO insert(CommentVO commentVO) {
		// TODO Auto-generated method stub
		return commentDAO.insert(commentVO);
	}

	@Override
	public List<CommentVO> getComByGoodsPK(int pk) {
		// TODO Auto-generated method stub
		return commentDAO.getComByGoodsPK(pk);
	}

	@Override
	public List<CommentVO> getComByProPK(int pk) {
		// TODO Auto-generated method stub
		return commentDAO.getComByProPK(pk);
	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	@Override
	public List<CommentVO> findByPage(int pk, int start, int size) {
		return commentDAO.findByPage(pk, start, size);
	}

	@Override
	public int getCount(int pk) {
		// TODO Auto-generated method stub
		return commentDAO.getCount(pk);
	}
	
}

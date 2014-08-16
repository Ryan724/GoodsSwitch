package com.goodsswitch.goods.model.dao;

import java.util.List;

import com.goodsswitch.goods.model.pojo.CommentVO;

/**
 * 物品评论的DAO层接口
 * @author zhangby5
 *
 */
public interface CommentDAO {

	/**
	 * 新增评论
	 * @param commentVO
	 * @return 持久化后的VO
	 */
	public CommentVO insert(CommentVO commentVO);
	
	/**
	 * 根据物品的pk查询对应的所有评论
	 * @param pk
	 * @return 对应物品的所有评论
	 */
	public List<CommentVO> getComByGoodsPK(int pk); 
	
	/**
	 * 根据人员的pk查询对应的所有评论
	 * @param pk
	 * @return 对应人员的所有评论
	 */
	public List<CommentVO> getComByProPK(int pk); 
	
	/**
	 * 评论的分页处理
	 * @param pk
	 * @param start 开始值 
	 * @param size 查询的数量
	 * @return
	 */
	public List<CommentVO> findByPage(int pk ,final int start , final int size);

	/**
	 * 获取对应pk的评论数量
	 * @param pk
	 * @return
	 */
	public int getCount(int pk);
}

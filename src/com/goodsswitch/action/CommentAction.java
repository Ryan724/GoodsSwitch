package com.goodsswitch.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.goodsswitch.eunm.CutPage;
import com.goodsswitch.exception.GSException;
import com.goodsswitch.goods.model.pojo.CommentVO;
import com.goodsswitch.goods.service.CommentService;
import com.goodsswitch.goods.service.GoodsService;
import com.goodsswitch.tool.DateUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 评论Action类
 * 
 * @author zhangby5
 * 
 */
public class CommentAction extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;
	private CommentVO commentVO = new CommentVO();
	private CommentService commentService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String pk_goods;
	private GoodsService goodsService;

	public String insert() throws GSException {
		commentVO.setComdate(DateUtils.getTime());
		commentVO.setPk_goods(Integer.parseInt(request.getParameter("pk_goods")));
		commentVO.setMessage(request.getParameter("message"));
		commentVO.setPk_promulgator(1);
		commentVO.setDr(0);
		dataMap.put("value",  goodsService.getGoodsDetailsByPk(commentVO.getPk_goods()));
		commentService.insert(commentVO);
		dataMap.put("comment", commentVO);
		return SUCCESS;
	}
	
	public String showMore(){
		String pk = request.getParameter("pk_goods");
		String start = request.getParameter("start");
		List<CommentVO> list = commentService.findByPage(Integer.parseInt(pk),Integer.parseInt(start),CutPage.PAGE_SIZE);
		dataMap.put("comment", list);
		return SUCCESS;
	}

	public CommentVO getCommentVO() {
		return commentVO;
	}

	public void setCommentVO(CommentVO commentVO) {
		this.commentVO = commentVO;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getPk_goods() {
		return pk_goods;
	}

	public void setPk_goods(String pk_goods) {
		this.pk_goods = pk_goods;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
}

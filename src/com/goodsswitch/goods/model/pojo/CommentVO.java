package com.goodsswitch.goods.model.pojo;

public class CommentVO {
	/**
	 * 评论pk
	 */
	private int pk_comid;
	
	/**
	 * 物品pk
	 */
	private int pk_goods;
	
	/**
	 * 消息发布者pk
	 */
	private int  pk_promulgator;

	/**
	 * 评论内容
	 */
	private String message;
	
	/**
	 * 评论日期
	 */
	private String comdate;
	
	/**
	 * dr
	 */
	private int dr;

	public int getPk_comid() {
		return pk_comid;
	}

	public void setPk_comid(int pk_comid) {
		this.pk_comid = pk_comid;
	}

	public int getPk_goods() {
		return pk_goods;
	}

	public void setPk_goods(int pk_goods) {
		this.pk_goods = pk_goods;
	}

	public int getPk_promulgator() {
		return pk_promulgator;
	}

	public void setPk_promulgator(int pk_promulgator) {
		this.pk_promulgator = pk_promulgator;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getComdate() {
		return comdate;
	}

	public void setComdate(String comdate) {
		this.comdate = comdate;
	}

	public int getDr() {
		return dr;
	}

	public void setDr(int dr) {
		this.dr = dr;
	}
	
}

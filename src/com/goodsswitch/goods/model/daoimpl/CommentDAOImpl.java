package com.goodsswitch.goods.model.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.goodsswitch.goods.model.dao.CommentDAO;
import com.goodsswitch.goods.model.pojo.CommentVO;

public class CommentDAOImpl extends HibernateDaoSupport implements CommentDAO {

	@Override
	public CommentVO insert(CommentVO commentVO) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(commentVO);
		return commentVO;
	}

	@Override
	public List<CommentVO> getComByGoodsPK(int pk) {
		// TODO Auto-generated method stub
		List<CommentVO> list = this.getHibernateTemplate().find(
				"from com.goodsswitch.goods.model.pojo.CommentVO where pk_goods = "
						+ pk);
		return list;
	}

	@Override
	public List<CommentVO> getComByProPK(int pk) {
		// TODO Auto-generated method stub
		List<CommentVO> list = this.getHibernateTemplate().find(
				"from com.goodsswitch.goods.model.pojo.CommentVO where pk_promulgator = " + pk);
		return list;
	}

	public List<CommentVO> findByPage(int pk ,int start , int size){
		final String sql = "from com.goodsswitch.goods.model.pojo.CommentVO where pk_goods = " + pk +"order by comdate desc";
		Session session = getSession(); 
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult(start);  
		q.setMaxResults(size);
		return q.list();
	}

	@Override
	public int getCount(int pk) {
		// TODO Auto-generated method stub
		List<CommentVO> list = this.getHibernateTemplate().find(
				"from com.goodsswitch.goods.model.pojo.CommentVO where pk_goods = "
						+ pk);
		return list.size();
	}
}

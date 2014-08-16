package com.goodsswitch.goods.model.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.goodsswitch.goods.model.dao.GoodsDAO;
import com.goodsswitch.goods.model.pojo.Goods;

public class GoodsDAOImpl extends HibernateDaoSupport implements GoodsDAO {
    @Override
    public Goods insert_goods(Goods goods) {
       this.getHibernateTemplate().save(goods);
        return goods;
    }
    @SuppressWarnings("unchecked")
    public int getMaxPK(){
        Integer maxId = null;
        List<Goods> list =list=this.getHibernateTemplate().find("from Goods where pk_goods =(select max(pk_goods) from Goods))");
        try{
            maxId=(Integer) list.get(0).getPk_goods();
        }catch(Exception e){
            maxId=0;
        }
         return  maxId;
    }
    @Override
    public List getAllGoods() {
        List<Goods> list=this.getHibernateTemplate().find("select new map(g.pk_goods as pk , g.isswitch as isswitch,g.pk_promulgator as promulgator,g.name as name,g.price as price ,g.validdays as validdays,g.img1 as img1) from Goods g");
        return list;
    }
    public List getGoodsDetailsByPk(int pk){
        StringBuffer hbl =new StringBuffer();
        hbl.append("select new map(");
        hbl.append("g.pk_goods as pk ").append(",g.name as name").append(",g.price as price ").append(",g.validdays as validdays").append(",g.description as description");
        hbl.append(" ,g.starttime as starttime").append(" , g.validdays as validdays").append(" , g.isswitch as isswitch").append(" , g.recency as recency").append(",g.pk_promulgator as promulgator");
        hbl.append(",g.img1 as img1").append(",g.img2 as img2").append(",g.img3 as img3").append(",g.img4 as img4");
        hbl.append(") from Goods g where g.pk_goods =?");
        List<Goods> list=this.getHibernateTemplate().find(hbl.toString(),pk);
        System.out.println(list);
        return list;
    }
}

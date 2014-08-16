package com.goodsswitch.goods.model.daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.goodsswitch.goods.model.dao.ImageDAO;
import com.goodsswitch.goods.model.pojo.Goods;
import com.goodsswitch.goods.model.pojo.Image;

public class ImageDAOImpl extends HibernateDaoSupport  implements ImageDAO{

    @Override
    public int getMaxPK() {
        Integer maxId = null;
        List<Image> list =this.getHibernateTemplate().find("from Image where pk_img =(select max(pk_img) from Image))");
        try{
            maxId=(Integer) list.get(0).getPk_img();
        }catch(Exception e){
            maxId=0;
        }
         return  maxId;
    }

    @Override
    public Image insert_img(Image img) {
        this.getHibernateTemplate().save(img);
        return img;
    }

    @Override
    public String getUrl(int img_id) {
        List<Image> list=this.getHibernateTemplate().find("from Image where pk_img ="+img_id);
        String url =list.get(0).getImgUrl();
        return url;
    }

}

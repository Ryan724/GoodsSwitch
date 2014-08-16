package com.goodsswitch.goods.model.dao;

import java.util.List;

import com.goodsswitch.goods.model.pojo.Goods;

public interface GoodsDAO {
    public Goods insert_goods(Goods goods );
    public int getMaxPK();
    public List getAllGoods();
    public List getGoodsDetailsByPk(int pk); 
}

package com.goodsswitch.goods.serviceimpl;

import java.util.List;

import com.goodsswitch.exception.GSException;
import com.goodsswitch.goods.model.dao.GoodsDAO;
import com.goodsswitch.goods.model.pojo.Goods;
import com.goodsswitch.goods.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDAO goodsDao;

    public GoodsDAO getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDAO goodsDao) {
        this.goodsDao = goodsDao;
    }

    public Goods insert_goods(Goods goods ) throws GSException {
        goods=goodsDao.insert_goods(goods);
        return goods;
    }
    public int getMaxPK() throws GSException {
        return goodsDao.getMaxPK();
    }
    public List getAllGoods()  throws GSException{
        return goodsDao.getAllGoods();
    }
    public List getGoodsDetailsByPk(int pk) throws GSException{
        return goodsDao.getGoodsDetailsByPk(pk);
    }
}


package com.goodsswitch.goods.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.goodsswitch.exception.GSException;
import com.goodsswitch.goods.model.pojo.Goods;

public interface GoodsService {
    @Transactional
    public Goods insert_goods(Goods goods ) throws GSException;
    public int getMaxPK() throws GSException;
    public List getAllGoods()  throws GSException;
    public List getGoodsDetailsByPk(int pk) throws GSException;

}

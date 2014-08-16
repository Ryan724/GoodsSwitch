package com.goodsswitch.goods.model.dao;

import com.goodsswitch.goods.model.pojo.Image;

public interface ImageDAO {
    public int getMaxPK();
    public Image insert_img(Image img );
    public String getUrl(int img_id);
}

package com.goodsswitch.goods.service;

import com.goodsswitch.goods.model.pojo.Image;

public interface ImageService {
    public int getMaxPK();
    public Image insert_img(Image img );
    public String getUrl(int img_id);
}

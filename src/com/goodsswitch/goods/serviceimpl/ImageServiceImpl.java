package com.goodsswitch.goods.serviceimpl;

import com.goodsswitch.goods.model.dao.ImageDAO;
import com.goodsswitch.goods.model.pojo.Image;
import com.goodsswitch.goods.service.ImageService;

public class ImageServiceImpl  implements ImageService{
    private ImageDAO imageDao;


    @Override
    public int getMaxPK() {
        return imageDao.getMaxPK();
    }

    @Override
    public Image insert_img(Image img) {
        return imageDao.insert_img(img);
    }

    @Override
    public String getUrl(int img_id) {
        return imageDao.getUrl(img_id);
    }

    public ImageDAO getImageDao() {
        return imageDao;
    }

    public void setImageDao(ImageDAO imageDao) {
        this.imageDao = imageDao;
    }

}

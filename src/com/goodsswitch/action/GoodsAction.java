package com.goodsswitch.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.goodsswitch.exception.GSException;
import com.goodsswitch.goods.model.pojo.Goods;
import com.goodsswitch.goods.service.GoodsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GoodsAction  extends ActionSupport implements ModelDriven<Goods>,ServletRequestAware{
    private GoodsService goodsService;
    private HttpServletRequest request;
    private Goods goods =new Goods();
    Map<String, String> dataMap = new HashMap<String, String>();
    @SuppressWarnings("deprecation")
    public String addGoods() throws Exception{
       //物品初始化
        this.goodsInit(goods);
        System.out.println("上传开始。。");
        try {
            goodsService.insert_goods(goods);
           request.getSession().setAttribute("oid", goods.getPk_promulgator());
        } catch (GSException e) {
            e.printStackTrace();
        }
      
        return SUCCESS;
    }
    
    public void goodsInit(Goods goods){
        goods.setStarttime( (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(new  Date()));
        String switchgoods=goods.getSwitchgoods();
        if(switchgoods==null){
            goods.setIsswitch(true);
        }else  if(switchgoods.equals("on")){
            goods.setIsswitch(false);
        }
        if(goods.getType().endsWith("求购")){
            goods.setIsswitch(false);
        }
    }
    
    @Override
    public Goods getModel() {
        if(goods==null){
            goods =new Goods();
        }
        return goods;
    }
    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }
    public Map getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
        
    }

}

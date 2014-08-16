package com.goodsswitch.goods.model.pojo;
public class Goods {
   private int  pk_goods;      //    物品主键
   private String  pk_promulgator;      // 消息发布者
   private String type;      //  信息类型
   private String name;      //    物品名称
   private String price;      //    转让价格
   private String validdays;      //   有效时间
   private String starttime;      //    发布时间
   private int dr;                 //是否删除   0:可用，1：删除
   private String  img1;      //    物品图片1
   private String  img2;      //    物品图片2
   private String  img3;      //    物品图片3
   private String  img4;      //    物品图片4
   private String  recency;      //   新旧程度（全新，9，8，8成以下）
   private String description;      //    物品描述
   private boolean isswitch;      //    是否交换
   private String switchgoods;      //  想交换物品
   private boolean isexpress;      //   是否快递
public int getPk_goods() {
    return pk_goods;
}
public void setPk_goods(int pk_goods) {
    this.pk_goods = pk_goods;
}
public String getPk_promulgator() {
    return pk_promulgator;
}
public void setPk_promulgator(String pk_promulgator) {
    this.pk_promulgator = pk_promulgator;
}
public String getType() {
    return type;
}
public void setType(String type) {
    this.type = type;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public int getDr() {
    return dr;
}
public void setDr(int dr) {
    this.dr = dr;
}
public String getPrice() {
    return price;
}
public void setPrice(String price) {
    this.price = price;
}
public String getValiddays() {
    return validdays;
}
public void setValiddays(String validdays) {
    this.validdays = validdays;
}
public String getStarttime() {
    return starttime;
}
public void setStarttime(String starttime) {
    this.starttime = starttime;
}
public String getImg1() {
    return img1;
}
public void setImg1(String img1) {
    this.img1 = img1;
}
public String getImg2() {
    return img2;
}
public void setImg2(String img2) {
    this.img2 = img2;
}
public String getImg3() {
    return img3;
}
public void setImg3(String img3) {
    this.img3 = img3;
}
public String getImg4() {
    return img4;
}
public void setImg4(String img4) {
    this.img4 = img4;
}
public String getRecency() {
    return recency;
}
public void setRecency(String recency) {
    this.recency = recency;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public boolean isIsswitch() {
    return isswitch;
}
public void setIsswitch(boolean isswitch) {
    this.isswitch = isswitch;
}
public String getSwitchgoods() {
    return switchgoods;
}
public void setSwitchgoods(String switchgoods) {
    this.switchgoods = switchgoods;
}
public boolean isIsexpress() {
    return isexpress;
}
public void setIsexpress(boolean isexpress) {
    this.isexpress = isexpress;
}
    
}

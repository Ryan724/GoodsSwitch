package com.goodsswitch.action;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.goodsswitch.eunm.CutPage;
import com.goodsswitch.exception.GSException;
import com.goodsswitch.goods.service.CommentService;
import com.goodsswitch.goods.service.GoodsService;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAjaxAction extends ActionSupport  implements ServletRequestAware{
    private HttpServletRequest request;
    private GoodsService goodsService;
    private CommentService commentService;


    Map<String, Object> dataMap = new HashMap<String, Object>();
    @Override
    public String execute() throws GSException{
        String type = request.getParameter("type");
        String id =request.getParameter("id");
        System.out.println(type);
        if(type!=null){
            if(type.equalsIgnoreCase("goodslist")){
              dataMap.put("value",  goodsService.getAllGoods());
            }else if(type.equalsIgnoreCase("goodsdetails")){
                if(id!=null){
                    dataMap.put("value",  goodsService.getGoodsDetailsByPk(new Integer(id)));
                    dataMap.put("comment", commentService.findByPage(new Integer(id), 0, CutPage.PAGE_SIZE));
                    dataMap.put("count", commentService.getCount(new Integer(id)));
                }
            }
        }
        dataMap.put("flag", "true");
        System.out.println(dataMap);
        return SUCCESS;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
    
}

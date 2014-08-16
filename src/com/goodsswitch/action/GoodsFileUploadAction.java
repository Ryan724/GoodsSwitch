package com.goodsswitch.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.baidu.bae.api.util.BaeEnv;
import com.goodsswitch.goods.model.pojo.Image;
import com.goodsswitch.goods.service.ImageService;
import com.goodsswitch.tool.ImageUtils;
import com.goodsswitch.tool.SaveBucketUtils;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsFileUploadAction  extends ActionSupport   implements ServletRequestAware{
    private HttpServletRequest request;
    private File file;
    private String fileFileName;
    private String fileFileContentType;
    private ImageService imageService;
    Map<String, Object> dataMap = new HashMap<String, Object>();

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
    public void setFileFileContentType(String fileFileContentType) {
        this.fileFileContentType = fileFileContentType;
    }
    @SuppressWarnings("deprecation")
    public String upload() throws Exception {
        try {
           Image img =new Image();
          String suffix =fileFileName.substring(fileFileName.lastIndexOf("."));
          //图片上传至百度云
        File desFile =new File(ServletActionContext.getServletContext().getRealPath("/upload")+"/"+(imageService.getMaxPK()+1)+suffix);
        ImageUtils.scaleByFile(file, desFile, 300, 180, true);
        (new SaveBucketUtils()).putObjectByFile(desFile, "/upload/");
        String url = "http://bcs.duapp.com/goodsswitch-upload/upload/" + desFile.getName().toString();
          //图片上传本地
//          File desFile =new File(ServletActionContext.getServletContext().getRealPath("/upload")+"/"+(imageService.getMaxPK()+1)+suffix);
//          ImageUtils.scaleByFile(file, desFile, 300, 200, true);
//          String url ="http://127.0.0.1:8080/GoodsSwitch/upload/"+desFile.getPath().substring(desFile.getPath().lastIndexOf("upload")+7);
          img.setImgUrl(url);
          imageService.insert_img(img);
          dataMap.put("url", url);
          dataMap.put("flag", "true");
        } catch (Exception e) {
            dataMap.put("flag", "false");
            e.printStackTrace();
        }
        System.out.println(dataMap);
        return SUCCESS;
    }
    
    public ImageService getImageService() {
        return imageService;
    }

    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
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

}

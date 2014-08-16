package com.goodsswitch.tool;

import java.io.File;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;
import com.baidu.inf.iis.bcs.model.ObjectMetadata;
import com.baidu.inf.iis.bcs.request.PutObjectRequest;
import com.baidu.inf.iis.bcs.response.BaiduBCSResponse;

public class SaveBucketUtils {
    private String host = "bcs.duapp.com";
    private String bucket = "goodsswitch-upload";
    private String accessKey = "lBtpEXdFoOBOYu3oS6n2Ipjg";
    private String secretKey = "WmB5G4djr7aWrOhC8xXDIYGTzKROYutX";
    
    private    BaiduBCS init() {
        BCSCredentials credentials = new BCSCredentials(accessKey, secretKey);
        BaiduBCS baiduBCS = new BaiduBCS(credentials, host);
        baiduBCS.setDefaultEncoding("UTF-8"); 
        return baiduBCS;
    }
    public  void putObjectByFile(File file, String dir)
    {
        BaiduBCS baiduBCS=init();
        PutObjectRequest request = new PutObjectRequest(bucket, dir+file.getName(), file);
        ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setContentType("text/html");
        request.setMetadata(metadata);
        BaiduBCSResponse<ObjectMetadata> response = baiduBCS.putObject(request);
        ObjectMetadata objectMetadata = response.getResult();
        System.out.println("Upload file :" + file.getName());
    }

}

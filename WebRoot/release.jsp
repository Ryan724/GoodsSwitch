<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>发布交易</title>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<link href="css/release.css" rel="stylesheet"> 
<link href="css/bootstrap-switch.css" rel="stylesheet"/>
<link href="css/bootstrap-select.css" rel="stylesheet"/>
<script src="js/jquery-2.0.0.js"  type="text/javascript"></script>
<script src="js/ajaxfileupload.js"  type="text/javascript"></script>
 <script src="./js/tool.js"></script>
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
<script>
  	$(function(){
				$(".pk_promulgator").val(GetQueryString("oid"));
  	});
</script>
</head>
<body>

<div class="container" >
	<div class="btn-group btn-group-justified ">
  		<a type="button" class="transferinfo btn btn-default"> 转让信息</a>
  		<a type="button" class="askbuyinfo btn btn-default">求购信息</a>
	</div>
 	<div class="picture">
<!-- 四张图片上传   start  -->
  		<div class="form-group">
    		<div class="imgUpload">	
    		<!-- -----------------第1张------------------ -->			
    		<div id="preview_wrapper1" class="uploadfile_div">       
				<img id="preview" class="image1 img-rounded"  onload="onPreviewLoad(this)" src="http://bcs.duapp.com/goodsswitch-upload/upload/orig.jpg"/>         
			</div>     
    		<div style="visibility:hidden">
    			<input type="file" id="upload_img1" name="file"  class="uploadfile" onchange="ajaxFileUpload('upload_img1')"/>
    		</div> 
       <!-- -----------------第2张------------------ -->
        	<div id="preview_wrapper2" class="uploadfile_div">
				<img id="preview"  class="image2 img-rounded" onload="onPreviewLoad(this)" src="http://bcs.duapp.com/goodsswitch-upload/upload/orig.jpg"/>   
			</div>     
    		<div style="visibility:hidden"> 
    		<input type="file" id="upload_img2" name="file"  class="uploadfile" onchange="ajaxFileUpload('upload_img2')"/>
    		</div> 
    	<!-- -----------------第3张------------------ -->
        	<div id="preview_wrapper3" class="uploadfile_div">
				<img id="preview" class="image3 img-rounded" onload="onPreviewLoad(this)" src="http://bcs.duapp.com/goodsswitch-upload/upload/orig.jpg"/>
			</div>     
    		<div style="visibility:hidden">
    			<input type="file" id="upload_img3" name="file"  class="uploadfile" onchange="ajaxFileUpload('upload_img3')"/>
    	 	</div>
    	 <!-- -----------------第4张------------------ -->
        	<div id="preview_wrapper4" class="uploadfile_div ">
				<img id="preview" class="image4 img-rounded" onload="onPreviewLoad(this)" src="http://bcs.duapp.com/goodsswitch-upload/upload/orig.jpg"/></div>     
    		<div style="visibility:hidden">
  		  		<input type="file" id="upload_img4" name="file"  class="uploadfile" onchange="ajaxFileUpload('upload_img4')"/>
    	 	</div> 	
    	</div> <br/>  
   	</div>
   </div>
</div>
 <div class="container">  
   <div class="transfer">
	<form class="form-horizontal" action=" ${pageContext.request.contextPath }/addgoods.action" method="post" role="form">
	  <div class="form_style clearfix bg"  >
	  <ul >
	  <li>
	      <div class="input-group">
	         <div class="toggle-switch switch-large" data-on-label="同意交换" data-off-label="拒绝交换">
	                <input checked="" name=""switchgoods type="checkbox">
	          </div>
	        </div>
	 	 </li>
	    <li>
	     <div class="input-group">
	        <span class="input-group-addon">物品名称</span>
	        <input type="text" name="name" class="form-control" placeholder="Goods Name">
	     </div>
	    </li>
	    <li>
	       <div class="input-group col-xs-10">
	          <span class="input-group-addon">新旧程度</span>
	         	  <select class="selectpicker" name="recency">
	                <option>全新</option>
	                <option>九成新</option>
	                <option>八成新</option>
	                <option>八成下</option>
	              </select>
	    	</div>      
		 </li>     
	     <li>
	       <div class="input-group col-xs-10">
	          <span class="input-group-addon">有效天数</span>
	         	  <select class="selectpicker" name ="validdays">
	                <option>5天</option>
	                <option>10天</option>
	                <option>20天</option>
	                <option>30天</option>
	              </select>
	       </div>
	     </li> 
		 <li>
	     <div class="input-group">
	       <span class="input-group-addon">￥</span>
	       <input type="text" name="price" class="form-control goods-price">
	      <span class="input-group-addon">.00</span>	 </div>
	     </li>
	      <li>
	         <div class="input-group">
	            <span class="input-group-addon">物品描述</span>
	                <textarea class="form-control"  name="description" style = "font-size:72" placeholder="你老可以介绍你的物品，也可以说说你想换什么~"></textarea>
	         </div>
	      </li>
	  </ul>
	  </div>
	  <input type="hidden" name="type" value="转让">
	  <input type="hidden" name="pk_promulgator"  class="pk_promulgator"value="">
	  <input type="hidden" name="img1" class="urlimg1"value="11">
	  <input type="hidden" name="img2" class="urlimg2"value="">
	  <input type="hidden" name="img3" class="urlimg3"value="">
	  <input type="hidden" name="img4" class="urlimg4"value="">
	  <button type="submit" class="btn btn-default submit">提交了</button>
	</form>
 </div> 
   <div class="askbuy">
<form class="form-horizontal" action="${pageContext.request.contextPath }/addgoods.action" method="post" role="form">
  <div class="form_style clearfix bg" >
  <ul >
    <li>
     <div class="input-group">
        <span class="input-group-addon">物品名称</span>
        <input type="text" name="name" class="form-control" placeholder="Goods Name">
     </div>
    </li>
     <li>
       <div class="input-group col-xs-10">
          <span class="input-group-addon">有效天数</span>
         	  <select class="selectpicker"  name ="validdays">
	                <option>5天</option>
	                <option>10天</option>
	                <option>20天</option>
	                <option>30天</option>
               </select>
       </div>
     </li> 
      <li>
         <div class="input-group">
            <span class="input-group-addon">物品描述</span>
                <textarea class="form-control"   name="description" style = "font-size:72" placeholder="你老可以介绍你的物品，也可以说说你想换什么~"></textarea>
         </div>
      </li>
  </ul>
  </div>
 	 <input type="hidden" name="type" value="求购">
 	<input type="hidden" name="pk_promulgator"  class="pk_promulgator"value="">
  	 <input type="hidden" name="img1" class="urlimg1"value="">
	  <input type="hidden" name="img2" class="urlimg2"value="">
	  <input type="hidden" name="img3" class="urlimg3"value="">
	  <input type="hidden" name="img4" class="urlimg4"value="">
  <button type="submit" class="btn btn-default submit">提交了</button>
</form>
 </div> 
</div>
<script src="js/bootstrap.min.js"  type="text/javascript"></script>
<script src="js/bootstrap-switch.min.js"  type="text/javascript"></script>
<script src="js/bootstrap-select.js"  type="text/javascript"></script>
<script src="js/release.js"  type="text/javascript"></script>
</body>
</html>
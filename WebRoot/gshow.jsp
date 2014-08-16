<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
 <base href="<%=basePath%>">
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta charset="utf-8">
 <title>GOODS-SWITCH</title>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link href="css/bootstrap.css" rel="stylesheet">
 <link href="css/gshow.css" rel="stylesheet">

  <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
   <script src="./js/jquery-2.0.0.js"></script>
  <script>
  
  		var url ="/GoodsSwitch/gajax.action";
  		var data ={type : 'goodslist'};
  		$.post(url,data,function(data){
  			for(i=0;i<data.value.length;i++){
				$(".goodslist").html($(".goodslist").html()+"<div class='col-sm-6 col-md-4 '><div class='thumbnail'>"+
					"<a href='gdetails.jsp?id="+data.value[i].pk+"' title='物品名称' target='_blank' onclick=''><img class='lazy' src="+data.value[i].img1+" width='100' height='50' data-src='' >"+
					"</a><div class='caption'><a href='gdetails.jsp?id="+data.value[i].pk+"' title="+data.value[i].name+" target='_blank' onclick=''>"+data.value[i].name+"</a> <small>￥："+data.value[i].price+"</small>"+
					"<p>"+data.value[i].isswitch+"</p></div></div></div>"	); 
  			}
  	},"json");
  
</script>
</head>
<body style="">
	<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm" href="">物品交换</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="">首页</a></li>
             <li class="dropdown">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">猜猜我是谁<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="" target="_blank">起步</a>
                </li>
              </ul>
            </li>
            <li><a href="" target="_blank">很爱很爱</a></li>
          </ul>
        </div>
      </div>
    </div>


<!-- Carousel  ================================================== -->
    <div id="myCarousel" class="carousel slide">
	  <div class="carousel-inner">
        <div class="item active masthead">
          <div class="masthead-bg"></div>
        </div>
      </div>
     </div>
<!--  商品列表-->
<div class="container projects">
    <div class="row goodslist">
   
<!--  
    	<div class="col-sm-6 col-md-4 ">
	        <div class="thumbnail">
	          <a href="gdetails.jsp?id=1" title="物品名称" target="_blank" onclick="">
					<img  src="http://127.0.0.1:8080/GoodsSwitch/upload/1.jpg" width="100" height="50" data-src="" >
			  </a>
	          <div class="caption">
					<a href="gdetails.jsp?id=1" title="物品名称" target="_blank" onclick="">物品名称</a> <small>￥：50.00</small> 
					<p>接受交换 @评论@攒</p>
	          </div>
	        </div>
      </div> -->
      
</div>
</div>

      <!-- FOOTER -->
    <footer class="footer ">
		<p>这是底部</p>
    </footer>

   
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/jquery.unveil.min.js"></script><!-- 图片延迟加载 -->
    <script src="./js/jquery.scrollUp.min.js"></script>
    <script>
      $(document).ready(function(){
        $("img.lazy").unveil();

        $.scrollUp({
              scrollName: 'scrollUp', // Element ID
              topDistance: '300', // Distance from top before showing element (px)
              topSpeed: 300, // Speed back to top (ms)
              animation: 'fade', // Fade, slide, none
              animationInSpeed: 200, // Animation in speed (ms)
              animationOutSpeed: 200, // Animation out speed (ms)
              scrollText: '', // Text for element
              activeOverlay: false  // Set CSS color to display scrollUp active point, e.g '#00FFFF'
        });
      });
    </script>
	<a id="scrollUp" href="http://www.bootcss.com/#top" title="" style="position: fixed; z-index: 2147483647;"></a>
</body>
</html>
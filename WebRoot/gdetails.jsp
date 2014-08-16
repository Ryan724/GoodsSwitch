<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>物品详情</title>
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/gdetails.css" rel="stylesheet" /> 
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
<script src="js/jquery-2.0.0.js" type="text/javascript"></script>
<script src="js/gdetails.js" type="text/javascript"></script>
<script src="./js/tool.js"></script>
<script>
	$(function() {
/* 		//获取url上的参数
		function GetQueryString(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
			var r = window.location.search.substr(1).match(reg);
			if (r != null)
				return unescape(r[2]);
			return null;
		} */
	$.post("/NEUQ_Helper/stuajax.action",{openid:GetQueryString("oid")},function(data) {
		$(".promulgator").html("发布者详情："+data.msg+"(TEL:"+data.phone+")");
	});
	  var url = "/GoodsSwitch/gajax.action";
		var data = {
			type : 'goodsdetails',
			id : GetQueryString("id")
		};
		$.post(	url,data,function(data) {
							if (data.value[0].img1 != null) {
								$(".img1").attr("src", data.value[0].img1);
							}
							if (data.value[0].img2 != null&&data.value[0].img2.length>3) {
								$(".img2").attr("src", data.value[0].img2);
							} else {
								$(".img2").attr("src", data.value[0].img1);
								$(".img3").attr("src", data.value[0].img1);
								$(".img4").attr("src", data.value[0].img1);
							}
							if (data.value[0].img3 != null&&data.value[0].img3.length>3) {
								$(".img3").attr("src", data.value[0].img3);
							} else {
								$(".img3").attr("src", data.value[0].img1);
								$(".img4").attr("src", data.value[0].img2);
							}
							if (data.value[0].img4 != null&&data.value[0].img4.length>3) {
								$(".img4").attr("src", data.value[0].img4);
							} else {
								$(".img4").attr("src", data.value[0].img1);
							}
							if(data.value[0].isswitch=="false"){$(".isswitch").html("不交换");}else{$(".isswitch").html("可交换");}
							$(".name").html("物品名称："+data.value[0].name);
							$(".description").html("物品描述："+data.value[0].description);
							$(".validdays").html(data.value[0].validdays);
							$(".price").html(data.value[0].price+"元");
							$(".recency").html(data.value[0].recency);
							//$(".promulgator").html(data.value[0].pk_promulgator);
							$(".pk_goods").val(data.value[0].pk);
							$("#count").html(data.count);
							if (0 != data.comment.length) {
								
								for ( var i = 0; i < data.comment.length; i++) {
									$("table").append("<tr><td><div class='big'><div class='one clearfix'><span style='width:100%;'>"
							+ data.comment[i].pk_promulgator+ "<em>"+ data.comment[i].comdate+"</em><i style='float: right;'>"+ (i + 1)+"</i></span>"
							+"	<span class='message txt'>"+ data.comment[i].message+"</span></div></div></td></tr>");
								}
								if(3 == data.comment.length){
									$("table").append("<tr id='showmore'><td align='center'><input type='hidden' class='pk' value='"+ data.comment.length +"'><a href='javascript:;' title='显示更多' onclick='showMore()'>显示更多</a></td></tr>");
								}else{
								$("table").append("<tr id='showmore'><td  align='center'><span>没有更多</span></td></tr>");
							}
							}else{
								$("table").append("<tr id='showmore'><td align='center'><span>暂无评论</span></td></tr>");
							}
						//	$("table").append(	"<tr id='addCom'><td colspan='2'><input type='text' name='comment.pk_goods' id='comment-area' placeholder='我有话说...' autocomplete='off' style='overflow: hidden;'><button id='comment_submit' onclick='submitComment()'>评论</button></td></tr>");
						}, "json"); 
	});
</script>
</head>
<body>
<!-- 内容开始 -->
<div class="container">
	<!--物品图片的滑动展示-->
	<div class="information clearfix">
		<div id="img-slider" class="carousel slide" data-ride="carousel"
			style="width:300px;">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#img-slider" data-slide-to="0" class="active"></li>
				<li data-target="#img-slider" data-slide-to="1"></li>
				<li data-target="#img-slider" data-slide-to="2"></li>
				<li data-target="#img-slider" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" align="center">
				<div class="item active" style="width:100%;">
					<img alt="" class="img1" src="upload/1.jpg" />
					<div class="carousel-caption"></div>
				</div>
				<div class="item" style="width:100%;">
					<img alt="" class="img2" src="upload/1.jpg" />
					<div class="carousel-caption"></div>
				</div>
				<div class="item" style="width:100%;">
					<img alt="" class="img3" src="upload/1.jpg" />
					<div class="carousel-caption"></div>
				</div>
				<div class="item" style="width:100%;">
					<img alt="" class="img4" src="upload/1.jpg" />
					<div class="carousel-caption"></div>
				</div>
			</div>
			<!-- 图片滚动显示左右图标 -->
			<a class="left carousel-control" href="#img-slider" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> </a> <a
				class="right carousel-control" href="#img-slider" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span> </a>
		</div>
		<!--商品详情-->
		<div class="hr_15"></div>
		<div class="span12 clearfix">
			<span class="name">物品名称:ipad</span>
			<span class="description">物品描述 : 我想换个裤裤穿</span>
			<span class="promulgator">发布者详情: xxx(TEL:187XXX)</span>
		</div>
		<div class="down">
			<ul class="clearfix">
				<li class="recency ciecle">八成新</li>
				<li class="validdays ciecle">15天</li>
				<li class="price ciecle">2000元</li>
				<li class="isswitch ciecle">不交换</li>
				
			</ul>
		</div>
	</div>
<div class="talking">
		<div class="talking_show clearfix">
			<table style="width:100%">
			
		</table>
	</div>
	<div class="talking_txt">
	<textarea value="hello" class="comment-area fl"  id='comment-area' placeholder='我feel...' >
	   </textarea>
	   <input type="hidden" name="comment.pk_goods" class="pk_goods">
		<input type="button" id='comment_submit' onclick="submitComment()" value="评论" class="fr" >
	</div>
</div>
</div>
<script src="js/bootstrap.min.js"  type="text/javascript"></script>
</body>
</html>
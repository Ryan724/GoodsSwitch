function b() {
	h = $(window).height();
	t = $(document).scrollTop();
	if (t > h) {
		$('#gotop').fadeIn();
	} else {
		$('#gotop').fadeOut();
	}
}
$(document).ready(function(e) {
	b();
	$('#gotop').click(function() {
		$(document).scrollTop(0);
	})
});
/* 转载请保留版权信息：97站长网 www.97zzw.com */
$(window).scroll(function(e) {
	b();
})

function submitComment() {
	var url = "/GoodsSwitch/addComment.action";
	var data = {
			pk_goods:$(".pk_goods").val(),
			message:$("#comment-area").val()
	};
	$.post(url, data, function(data) {
		$("#showmore").before(
		"<tr><td><div class='big'><div class='one clearfix'><span style='width:100%;'>"
		+ data.comment.pk_promulgator+ "<em>"+ data.comment.comdate+"</em><i style='float: right;'>审核中，刷新显示</i></span>"
		+"	<span class='message txt'>"+ data.comment.message+"</span></div></div></td></tr>");

		$("#count").text(Number($("#count").text())+1);
		showTips("提交成功", 85, 1);
	}, "json");
	$("#comment-area").val('');
}

function showMore() {
	var start = $(".pk").val();
	var url = "/GoodsSwitch/showMore.action";
	var data = {
			pk_goods:$(".pk_goods").val(),
			start : start
	};
	$.post(url, data, function(data) {
		if (0 != data.comment.length) {
			
			for ( var i = 0; i < data.comment.length; i++) {
				start = Number(start) + 1;
				$("#showmore")
						.before(
								"<tr><td><div class='big'><div class='one clearfix'><span style='width:100%;'>"
								+ data.comment[i].pk_promulgator+ "<em>"+ data.comment[i].comdate+"</em><i style='float: right;'>"+start+"</i></span>"
								+"	<span class='message txt'>"+ data.comment[i].message+"</span></div></div></td></tr>");
			}
			if(3 == data.comment.length){
				$("#showmore").remove();
				$("table").append("<tr id='showmore'><td colspan='2' align='center'><input type='hidden' class='pk' value='"+ start +"'><a href='javascript:;' title='显示更多' onclick='showMore()'>显示更多</a></td></tr>");
			}else{
				$("#showmore").remove();
				$("table").append("<tr id='showmore'><td colspan='2' align='center'><span>没有更多了</span></td></tr>");
			}
		}else{
			$("#showmore").remove();
			$("table").append("<tr id='showmore'><td colspan='2' align='center'><span>没有更多了</span></td></tr>");
		}
	}, "json");
}

function showTips(tips, height, time) {
	var windowWidth = document.documentElement.clientWidth;
	var tipsDiv = '<div class="tipsClass">' + tips + '</div>';

	$('body').append(tipsDiv);
	$('div.tipsClass').css({
		'top' : height + 'px',
		'left' : (windowWidth / 2) - (tips.length * 13 / 2) + 'px',
		'position' : 'absolute',
		'padding' : '3px 5px',
		'background' : '#28B5FD',
		'font-size' : 12 + 'px',
		'margin' : '0 auto',
		'text-align' : 'center',
		'width' : 'auto',
		'color' : '#fff',
		'opacity' : '0.8'
	}).show();
	setTimeout(function() {
		$('div.tipsClass').fadeOut();
	}, (time * 1000));
}

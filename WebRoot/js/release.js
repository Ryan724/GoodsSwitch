(function($){
$('.selectpicker').selectpicker();
	 
$('.uploadfile_div').click(function(){ 
	var num=this.id.substring(this.id.length-1);
	$('#upload_img'+num).trigger('click');
});

$('.transferinfo').click(function(){
		$('.askbuy').css('display','none');
		$('.transfer').css('display','block');
});
$('.askbuyinfo').click(function(){
		$('.transfer').css('display','none');
		$('.askbuy').css('display','block');
});
})(jQuery);

function onUploadImgChange(objUpload,url){ 
	var sender=objUpload[0];
    var elementId=sender.id;
    $('.urlimg'+elementId.substring(elementId.length-1)).val(url);
	 var objPreview =$('.image'+elementId.substring(elementId.length-1));
	 objPreview.css("display","block");
	 objPreview.css("width","auto");
	 objPreview.css("height","auto");
	 objPreview.attr("src",url);
}        

function onPreviewLoad(sender){
    autoSizePreview( sender, sender.offsetWidth, sender.offsetHeight );      
}

function autoSizePreview( objPre, originalWidth, originalHeight ){  
    var zoomParam = clacImgZoomParam( 100, 100, originalWidth, originalHeight );        
    objPre.style.width = zoomParam.width + 'px';        
    objPre.style.height = zoomParam.height + 'px';        
	objPre.style.marginTop = zoomParam.top + 'px';        
    objPre.style.marginLeft = zoomParam.left + 'px';        
}              

function clacImgZoomParam( maxWidth, maxHeight, width, height ){        
    var param = { width:width, height:height, top:0, left:0 };        
    if( width>maxWidth || height>maxHeight ){        
        rateWidth = width / maxWidth;        
        rateHeight = height / maxHeight;                       
        if( rateWidth > rateHeight ){        
            param.width =  maxWidth;        
            param.height = height / rateWidth;        
        }else{        
            param.width = width / rateHeight;        
            param.height = maxHeight;        
        }        
    }                   
    param.left = (maxWidth - param.width) / 2;        
    param.top = (maxHeight - param.height) / 2;              
    return param;        
} 
function ajaxFileUpload(elementId)	{
		$('.image'+elementId.substring(elementId.length-1)).attr("src","http://bcs.duapp.com/goodsswitch-upload/upload/wait.gif");
		$.ajaxFileUpload({
			url:'uploadfile.action',
			secureuri:false,
			fileElementId:elementId,
			dataType: 'json',
			success: function (data, status){
				//alert(data.url);
				onUploadImgChange($('#'+elementId),data.url);
				return data.url;
			},
			error: function (data, status, e){
				alert(e);
			}
		}
	);
	return "";
}
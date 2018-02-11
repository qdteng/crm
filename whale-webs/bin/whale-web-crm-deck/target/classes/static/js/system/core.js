/**
 * core v0.1
 * 基础核心类
 */

var YL = $.YLCLOUD || {};

var ie = $.browser.msie;
var ie6 = $.browser.msie && $.browser.version < 7;
var ie7 = $.browser.msie && $.browser.version < 8;
var win = $(window);
var doc = $(document);
var hml = $('html');

if (ie6) document.execCommand("BackgroundImageCache", false, true);

YL.VERSION = '0.1';

//扩展核心辅助方法
YL.widget = {};

/** js获取项目路径 */
function getContextPath() {
    //var pathName = document.location.pathname;
    //var index = pathName.substr(1).indexOf("/");
    //var result = pathName.substr(0,index+1);
    var result ="";//如JS在扔到服务器上获取项目路径错误,将此文件这里要打开..上边三行要注释掉
 	return result;
 }


$(document).ready(function() {
	//解决左右滚轴显示问题
    //$('body').css({"overflow":"hidden","overflow-y":"none"}).attr('scroll','no');
    
    $('.table-box').find('.table').wrap("<div class='newtable'></div>");

    var height = (window.innerHeight||document.body.clientHeight) - $('.search-form').height() - $('.table-box-head').height() - $('.ui-content.ui-shadow>h3').height() - $('.yl-main-header').height() - 32 -60,
    	width = (window.innerWidth||document.body.clientWidth) - $('.yl-sidebar').width() - 60;

    $('.newtable').height(height).width(width);
    
    
    $('.yl-content .table tr').on('click',function() {
    	$(this).addClass('on').siblings('.on').removeClass('on');
    })
    
    var layerIndex ;
    //Ajax 锁屏
    $(document).ajaxStart(function (){
    	layerIndex = layer.load(1, {
       	  shade: [0.1,'#fff'] //0.1透明度的白色背景
       	});
    	
    }) ;
    $(document).ajaxStop(function (){
    	layer.close(layerIndex);
    });
    
});


//区域级联
function  loadArea(){
	$(".provincesel").change(function (){
		var sel=$(this) , _val = sel.val() , target=$("."+sel.attr("target"));
		
		$.getJSON("/customers/lable/loadArea/"+_val, function(entry){
			target.empty();
			for ( var i in  entry){
				var checked="";
				if (target.attr("val")==entry[i].code){
					checked=' selected="selected" ';
				}
				target.append('<option '+checked+' value="'+entry[i].code+'" >'+entry[i].name+'</option>');
				//console.log(entry[i].code);
			}
			
		 });
	});
}
//产品类别级联
function  loadProClass(){
	$(".proClassA").change(function (){
		var sel=$(this) , _val = sel.val() , target=$("."+sel.attr("target"));
		$.getJSON("/customers/lable/loadProClass/"+_val, function(entry){
			target.empty();
			target.append('<option value="-1" >请选择</option>');
			for ( var i in  entry){
				
				var checked="";
				if (target.attr("val")==entry[i].code){
					checked=' selected="selected" ';
				}
				target.append('<option '+checked+'  value="'+entry[i].code+'" >'+entry[i].name+'</option>');
			}
		});
	});
}

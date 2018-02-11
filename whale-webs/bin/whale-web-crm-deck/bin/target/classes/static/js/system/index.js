/**
 * index v0.1
 * 页面布局方法集合
 */

// function ylPage(){
//     this.config = {
//         winH: $(window).height()
//     };
//     //初始化方法
//     this.init = function(){
//         this.setBodyContentHeight();
//     };
//     //设置主体页面高度
//     this.setBodyContentHeight = function(){
//         var _toTopSize = $('#contentWrapper').offset().top;
//         $('#contentWrapper').css('height', $(window).height() - _toTopSize);
//     };
// }
//
// var ylPage = new ylPage();
// ylPage.init();

(function(global) {

	//页面与登录当前用户ID核对
	function $getCookie(name) {
	    var reg = new RegExp("(^| )" + name + "(?:=([^;]*))?(;|$)"), 
	    val = document.cookie.match(reg);
	    return val ? (val[2] ? unescape(val[2]) : "") : null;
	}
	var pageToken = $getCookie('__page_token');

	checkPageToken();
	function checkPageToken() {
		if (pageToken != $getCookie('__page_token')) {
			alert('会话已经刷新。');
			$('.box-pop #yl-btn-submit, .box-pop #yl-btn-closes').click(function() {
				location.href = globalPath;
			});
			return;
		}
	    setTimeout(checkPageToken, 1000);
	}

    //定位菜单
    if(localStorage.navIndex){
        var _n = localStorage.navIndex.split(',');
        $('.treeview').eq(parseInt(_n[0])).addClass('cor-on').find('.treemenu').show();
        $('.treeview').eq(parseInt(_n[0])).find('a:first').find('span').addClass('fb');
        $('.treeview').eq(parseInt(_n[0])).find('.treemenu li').eq(parseInt(_n[1])).addClass('on');
    }

    if(localStorage.navIndexThrid){
        var _n = localStorage.navIndexThrid;
        $('.sidebar-thrid-u li').eq(parseInt(_n)).find('a').addClass('on');
    }

    $('.logo').click(function(){
        localStorage.navIndex = '';
        localStorage.navIndexThrid = '';
    });

    //if($('#mainSidebarThrid')[0]){
    if($('#mainSidebarThrid').eq(0).css('display') == 'block'){
        $('body').css('background-color','#fff');
        //$('.yl-content .container').css('padding','0');
        $('#contentWrapper').css('margin-left','360px');
    }

    //按照页面加载顺序和体验 先加载头部和左侧菜单js，再加载其他的
    //实现菜单效果
    $('.nav-dropdown').click(function() {
    	$('.nav-dropdown').find('.dropdown-menu').hide();
        if ($(this).find('.dropdown-menu').css('display') == 'none') {
        	$('.yl-navbar-nav .nav-peop').css('background-position','0 -419px');
            if($(this).index() == '0'){
            	$('.yl-navbar-nav .nav-peop').css('background-position','0 -457px');
                $(this).find('.dropdown-menu').width($('.navbar-custom-menu').width());
            }
            $(this).find('.dropdown-menu').show();
        } else {
            $(this).find('.dropdown-menu').hide();
            $('.yl-navbar-nav .nav-peop').css('background-position','0 -419px');
        }
        return false;
    });



    //
    function bindTreeEvent() {
        $('.treeview').bind('click', function() {
        	//if($(this).attr("class") == "treeview"){
        	if($(this).hasClass("treeview")){
        		$('.treeview').removeClass('cor-on');
                $(this).addClass('cor-on');
                $('.treemenu').hide();
                if ($(this).find('.treemenu').css('display') == 'none') {
                    $(this).find('.treemenu').show();
                } else {
                    $(this).find('.treemenu').hide();
                }
        	}else{
        		$('.treeview').removeClass('cor-on');
        		$(this).find('.treemenu').hide();
                $('.treemenu').hide();
        	}
        });

        $('.treemenu li').click(function() {
        	if($(this).find('.idx').attr('idx')){
        		var _n2 = $(this).find('.idx').attr('idx');
        	}else{
        		var _n2 = $(this).index();
        	}
            var _n1 = $(this).parent().parent().index();
            localStorage.navIndex = _n1 + ',' + _n2;
            $('.treemenu li').removeClass();
            $(this).addClass('on');
        });

        $('.sidebar-thrid-u li').click(function() {
            var _n3 = $(this).index();
            localStorage.navIndexThrid = _n3;
            $('.sidebar-thrid-u li a').removeClass();
            $(this).find('a').addClass('on');
        });

    }

    bindTreeEvent();


    // $('.treemenu').hover(function(){
    //     $(this).css('background-color','#3f5469');
    // },function(){
    //     $(this).css('background-color','#34495e');
    // });

    //点击页面关闭头部弹出框
    $(document).bind('click', function(e) {
        var target = e.target || e.srcElement;
        if (target.className != 'nav-dropdown' && target.className != 'nav-peop' && target.className != 'user-image') {
            $('.dropdown-menu').hide();
            $('.yl-navbar-nav .nav-peop').css('background-position','0 -419px');
        }
    });

    //设置主体页面显示滚动条
    function showContentScroll() {
    	try {
	        //获取主页到顶部的高度
	        var _toTopSize = $('#contentWrapper').offset().top;
	        $('#contentWrapper').css('height', $(window).height() - _toTopSize);
	        $('.sidebar-thrid-btn').css('top', ($(window).height() - _toTopSize)/2 - 50);
	        //判断是否有滚动条，默认撑开盒子100%高度到达框架底部
	    	if (document.getElementById('contentWrapper').style.overflow != "hidden" && document.getElementById('contentWrapper').scroll != "no" &&
	            document.getElementById('contentWrapper').scrollHeight > document.getElementById('contentWrapper').offsetHeight) {
	            $('.container').css('height', 'auto');
	        } else {
	            $('.container').css('height', $(window).height() - _toTopSize);
	        }
    	}catch (e) {
//    		console.log(e);
		}
    }
    
    setTimeout(function(){
    	showContentScroll();
    },100);

    //页面大小改变左侧菜单和右侧自适应
    /*$.fn.bindAndExec = function(eventNames, handler) {
        this.bind(eventNames, handler).each(handler);
    };

    function setTimerResize() {
        showContentScroll();
    }

    $(window).bindAndExec('resize', setTimerResize);*/
    
    $(window).resize(function() {
    	showContentScroll();
	});

    //这里点击缩放左侧菜单功能
    $('.sidebar-toggle').toggle(function() { //缩放到左侧
        if($('#mainSidebarThrid')[0]){ //三级菜单存在
            if($('#mainSidebarThrid').css('width') === '15px'){
                $('#contentWrapper').css('margin-left','50px');
                $('.yl-wrapper').css('box-shadow','50px 0 5px #4a5b68');
                //$('#mainSidebarThrid').css('left','50px');
                $('.yl-sidebar-thrid').css('left','50px');
            }else{
                $('#contentWrapper').css('margin-left','230px');
                $('.yl-wrapper').css('box-shadow','230px 0 5px #4a5b68');
                $('#mainSidebarThrid').css('left','50px');
            }
        }else{
            $('#contentWrapper').css('margin-left','50px');
            $('.yl-wrapper').css('box-shadow','50px 0 5px #4a5b68');
            //这里设置场馆方案画布的宽度大小
            if($('#canvasContainer')[0]){
            	var canvasContainerWidth = $('#canvasContainer').width() + 130;
                $('#canvasContainer').css('width',canvasContainerWidth);
            }
        }

        $('.logo,#mainSidebar').css('width', '50px');
        $('.sidebar-list li.treeview a.treetitle').css('width', '');
        $('.lg-max,.sidebar-head,.treetitle span,.treemenu').hide();
        $('.lg-min').show();
        $('.treeview').unbind('click');

        //这里缩放时候滑动设置右侧的菜单ui的位置
        $('.treeview').bind('hover', function() {
            $('.treemenu').removeClass('treepos');
            $('.treeview').removeClass('cor-on');
            $(this).addClass('cor-on');
            $('.treemenu').hide();
            $(this).find('.treemenu').addClass('treepos').show();
        });
        $('.treeview').bind('mouseleave', function() {
            $('.treemenu').hide();
        });
    }, function() { //放大恢复
        if($('#mainSidebarThrid')[0]){
            if($('#mainSidebarThrid').css('width') === '15px'){
                $('#contentWrapper').css('margin-left', '180px');
                $('.yl-wrapper').css('box-shadow','180px 0 5px #4a5b68');
                $('#mainSidebarThrid').css('left','180px');
            }else{
                $('#contentWrapper').css('margin-left', '360px');
                $('.yl-wrapper').css('box-shadow','360px 0 5px #4a5b68');
                $('#mainSidebarThrid').css('left','180px');
            }
        }else{
            $('.logo,#mainSidebar').css('width', '180px');
            $('.sidebar-list .treemenu li,.sidebar-list li.treeview a.treetitle').css('width', '180px');
            $('#contentWrapper').css('margin-left', '180px');
            $('.yl-wrapper').css('box-shadow','180px 0 5px #4a5b68');
            //这里设置场馆方案画布的宽度大小
            if($('#canvasContainer')[0]){
            	var canvasContainerWidth = $('#canvasContainer').width() - 130;
                $('#canvasContainer').css('width',canvasContainerWidth);
            }
        }
        $('.logo,#mainSidebar').css('width', '180px');
        $('.sidebar-list .treemenu li,.sidebar-list li.treeview a.treetitle').css('width', '180px');
        $('.lg-min').hide();
        $('.treeview').each(function() {
            if ($(this).hasClass('cor-on')) {
                $(this).find('.treemenu').show(100);
            }
        });
        $('.lg-max,.sidebar-head,.treetitle span').show(100);
        $('.treeview').unbind('hover');
        //这里缩放时候滑动设置右侧的菜单ui的位置
          $('.treemenu').removeClass('treepos');
        bindTreeEvent();
    });

    //三级菜单缩放
    $('.sidebar-thrid-btn').toggle(function(){
        if($('#mainSidebar').css('width') === '50px'){
            $('#mainSidebarThrid').css({'width':'15px','background-color':'#fff'});
            $('#mainSidebarThrid h3,.sidebar-thrid-u ').hide();
            $('#contentWrapper').css('margin-left', '50px');
            $('.yl-wrapper').css('box-shadow','50px 0 5px #4a5b68');
        }else{
            $('#mainSidebarThrid').css({'width':'15px','background-color':'#fff'});
            $('#mainSidebarThrid h3,.sidebar-thrid-u ').hide();
            $('#contentWrapper').css('margin-left', '180px');
            $('.yl-wrapper').css('box-shadow','180px 0 5px #4a5b68');
        }
    },function(){
        if($('.logo,#mainSidebar').css('width') === '50px'){
            $('#mainSidebarThrid').css({'width':'180px','background-color':'#EAEDF1'});
            $('#mainSidebarThrid h3,.sidebar-thrid-u ').show();
            $('#contentWrapper').css('margin-left', '230px');
            $('.yl-wrapper').css('box-shadow','230px 0 5px #4a5b68');
        }else{
            $('#mainSidebarThrid').css({'width':'180px','background-color':'#EAEDF1'});
            $('#mainSidebarThrid h3,.sidebar-thrid-u ').show();
            $('#contentWrapper').css('margin-left', '360px');
            $('.yl-wrapper').css('box-shadow','360px 0 5px #4a5b68');
            //$('.yl-content .container').css('padding','0');
        }

    });

	//弹出层显示列表
	$('#selectIcon').toggle(function(){
		$(this).removeClass('select-off').addClass('select-on');
		$('#selectCon li input').removeAttr('disabled');
		$('#selectCon li select').removeAttr('disabled');
	},function(){
		$(this).removeClass('select-on').addClass('select-off');
		$('#selectCon li input').attr('disabled','true');
		$('#selectCon li select').attr('disabled','true');
	});
	//弹出登出的对话框
	$('.go-logout').click(function() {
	    $('#box-logout').minBox({
	        layClick: true,
	        drag: true

	    });
	});
	$('.logout').click(function() {
		location.href = $('.go-logout input').val();
	});
	
	
	//权限--全选
    $('.check-parent').on('click','input',function(){
    	var isChange = $(this).prop("checked");
    	if(isChange){
    		$(this).parent().next().find('li input').prop('checked','checked');
    	}else{
    		$(this).parent().next().find('li input').prop('checked',false);
    	}
    });
    //折叠
   	$('.check-parent i').click(function(){
    	if($(this).parent().next().css('display') == 'block'){
    		$(this).parent().next().hide();
    	}else{
    		$(this).parent().next().show();
    	}
    });
    
    //查询条件--展开收缩
    $('.conditionBtn').toggle(function(){
    	$('.conditionCon').slideDown();
    	$(this).html('<a href="####">收起</a>&nbsp;<i class="icon iconfont">-</i>');
    	$(this).css('margin-top','-25px');
    	$('.query1').hide();
    	$('.query2').show();
    },function(){
    	$('.conditionCon').slideUp();
    	$(this).html('<a href="####">更多</a>&nbsp;<i class="icon iconfont">+</i>');
    	$(this).css('margin-top','-25px');
    	$('.query2').hide();
    	$('.query1').show();
    });
    
    //tab-全选
    var checkNum = 0;
    $('#sel').click(function(){
    	if($("#sel").prop("checked")){
    		$('#orderChild tr input').attr('checked',true);
    		checkNum = $('#orderChild input').length;
    	}else{
    		$('#orderChild input').attr('checked',false);
    		checkNum = 0;
    	}
    });
    
    $('#orderChild').on('click','tr input',function(){
    	$(this).prop("checked")?checkNum++:checkNum--;
    	if(checkNum < $('#orderChild input').length){
    		$('#sel').attr('checked',false);
    	}
    	if(checkNum == $('#orderChild input').length){
    		$('#sel').attr('checked',true);
    	}
    });
    
    global.checkTab = function(allBtn,inp){
	    var checkNum = 0;
	    $('.container , .content-list').on('click',allBtn,function(){
	    	if($(allBtn).prop("checked")){
	    		$(inp).attr('checked',true);
	    		checkNum = $(inp).length;
	    	}else{
	    		$(inp).attr('checked',false);
	    		checkNum = 0;
	    	}
	    });
	    $('.container , .content-list').on('click',inp,function(){
	    	checkNum = 0;
	    	$(inp).each(function(i,e){
	    		if($(e).prop("checked")){
	    			checkNum++;
	    		}
	    	});		    	
	    	if(checkNum < $(inp).length){
	    		$(allBtn).attr('checked',false);
	    	}
	    	if(checkNum == $(inp).length){
	    		$(allBtn).attr('checked',true);
	    	}
	    });
    };
    
    //打票进度条
    global.ticketProgress = function(){
    	$('#printCon').minBox({
    		layClick: false
    	});
    	$('.scale-layer').show();
    	$('#printCon').css('z-index','5012');
    	
    	scaleFun();
    };
    function scaleFun(){
		var n=0;
		var timer = null;
		timer = setInterval(function(){
			n+=5;
			$('#bar span').css('width',n+'px');
			$('.scale').html(parseInt(n / 540 * 100) +'%');
			
			if(n >= 540){
				n = 540;
				clearInterval(timer);
				setTimeout(function(){
					$('#printCon').hide();
					$('.scale-layer').hide();
					n = 0;
					$('#bar span').css('width',0);
				},500);
			}
		},30);
	}
    
    //日历控件
    //_dateTime();
    global.dateTime = function(start,end){
		$.datetimepicker.setLocale('ch');//设置中文
		var startMaxDate='+1970/01/01';
		var endMinDate=$(start).val().replace('-','/');
		$(start).datetimepicker({
			format:'Y-m-d',
			timepicker:false,
			//minDate:'-1970/01/02', // yesterday is minimum date
			//maxDate:startMaxDate // and tommorow is maximum date calendar
		});
		$(end).datetimepicker({
			format:'Y-m-d',
			timepicker:false,
			//minDate:endMinDate, // yesterday is start date
			//maxDate:'+1970/01/02' // and tommorow is maximum date calendar	
		});
		$(start).change(function(){
			setMinMaxDate();
		});
		$(end).change(function(){
			setStartMaxDate();
		});
		//setStartMaxDate();
		function setStartMaxDate(){
			startMaxDate=$(end).val().replace('-','/');
			$(start).data('xdsoft_datetimepicker').setOptions({maxDate:startMaxDate});
		}
		function setMinMaxDate(){
			endMinDate=$(start).val().replace('-','/');
			$(end).data('xdsoft_datetimepicker').setOptions({minDate:endMinDate});
		}
		
		//页面滚动时  重新计算位置
		var _top = parseInt($(start).offset().top) + parseInt($(start).css('height'));
		$("#contentWrapper").scroll(function() {
			var dateTimeFlag = false;
			$('.xdsoft_datetimepicker').each(function(i,e){
				if($(e).css('display') == 'block'){
					dateTimeFlag = true;
				}
			})
			if(dateTimeFlag){
				var _scrollTop = parseInt($('#contentWrapper').scrollTop()) - 6;
				$('.xdsoft_datetimepicker').css('top',_top - _scrollTop);
				$('.xdsoft_datetimepicker').css({'z-index':9});
			}
		  });
	};
	//转化时间
    global.formatDateTime = function (date) { 
    	var oDate = new Date(date);
	    var y = oDate.getFullYear();  
	    var m = oDate.getMonth() + 1;  
	    m = m < 10 ? ('0' + m) : m;  
	    var d = oDate.getDate();  
	    d = d < 10 ? ('0' + d) : d;  
	    var h = oDate.getHours();  
	    h = h < 10 ? ('0' + h) : h;  
	    var minute = oDate.getMinutes();  
	    minute = minute < 10 ? ('0' + minute) : minute;  
	    var s = oDate.getSeconds();  
	    s = s < 10 ? ('0' + s) : s;  
	    
	    return { 
	    		"yyyy-MM-dd-HH:mm:ss":y + '-' + m + '-' + d+' '+h+':'+minute+':'+s,
	    		"yyyy-MM-dd-HH:mm":y + '-' + m + '-' + d+' '+h+':'+minute,
	    		"yyyy-MM-dd":y + '-' + m + '-' + d}
	};
	//统计字数
	global.currentNum = function(conId,currId,totalNum){
		if($(conId).val().length){
			$(currId).html($(conId).val().length);
		}
    	$(conId).on('input propertychange',function(){
			if($(conId).val().length >= totalNum){
				var _val = $(conId).val().substring(0,totalNum);
				$(conId).val(_val);
			}
			$(currId).html($(conId).val().length);
		}); 
	};
	//标题 H3 浮在上层
	global.fixedH3 = function(){
		$('#contentWrapper').scroll(function(){
			$('section').find('h3:first').addClass('curr-fixed');
			if($('.tmp-h3').length == 0){
				$('section').find('h3:first').after('<div class="tmp-h3"></div>');
			}
			//console.log($(this).scrollTop());
			if($(this).scrollTop() == 0){
				$('section').find('h3:first').css('width','initial').removeClass('curr-fixed');
				$('section').find('.tmp-h3').remove();
			}
			//是否出现三级菜单
			if($('#mainSidebarThrid').css('display') == 'block'){
				$('.curr-fixed').css('width','-webkit-calc(100% - 360px)');
			}else{
				$('.curr-fixed').css('width','-webkit-calc(100% - 180px)');
			}
		});
	};
	 
    
    
	
})(window);

//清除表单值
function clearForm(myFormElement) {

	  var elements = myFormElement.elements;

	  myFormElement.reset();

	  for(i=0; i<elements.length; i++) {

	  field_type = elements[i].type.toLowerCase();

	  switch(field_type) {

	    case "text":
	    case "password":
	    case "textarea":
	   // case "hidden":
	      elements[i].value = "";
        break;

	    case "radio":
	    case "checkbox":
	        if (elements[i].checked) {
	          elements[i].checked = false;
	      }
	    break;

	    case "select-one":
	    case "select-multi":
	        elements[i].value = "";
	      break;
	    default:
	      break;
	  }
	    }
}

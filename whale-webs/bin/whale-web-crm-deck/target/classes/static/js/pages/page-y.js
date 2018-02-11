window.onload=function(){
	
	/*tab切换*/
	/*-----------------------------------------------------------------*/
	$(".switch a").click(function(){
		var index=$(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$(".switch-centent .scentent").eq(index).show().siblings().hide();
	})
	/*-----------------------------------------------------------------*/
	
	
	/*问题开关*/
	/*-----------------------------------------------------------------*/
	$(".on-off a").click(function(){
		var activeNum = 0;
		if($('#ageBtn').is('.active')){
			activeNum = activeNum + 1;
		}
		if($('#sexBtn').is('.active')){
			activeNum = activeNum + 1;
		}
		if($('#phoneBtn').is('.active')){
			activeNum = activeNum + 1;
		}
		var oneLen=$(".one").children().length + $(".ones").children().length+activeNum;
		//if(($(".one").children().length + $(".ones").children().length)  < 5){
		if(oneLen  < 5){
			var index=$(this).index();
			$(this).toggleClass("active");
			if(index==0){
				$(".scentent-list dl").eq(0).toggle();
				$(".age-exhibition").eq(0).toggle();
				
			}else if(index==1){
				$(".scentent-list dl").eq(1).toggle();
				$(".age-exhibition").eq(1).toggle();
				
			}else if(index==2){
				$(".scentent-list dl").eq(2).toggle();
				$(".age-exhibition").eq(2).toggle();
				
			}
		}else{
			if($(this).is('.active')){
				var index=$(this).index();
				$(this).toggleClass("active");
				if(index==0){
					$(".scentent-list dl").eq(0).toggle();
					$(".age-exhibition").eq(0).toggle();
					
				}else if(index==1){
					$(".scentent-list dl").eq(1).toggle();
					$(".age-exhibition").eq(1).toggle();
					
				}else if(index==2){
					$(".scentent-list dl").eq(2).toggle();
					$(".age-exhibition").eq(2).toggle();
					
				}
			}
		}
		
	})
	/*-----------------------------------------------------------------*/
	
	
	
	/*分享开关*/
	/*-----------------------------------------------------------------*/
	$(".shares").click(function(){
		$(this).toggleClass("active");
		$(".ages-exhibition").toggle();
	})
	/*-----------------------------------------------------------------*/
	
	
	
	/*问题列表下拉收起*/
	/*-----------------------------------------------------------------*/
	$(".scentent-list").on('click','.drop-down',function(){
		$(this).toggleClass("active");
		$(this).parent().siblings('dd').toggle();
	})
	/*-----------------------------------------------------------------*/
	
	
	
	/*弹窗*/
	/*-----------------------------------------------------------------*/
	/*$(".choice").click(function(){
		$(".answer-popup").minBox({})
	})*/
	/*-----------------------------------------------------------------*/
	
	
	
	var dl =['<dl class="graphical01" style="display:block"><dt><i class="fl">Q：</i><input class="fl c_required" type="text" placeholder="填写问题（图形）" /><input type="hidden" value="1" /><span class="fl ml15"><input class="radio mr5" type="radio" value="1" checked="checked" />单选<input class="radio ml10 mr5" type="radio" value="2"  />多选</span><em class="drop-down fr"></em><b class="remove-dt">X</b></dt><dd><b class="add-list"><img src="/images/adds.png" /></b></dd></dl>',
			 '<dl class="graphical02" style="display:block"><dt><i class="fl">Q：</i><input class="fl c_required" type="text" placeholder="填写问题（列表）" /><input type="hidden" value="2" /><span class="fl ml15"><input class="radio mr5" type="radio" value="1" checked="checked" />单选<input class="radio ml10 mr5" type="radio" value="2" />多选</span><em class="drop-down fr"></em><b class="remove-dt">X</b></dt><dd><b class="add-list"><img src="/images/adds.png" /></b></dd></dl>',
	
			 '<dl class="poplist" style="display:block"><dt><i class="fl">Q：</i><input class="fl c_required" type="text" placeholder="填写问题" /><input type="hidden" value="3" /><b class="remove-dt">X</b></dt></dl>'];
			 //'<dl class="poplist" style="display:block"><dt><i class="fl">Q：</i><input class="fl c_required" type="text" placeholder="填写问题" /><input type="hidden" value="3" /><span class="fl ml15"><input class="radio mr5" type="radio" name="radio3"  value="1" checked="checked" />单选</span><b class="remove-dt">X</b></dt></dl>'];
			 //'<dl class="poplist" style="display:block"><dt><i class="fl">Q：</i><input class="fl c_required" type="text" placeholder="填写问题" /><input type="hidden" value="3" /><span class="fl ml15"><input class="radio mr5" type="radio" name="radio3"  value="1" checked="checked" />单选<input class="radio ml10 mr5" type="radio" name="radio3"  value="2" />多选</span><b class="remove-dt">X</b></dt></dl>'];
		
		
	
	var num=0,i=0;
	var dd =['<dd style="display:block"><i class="fl number">'+num+'</i><input class="fl c_required" type="text" placeholder="请输入答案最多支持20个字" maxlength="20" /><span class="fl ml15"><i class="uploads"><div class="uploadnss"><img class="head-portraits" src="/images/addimgs.png" /></div><input class="file" type="file"  name="file" class="docot" /><input type="hidden" class="fileIds" value="0" /></i></span><b class="remove-list fr">X</b></dd>',
			 '<dd style="display:block"><i class="fl number">'+num+'</i><input class="fl c_required" type="text" placeholder="请输入答案最多支持20个字" maxlength="20" /><b class="remove-list fr">X</b></dd>',
			 ''];
	
	var exhibition=['<div class="age-exhibition graphical1" style="display: block;"><div class="age-title"><h4 class="age"></h4><span class="age"></span></div><ul class="age"></ul><div class="age-btn"><a href="javascript:;">继续 → </a></div>',
					'<div class="age-exhibition poplist1" style="display: block;"><div class="age-title"><h4 class="age"></h4><span class="age"></span></div><ol class="age"></ol><div class="age-btn"><a href="javascript:;">继续 → </a></div>',
					'<div class="age-exhibition" style="display: block;"><div class="age-title"><h4 class="age"></h4><span class="age"></span></div><div class="tel-number"><input type="text"></div><div class="age-btn"><a href="javascript:;">继续 → </a></div>',
		];
		
	var lilist=['<li><div class="uploadnss"><img src="/images/img.png" /></div><p></p></li>',
				'<li class="tc"><p></p></li>']
	
	
	var flag=false,type;
		//添加
		function addns(dllist,popup,ddlist,age,lilist){
			$(".add-option a").off("click").on("click", function(){
				var activeNum = 0;
				if($('#ageBtn').is('.active')){
					activeNum = activeNum + 1;
				}
				if($('#sexBtn').is('.active')){
					activeNum = activeNum + 1;
				}
				if($('#phoneBtn').is('.active')){
					activeNum = activeNum + 1;
				}
				var oneLen=$(".one").children().length + $(".ones").children().length+activeNum;
				//console.log(oneLen);
				//console.log($(".scentent-list dl").length);
				var qName = "qName"+oneLen;
				if(!flag && $(".ones").children().length == 0){
					$(this).parent().before('<div class="one"></div>');
					$('.answer-l').append('<div class="two"></div>');
					flag=true;
				}
				if(oneLen  < 5){
				//if($(".scentent-list dl").length  < 5){
					$('.one').append(dllist)
					$('.two').append(popup)
					$('.ones').append(dllist)
					$('.twos').append(popup)
					for(var i=0;i<$(".one").children().length;i++){
						var num	=i+1;
						//console.log(num);
						$(".one").children().eq(i).children('dt').children('.c_required').attr('name','qName'+num);
						$(".one").children().eq(i).children('dt').children('input[type=hidden]').attr('name','selectType'+num);
						$(".one").children('dl').eq(i).addClass('answerName	'+num);
						$(".one").children().eq(i).children('dd').children('.c_required').attr('name','answerNames'+num);
						$(".one").children().eq(i).children('dt').children().children('.radio').attr('name','qSelect'+num);
						$(".one").children().eq(i).children('dd').children().children().children('input[type=file]').attr('name','answerFiles'+num);
						$(".one").children().eq(i).children('dd').children().children().children('.fileIds').attr('name','fileIds'+num);
					}
					for(var i=0;i<$(".ones").children().length;i++){
						var num	=i+1;
						//console.log(num);
						$(".ones").children().eq(i).children('dt').children('.c_required').attr('name','qName'+num);
						$(".ones").children().eq(i).children('dt').children('input[type=hidden]').attr('name','selectType'+num);
						$(".ones").children('dl').eq(i).addClass('answerName	'+num);
						$(".ones").children().eq(i).children('dd').children('.c_required').attr('name','answerNames'+num);
						$(".ones").children().eq(i).children('dt').children().children('.radio').attr('name','qSelect'+num);
						$(".ones").children().eq(i).children('dd').children().children().children('input[type=file]').attr('name','answerFiles'+num);
						$(".ones").children().eq(i).children('dd').children().children().children('.fileIds').attr('name','fileIds'+num);
					}
					
				}
				
				
			});
			
			
			$(".scentent-list").off('click.add-list').on('click.add-list','.add-list',function(){
				//变量判断添加哪个
				if($(this).parents("dl").hasClass("graphical01")){
					type=1;
				}else if($(this).parents("dl").hasClass("graphical02")){
					type=2;
				}else if($(this).parents("dl").hasClass("poplist")){
					type=3;
				}
				
				//添加子集
				if($(".add-option input[type=radio]:checked").val()==type){
					$(this).parent().before(ddlist);
				}
				
				num++;
				
				var dlg = $(this).parent().siblings('dd').length;
				var indexs=$(this).parent().parent().index();
				
				for(var i=0;i<dlg;i++){
					num=dlg;
					//添加序号
					$(this).parent().siblings('dd').eq(i).find('.number').html(i+1);
					
					//添加类名用于上传图片
					$(this).parent().siblings('dd').eq(i).find('.file').addClass('file'+indexs+i);
					$(this).parent().siblings('dd').eq(i).find('.uploadnss').addClass('uploadnss'+indexs+i);
					$(this).parent().siblings('dd').eq(i).find('.file').addClass("file"+indexs+i).attr('onchange', 'getPhoto(this,$(".uploadnss'+indexs+i+'"))');
					
						
				}
				
				//右边弹窗添加子集
				$(".two .age-exhibition").eq(indexs).find(age).append(lilist);
				$(".twos .age-exhibition").eq(indexs).find(age).append(lilist);
				
				//于添加的类名保持一致，方便添加图片
				$(".two .age-exhibition").eq(indexs).find('ul.age li').each(function(b){
					$(this).find('.uploadnss').addClass('uploadnss'+indexs+b);
				});
				$(".twos .age-exhibition").eq(indexs).find('ul.age li').each(function(b){
					$(this).find('.uploadnss').addClass('uploadnss'+indexs+b);
				});
				
				for(var i=0;i<$(".one").children().length;i++){
					var num	=i+1;
					$(".one").children().eq(i).children('dd').children('.c_required').attr('name','answerNames'+num);
					$(".one").children().eq(i).children('dd').children().children().children('input[type=file]').attr('name','answerFiles'+num);
					$(".one").children().eq(i).children('dd').children().children().children('.fileIds').attr('name','fileIds'+num);
					
					//$(".one").children('dl').eq(i).addClass('answerName	'+num);
				}
				for(var i=0;i<$(".ones").children().length;i++){
					var num	=i+1;
					$(".ones").children().eq(i).children('dd').children('.c_required').attr('name','answerNames'+num);
					$(".ones").children().eq(i).children('dd').children().children().children('input[type=file]').attr('name','answerFiles'+num);
					$(".ones").children().eq(i).children('dd').children().children().children('.fileIds').attr('name','fileIds'+num);
					
					//$(".one").children('dl').eq(i).addClass('answerName	'+num);
				}
				
			})
			
			
		}
		
		
		$(".scentent-list").on('click','.remove-dt',function(){
				var dls=$(this).parent().parent('dl');
				var inde=dls.index();
				$(".two .age-exhibition").eq(inde).remove()
				$(".twos .age-exhibition").eq(inde).remove()
				dls.remove();
				//console.log($(this).length)
				if($('.ones').html() == ''){
					$('.ones,.twos').remove();
				}
		})
		
		
	
		//删除
		function removes(age){
			$(".scentent-list").off('click.remove-list').on('click.remove-list','.remove-list',function(){
				
				var dds = $(this).parent().siblings("dd");
				//调整序号
				for(var i=0;i<dds.length;i++){
					dds.eq(i).find('.number').html(i+1);
				}
				
				var indexe=$(this).parent("dd").index();
				var indexs=$(this).parent().parent().index();
				
				//删除左边弹窗相应的内容
				$(".two .age-exhibition").eq(indexs).find(age).eq(indexe-1).remove();
				$(".twos .age-exhibition").eq(indexs).find(age).eq(indexe-1).remove();
				
				
				if($(this).parents("dl").hasClass("graphical01")){
					type=1;
				}else if($(this).parents("dl").hasClass("graphical02")){
					type=2;
				}else if($(this).parents("dl").hasClass("poplist")){
					type=3;
				}
				if($(".add-option input[type=radio]:checked").val()==type){
					$(this).parent().remove();
				}
				
				
			})
		}
	
		//选择添加什么类型的模板
		$(".add-option input[type=radio]").click(function(){
			if($(this).val()=='1'){
				
				addns(dl[0],exhibition[0],dd[0],'ul.age',lilist[0]);
				removes('ul.age li');
				
			}else if($(this).val()=='2'){
				
				addns(dl[1],exhibition[1],dd[1],'ol.age',lilist[1]);
				removes('ol.age li');
				
			}else if($(this).val()=='3'){
				
				addns(dl[2],exhibition[2],dd[2],null);
				
			}
		})
		
			if($(".add-option input[type=radio]").val()=='1'){
				
				addns(dl[0],exhibition[0],dd[0],'ul.age',lilist[0]);
				removes('ul.age li');
				
			}else if($(".add-option input[type=radio]").val()=='2'){
				
				addns(dl[1],exhibition[1],dd[1],'ol.age',lilist[1]);
				removes('ol.age li');
				
			}else if($(".add-option input[type=radio]").val()=='3'){
				
				addns(dl[2],exhibition[2],dd[2],null);
				
			}
		
	
		//input赋值
		
		function inpblur1(type,text){
			$(".scentent-list").on('blur',type,function(){
				var ind=$(this).parent().index();
				var grapindex=$(this).parents('dl').index();
				$('.two .age-exhibition').eq(grapindex).find(text).eq(ind-1).find('p').html($(this).val());
				$('.twos .age-exhibition').eq(grapindex).find(text).eq(ind-1).find('p').html($(this).val());
			});
		};
		
		function inpblur2(events,type,text){
			$(".scentent-list").on(events,type,function(){
				var grapindex=$(this).parents('dl').index();
				$(".two .age-exhibition").eq(grapindex).find(text).html($(this).val());
				$(".twos .age-exhibition").eq(grapindex).find(text).html($(this).val());
			});
		};
		
		function  types (numbers,olli){
			inpblur1('.one .graphical0'+numbers+' dd input[type=text]',olli);
			inpblur1('.ones .graphical0'+numbers+' dd input[type=text]',olli);
			inpblur2('blur','.one .graphical0'+numbers+' dt input[type=text]','.age-title h4');
			inpblur2('click','.one .graphical0'+numbers+' dt input[type=radio]','.age-title span');
			inpblur2('blur','.ones .graphical0'+numbers+' dt input[type=text]','.age-title h4');
			inpblur2('click','.ones .graphical0'+numbers+' dt input[type=radio]','.age-title span');
			inpblur2('blur','.one .poplist dt input[type=text]','.age-title h4');
			inpblur2('click','.one .poplist dt input[type=radio]','.age-title span');
			inpblur2('blur','.ones .poplist dt input[type=text]','.age-title h4');
			inpblur2('click','.ones .poplist dt input[type=radio]','.age-title span');
		}
		
		types(1,'ul.age li');
		types(2,'ol.age li');
		
}
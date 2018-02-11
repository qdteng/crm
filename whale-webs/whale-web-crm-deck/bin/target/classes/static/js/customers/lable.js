var zTree, rMenu ,current_tid="tree_1";
function clearProperty(){
	//清除可编辑属性已有未保存的值
	$("#propFrm   input ").prop("checked","");
	$("#propFrm   select ").val("-1"); 
	$("#propFrm   input[type='text'] ").val(""); 
	$("#propFrm   input[type='hidden'] ").val(""); 
}
$(function (){
	loadArea();
	loadProClass();

	
	//树形菜单加载
	var parentName = $("#parentParam").attr("vname") ,
	parentId = $("#parentParam").attr("vid")  ,
	hasChildren=$("#parentParam").attr("hasChildren") , isSearch=false ;
	
	
	setting = {
    		view: {
    			selectedMulti: false
    		},callback: {
    			beforeClick: function (treeId, treeNode){
    				disableEdit();
    				clearProperty();
    				//是最后一级可以添加标签属性
    				if (!treeNode.hasChildren){
    					$("#propFrm").attr("action","/customers/lable/saveOrUpdatePropertysByLableId/"+treeNode.id);
						//读取数据库中已有的属性值还原
    					$.getJSON("/customers/lable/getPropertysByLableId/"+treeNode.id, function(entry){
    						//标签下有属性，还原属性选择
    						if (null!=entry){
	    						for(var iteam in entry){
	    							$("#propFrm").find("input[name='"+iteam+"']").each(function (index,object){
	    								var type =$(object).attr("type");
	    								if (type=="hidden" ||type=="text" ){
	    									$(object).attr("value",entry[iteam]);
	    								}else if(type=="checkbox"){
	    									if((entry[iteam]+",").indexOf($(object).val()+",")> -1){
	    										$(object).prop("checked","checked");
	    									}
	    								}
	    							});
	    							
	    							
	    							$("#propFrm").find("select[name='"+iteam+"']").each(function (index,object){
    									$(object).find("option[value='"+entry[iteam]+"']").attr("selected",true);
    									$(object).attr("val",entry[iteam]);
	    							});
	    						}
	    						
	    						$("#propFrm").find("select[value!='-1']").change();
    						}else {
    							enableEdit();
    						}
    	        		 });
    					
    				}else{
    					$(".editLable").addClass("yl-btn-disabled");
    					$(".editLable").unbind("click");
    					
    				}
    			},
    			beforeExpand: function (treeId, treeNode){
    				
    				if (!isSearch){
    					current_tid=treeNode.tId;
	    				//可加载子节点的
	    				if(treeNode.hasChildren!=undefined||treeNode.id==0){
	    					reLoadChild(current_tid);
	    				}
    				}
    			},
    			onRightClick: function  (event, treeId, treeNode) {
    				if (!isSearch){
	    				if (!treeNode && event.target.tagName.toLowerCase() != "button"
	    						&& $(event.target).parents("a").length == 0) {
	    					zTree.cancelSelectedNode();
	    					showRMenu(treeNode, event.clientX, event.clientY);
	    				} else if (treeNode && !treeNode.noR) {
	    					zTree.selectNode(treeNode);
	    					showRMenu(treeNode, event.clientX, event.clientY);
	    				}
    				}
    			}
    		}
    	},
    	zTreeNodes = [
    		{"name":parentName, open:true, isParent:true ,tId:"tree_top"  , id:parentId ,hasChildren :hasChildren}
    	];

		function initTree(){
			 current_tid="tree_1"
			 $.fn.zTree.init($("#tree"), setting, zTreeNodes);
    		 zTree = $.fn.zTree.getZTreeObj("tree");
    		 reLoadChild(0);
		}
		
    	$(document).ready(function(){
    		initTree();
    		 rMenu = $("#rMenu");
    	});
    	
    	$(".search_btn").click(function (){
    		var searchStr = $.trim($("#searchName").val());
    		if (searchStr){
    			isSearch=true ;
        		zTree.destroy();
        		var searchTree; 
        		$.getJSON("/customers/lable/searchNode/"+searchStr, function(entry){
        			searchTree=entry ;
        			 $.fn.zTree.init($("#tree"), setting, searchTree);
            		 zTree = $.fn.zTree.getZTreeObj("tree");
            		 zTree.expandAll(true);
        		  });
    		}else {
    			isSearch=false;
    			initTree();
    		}
    		
    	});
});



//将当前的标签分类属性保存
function saveLable(){
	if(zTree.getSelectedNodes().length>0){
		var ischeck= false ;
		$("#propFrm").find("select").each(function (index,obj){
			if (obj.value!=-1){
				ischeck=true;
			}
		});
		if(!ischeck){
			if ($("#propFrm").find("input[type='checkbox']:checked").length>0){
				ischeck=true;
			}
		}
		
		if(!ischeck){
			$("#propFrm").find("input[type='text']").each(function (index,obj){
				if ($.trim(obj.value)!=""){
					ischeck=true;
				}
			});
		}
		//判断属性是否有选择
		if(ischeck){
			$frm = $("#propFrm");
			//提交表单
    		$frm.ajaxSubmit({success: function(entry, statusText, xhr, $form){
    			if(entry.code=="success"){
					$frm.find("#id").attr("value",entry.values.propertyid);
					disableEdit();
    			}
    			layer.msg(entry.message,{time: 2000} ,function (){
    				window.location.reload();
    			}); 
			}});
		}else {
			alert ("请选择用户属性");
		}
		
	}else {
		alert ("请选中树形标签类别名称");
	}
}


//设置属性不可编辑
function disableEdit(){
	$("#isEdit").val(0);
	$("#propFrm   input,select ").prop("disabled","disabled"); 
	$("#propFrm   input,select ").prop("readonly","readonly"); 
	$(".createLable").addClass("yl-btn-disabled");
	$(".editLable").removeClass("yl-btn-disabled");
	$(".createLable").unbind("click");
	$(".editLable").bind("click",enableEdit);
}
//设置属性可编辑
function enableEdit(){
	$("#isEdit").val(1);
	$("#propFrm   input,select ").prop("disabled",""); 
	$("#propFrm   input,select ").prop("readonly",""); 
	$(".createLable").removeClass("yl-btn-disabled");
	$(".editLable").addClass("yl-btn-disabled");
	//保存标签属性按钮
	$(".createLable").bind("click",saveLable);
	$(".editLable").unbind("click");
}

//加载子节点
function reLoadChild(tid){
	var node = zTree.getNodeByTId(tid?tid:current_tid) ,pid=node.id;
	zTree.removeChildNodes(node);
	$.getJSON("/customers/lable/loadChild/"+pid, function(entry){
		 var newNodes = entry;
		 zTree.addNodes(node, newNodes);
		 node.hasChildren=true;
		 zTree.updateNode(node);
	  });
}


function showRMenu(treeNode, x, y) {
	if(!treeNode){
		return ;
	}
	$("#rMenu ul").show();
	
	$("#m_add").show();
	$("#m_del").show();
	$("#m_rename").show();
	if (treeNode.isHasProperty||( treeNode.getParentNode()!= null  && treeNode.getParentNode().getParentNode() !=null ) ) {//是否已生成标签
		//console.log("已生成标签，或当前已是第三级，不可添加子级别操作");
		$("#m_add").hide();
	}
	if (treeNode.hasChildren){
		//console.log("有子级不可删除");
		$("#m_del").hide();
	}
	
	rMenu.css({
		"top" : y-50 + "px",
		"left" : x-190 + "px",
		"visibility" : "visible"
	});

	$("body").bind("mousedown", onBodyMouseDown);
}

function onBodyMouseDown(event) {
	if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length > 0)) {
		rMenu.css({
			"visibility" : "hidden"
		});
	}
}

//右键添加节点
function addTreeNode() {
	hideRMenu();
	$('#msg').empty();
	var _boxName = "添加节点";$("#addNodeName").attr("value","");
	$("#dialogFormWin").minInBox({
  		"boxHeight": 220,
        "boxWidth": 400,
        "boxName": _boxName,
        "iSubmitHander":function (){
        	//1.启用表单验证。
    		var validateWidget = $("#dialogForm").validate();
    		if (!validateWidget.check()) {//1.基础样式校验。
    			return false;
    		}
    		var addNodeName = $('#addNodeName').val();
    		if(null == addNodeName || '' == addNodeName){
    			$('#msg').html("请填写节点名称");
    			return false;
    		}
    		var nodeName = $("#dialogForm").find("#addNodeName").val();
    		
    		var pid =zTree.getSelectedNodes()[0].id; 
    		var tid =zTree.getSelectedNodes()[0].tId; 
    		$.getJSON("/customers/lable/addOrUpdChild/"+pid, {lableName :nodeName } , function(entry){
    			layer.msg(entry.message,{time: 1000} ,function (){
    				if(entry.code=="success"){
    					//reLoadChild(tid);
    					window.location.reload();
        			}
    			}); 
    		 });
        	
        },
        "iCancelHander":function(){
        	//取消
        },
        "iCloseHander": function(){
        	//右上角
        }
  	});
}

//右键重命名节点
function reNameNode() {
	hideRMenu();
	$('#msg').empty();
	var _boxName = "重命名节点";
	
	
	
	var currentNode=zTree.getSelectedNodes()[0] , 
			id =currentNode.id,
			tid =currentNode.tId;
	
	$("#addNodeName").attr("value",currentNode.name);
	
	$("#dialogFormWin").minInBox({
		"boxHeight": 220,
		"boxWidth": 400,
		"boxName": _boxName,
		"iSubmitHander":function (){
			//1.启用表单验证。
			var validateWidget = $("#dialogForm").validate();
			if (!validateWidget.check()) {//1.基础样式校验。
				return false;
			}
			var addNodeName = $('#addNodeName').val();
    		if(null == addNodeName || '' == addNodeName){
    			$('#msg').html("请填写节点名称");
    			return false;
    		}
			var nodeName = $("#dialogForm").find("#addNodeName").val(); 
			
			$.getJSON("/customers/lable/addOrUpdChild/0", {lableName :nodeName , id:id } , function(entry){
				layer.msg(entry.message,{time: 1000} ,function (){
					if(entry.code=="success"){
						//reLoadChild(ptid);
						currentNode.name=nodeName;
						zTree.updateNode(currentNode);
					}
				}); 
			});
			
		},
		"iCancelHander":function(){
			//取消
		},
		"iCloseHander": function(){
			//右上角
		}
	});
}
//右键菜单删除
function removeTreeNode() {
	hideRMenu();
	var nodes = zTree.getSelectedNodes();
	if (nodes && nodes.length > 0) {
		confirm(function (){
			  var  id = nodes[0].id   , tId = nodes[0].tId, pid=nodes[0].getParentNode().id;
			  $.getJSON("/customers/lable/delLable/"+id , function(entry){
					  
						  	if(entry.code=="success"){
						  		
			  					zTree.removeNode(nodes[0]);
			  					var parentNode =nodes[0].getParentNode();
			  					if (nodes[0].getParentNode().children.length>0){
			  						parentNode.hasChildren=true;
			  					}else {
			  						parentNode.hasChildren=false;	
			  					}
			  					zTree.updateNode(parentNode);
			  				 }
				  			layer.msg(entry.message,{time: 1000} ,function (){
				  			});
					 
		  		 });
			  
		});
		
	}
}
function resetTree() {
	hideRMenu();
	$.fn.zTree.init($("#tree"), setting, zNodes);
}


function hideRMenu() {
	if (rMenu) rMenu.css({"visibility": "hidden"});
	$("body").unbind("mousedown", onBodyMouseDown);
}

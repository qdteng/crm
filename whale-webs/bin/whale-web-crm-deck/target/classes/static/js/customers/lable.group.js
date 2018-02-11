var zTree, rMenu ,current_tid="tree_1";
$(function (){

	
	//树形菜单加载
	var parentName = $("#parentParam").attr("vname") ,
	parentId = $("#parentParam").attr("vid")  ,
	hasChildren=$("#parentParam").attr("hasChildren") , isSearch=false ;
	
	setting = {
    		view: {
    			selectedMulti: false
    		},callback: {
    			beforeClick: function (treeId, treeNode){
    				if (!isSearch){
    					current_tid=treeNode.tId;
	    				//可加载子节点的
	    				if(treeNode.hasChildren||treeNode.id==0){
	    					reLoadChild(current_tid);
	    				}
    				}
    			},
    			beforeExpand: function (treeId, treeNode){
    				if (!isSearch){
    					current_tid=treeNode.tId;
	    				//可加载子节点的
	    				if(treeNode.hasChildren||treeNode.id==0){
	    					reLoadChild(current_tid);
	    				}
    				}
    			},
    			onRightClick: function  (event, treeId, treeNode) {
    				
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
    	});
    	//搜索按钮
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
    	//点击右移箭头左边箭头添加至右边
    	$(".leftToRight").click(function(){
    		if (zTree.getSelectedNodes().length>0){
    			var currentNode = zTree.getSelectedNodes()[0];
    			//console.log(currentNode);
    			//二级节点下的所有子节点
    			if (currentNode.children.length>0&&currentNode.tId!="tree_1"){
    				for (var node  in currentNode.children){
    					if (!checkNodeInRightSelExist(currentNode.children[node])){
    						$("#rightSel").append('<option value="'+currentNode.children[node].id+'" >'+currentNode.children[node].name+'</option>');
    					}
    				}
    			}else {
    			//三级节点
    				if (!checkNodeInRightSelExist(currentNode) && !currentNode.hasChildren){
						$("#rightSel").append('<option value="'+currentNode.id+'" >'+currentNode.name+'</option>');
					}
    			}
    			
    		}else {
    			alert ("请选中树形标签类别名称");
    		}
    	});
    	//删除按钮
    	$(".deleteBtn").click(function(){
    		if ($("#rightSel option:selected").length<1){
    			alert("请选中需要删除的标签！");
    		}else{
    			$("#rightSel option:selected").remove();
    		}
    	});
});
//重复提交
var repeat=false; 
//保存标签分组
function saveLableGroup(parentDoc){
	if(!repeat){
	
		$("#rightSel option").each(function (){
			$(this).attr("selected","selected");
		});
		$frm = $("#sub_frm");
	    var validateWidget = $frm.validate();
		//1.启用表单验证。
		if (!validateWidget.check()) {//1.基础样式校验。
			return false;
		}
		
		repeat=true;
		//提交表单
		$frm.ajaxSubmit({success: function(entry, statusText, xhr, $form){
			
			if(entry.code=="success"){
				$(parentDoc).find("#searchForm").find("#groupName").attr("value",entry.values.groupName);
				$(parentDoc).find("#searchForm").submit();
			}else {
				repeat=false;
			}
			layer.msg(entry.message,{time: 2000} ,function (){
			}); 
			 
		}});
	}
}

//保存标签分组 ,此方法供编辑窗体调用
function subForm(parentDoc){
	
	saveLableGroup(parentDoc);
}

//检查左边选中的node在右边是否存在
function checkNodeInRightSelExist(node){
	var  exist = false ; 
	$("#rightSel option").each(function (){
		var currentOption = $(this); 
		if (currentOption.val()==node.id){
			exist=true;
		}
	});
	return exist;
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


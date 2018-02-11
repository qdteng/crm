<!DOCTYPE html>  
<html xmlns:th="http://www.thymeleaf.org" 
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layouts/dialog" >  
	
    <head>
    	<meta charset="utf-8"></meta>
        <title>${ftl_description}</title>
    </head>  
    <body style="text-align:center;" >
		<div layout:fragment="content" >
    		<div style="margin-top: 20px; text-align:left;">
			     <form id="subForm" action="/${entityName?uncap_first}/save" method="post" class="form-horizontal">
			     	<input id="id" name="id" type="hidden"  th:value="${'$'}{entity}?${'$'}{${'entity.id'}}:''"  />
				    <#list columns as po>
			     	<#if po.fieldType?index_of("date")==-1> 
			     	 <div class="cl mb5 addhy">
			     		<p>
			     			<label><i class="f-red">* </i>${po.filedComment}:</label>
			     			<span>
				     			<input class="w200 c_required c_maxlength_32"
				     			<#if po.classType=='easyui-datetimebox'>style="width: 150px"
				     			 <#elseif po.classType=='easyui-datebox'>style="width: 150px" <#else></#if>id="${po.fieldName}" name="${po.fieldName}" <#if po.nullable == 'Y'> </#if> 
							     <#if po.fieldType?index_of("time")!=-1><#else>  
							     <#if po.fieldType?index_of("date")!=-1>value="" <#else>th:value="${'$'}{entity}?${'$'}{${'entity'}.${po.fieldName}}:''" </#if>
							     </#if><#if po.optionType?trim?length !=0> datatype="${po.optionType}"</#if> type='text'  placeholder="请输入" />
			     			</span>
			     		</p>
			     	 </div>
			     	</#if>
			     	</#list>
		    	</form>
			</div>
		</div>
		    <!-- 脚本区域（弹框、脚本） -->
			<div layout:fragment="javascript">
			    <script type="text/javascript">
			  	//<![CDATA[
			    	//重复提交
			   		var repeat =  true ;
			    	function subForm(parentWin){
			    		if (!repeat){
			    			return ;
			    		}
			    		$frm = $("#subForm");
					    var validateWidget = $frm.validate();
			    		//1.启用表单验证。
			    		if (!validateWidget.check()) {//1.基础样式校验。
			    			repeat=true; 
			    			return false;
			    		}
			    		repeat = false;
			    		//提交表单
		        		$frm.ajaxSubmit({success: function(entry, statusText, xhr, $form){
		        			
		        			if(entry.code=="success"){
		        				$(parentWin).find("#searchForm").submit();
		        			}
		        			
	        				repeat=true; 
	        				
		        			layer.msg(entry.message,{time: 2000} ,function (){
		        			}); 
						}});
			    	}
			    //]]>
			    </script>
		    </div>
		    
	</body>
	
	
</html>
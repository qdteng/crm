package ${bussiPackage}.entity.${entityPackage};

import java.math.BigDecimal;
import java.util.Date;

import ${bussiPackage}.entity.BaseEntity;
/**   
 * @Title: Entity
 * @Description: ${ftl_description}
 * @author L.T.auto
 * @date ${ftl_create_time}
 * @version V1.0   
 */
@SuppressWarnings("serial")
public class ${entityName}Entity extends BaseEntity implements java.io.Serializable {
	<#list originalColumns as po>
	<#if po.fieldName != "id"&&po.fieldName != "createId"&&po.fieldName != "createName"&&po.fieldName != "createTime"&&po.fieldName != "updateId"&&po.fieldName != "updateName"&&po.fieldName != "updateTime">
		/**${po.filedComment}*/
		private ${po.fieldType} ${po.fieldName};
	</#if>
	</#list>
	
	<#list originalColumns as po>
	<#if po.fieldName != "id"&&po.fieldName != "createId"&&po.fieldName != "createName"&&po.fieldName != "createTime"&&po.fieldName != "updateId"&&po.fieldName != "updateName"&&po.fieldName != "updateTime">
	public ${po.fieldType} get${po.fieldName?cap_first}(){
		return this.${po.fieldName};
	}

	public void set${po.fieldName?cap_first}(${po.fieldType} ${po.fieldName}){
		this.${po.fieldName} = ${po.fieldName};
	}
	</#if>
	</#list>
}

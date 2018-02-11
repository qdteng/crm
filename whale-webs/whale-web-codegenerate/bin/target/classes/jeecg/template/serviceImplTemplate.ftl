package ${bussiPackage}.service.impl.${entityPackage};

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${bussiPackage}.service.${entityPackage}.${entityName}ServiceI;
import ${bussiPackage}.entity.${entityPackage}.${entityName}Entity;
import ${bussiPackage}.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**   
 * @Title: Entity
 * @Description: ${ftl_description}
 * @author L.T.auto
 * @date ${ftl_create_time}
 * @version V1.0   
 */
@Service("${entityName?uncap_first}Service")
@Transactional
public class ${entityName}ServiceImpl extends BaseServiceImpl<${entityName}Entity> implements ${entityName}ServiceI { 
	
	private static final Logger logger = LoggerFactory.getLogger(${entityName}ServiceImpl.class);
	@Override
	protected Class setClass() {
		return ${entityName}Entity.class;
	}
	
}
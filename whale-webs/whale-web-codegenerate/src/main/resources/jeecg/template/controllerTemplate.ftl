package ${bussiPackage}.controller.${entityPackage};
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ${bussiPackage}.controller.BasicController;
import com.github.pagehelper.PageInfo;
import cn.com.ylpw.web.crm.util.Page;
import ${bussiPackage}.entity.${entityPackage}.${entityName}Entity;
import ${bussiPackage}.service.${entityPackage}.${entityName}ServiceI;
import cn.com.ylpw.core.tools.AjaxResult;
import java.util.Map;
import org.springframework.ui.ModelMap;
import cn.com.ylpw.web.crm.util.SessionUtils;
import java.util.Date;

/**   
 * @Title: Controller
 * @Description: ${ftl_description}
 * @author L.T.auto
 * @date ${ftl_create_time}
 * @version V1.0   
 */
@Controller
public class ${entityName}Controller extends BasicController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(${entityName}Controller.class);
	@Autowired
	private ${entityName}ServiceI ${entityName?uncap_first}Service;

	/**
	 * ${ftl_description}列表 页面跳转
	 * @return
	 */
	@RequestMapping( "/${entityName?uncap_first}/list")
	public String list(HttpServletRequest request ,Page<Map<String,Object>> page, ModelMap model,
			@RequestParam(required=false) Map<String,Object> searchParam  ) {
			logger.info("加载${ftl_description}列表");
	    	PageInfo<Map<String,Object>>  pageInfo =${entityName?uncap_first}Service.pageFindModel( "pageFind", page, searchParam);
			model.put("dateList", pageInfo.getList());
			model.put("page",  page );
			model.put("searchParam", searchParam);
			return "/${entityPackage}/${entityName?uncap_first}List";
	}


	/**
	 * 删除${ftl_description}
	 * @return
	 */
	@RequestMapping( "/${entityName?uncap_first}/del")
	@ResponseBody
	public AjaxResult del(Long [] ids, HttpServletRequest request) {
		AjaxResult  ajaxResult = AjaxResult.Instance();
		if(ids.length>0){
			logger.info("批量删除ID{}" , ids);
			${entityName?uncap_first}Service.batchDel(ids) ;
		}
		return ajaxResult;
	}


	/**
	 * 处理页面的添加或更新请求${ftl_description}
	 * @param ids
	 * @return
	 */
	@RequestMapping( "/${entityName?uncap_first}/save")
	@ResponseBody
	public AjaxResult save(${entityName}Entity ${entityName?uncap_first}, HttpServletRequest request) {
		String message = null;
		AjaxResult j = AjaxResult.Instance();
		if (null!=${entityName?uncap_first}.getId() && ${entityName?uncap_first}.getId()>0   ) {
			message = "${ftl_description}更新成功";
			try {
				${entityName?uncap_first}.setUpdateId(SessionUtils.currentUser().getId());
				${entityName?uncap_first}.setUpdateName(SessionUtils.currentUser().getName());
				${entityName?uncap_first}.setUpdateTime(new Date());
				${entityName?uncap_first}Service.updateByPrimaryKeySelective(${entityName?uncap_first}) ;
			} catch (Exception e) {
				e.printStackTrace();
				message = "${ftl_description}更新失败";
			}
		}else{
			message = "${ftl_description}添加成功";
			${entityName?uncap_first}.setCreateTime(new Date());
			${entityName?uncap_first}.setCreateId(SessionUtils.currentUser().getId());
			${entityName?uncap_first}.setCreateName(SessionUtils.currentUser().getName());
			${entityName?uncap_first}Service.insertSelective(${entityName?uncap_first});
		}
		j.setMessage(message);
		return j;
	}

	/**
	 * ${ftl_description}跳转 添加或更新的页面
	 * @return
	 */
	@RequestMapping( "/${entityName?uncap_first}/addorupdate")
	public String addorupdate( Long id,ModelMap model, HttpServletRequest req) {
	
		if(null != id && id > 0){
			${entityName}Entity entity = ${entityName?uncap_first}Service.selectByPrimaryKey(id);
			model.put("entity", entity);
			model.put("id", id);
		}
		return "/${entityPackage}/${entityName?uncap_first}";
	}
	
}

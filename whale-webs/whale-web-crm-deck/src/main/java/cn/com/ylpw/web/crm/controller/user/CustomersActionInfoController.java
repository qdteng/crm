package cn.com.ylpw.web.crm.controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.web.crm.service.other.ShortageRecordService;
import cn.com.ylpw.web.crm.service.other.SuggestService;
import cn.com.ylpw.web.crm.util.Page;

/***
 * @ClassName: customersActionInfoController
 * @Description:行为信息相关查询
 * @author LT
 * @date 2017年5月4日 下午2:06:12
 */
@Controller("customersActionInfoController")
public class CustomersActionInfoController {
  
  private static final Logger logger = LoggerFactory.getLogger(CustomersActionInfoController.class);
  
  @Autowired
  private ShortageRecordService shortageRecordService ;
  
  @Autowired
  private SuggestService suggestService ;
  
  
  /***
   * <p>缺货登记</p>
   * @author LT
   * @date 2017年5月16日 下午1:22:59
   * @return String
   * @param searchParam
   * @param page
   * @param req
   * @param model
   * @param id
   * @return
   */
  @RequestMapping("/customers/shortagerecord/list/{id}")
	public String shortagerecordList(@RequestParam(required=false) Map<String,Object> searchParam  ,
			Page<Map<String,Object>> page,
			HttpServletRequest req, ModelMap model ,@PathVariable(name="id")  Long id ){
		logger.info("加载缺货登记");
		searchParam.put("customerid", id);
		PageInfo<Map<String,Object>>  pageInfo =shortageRecordService.pageFindModel("findAll", page, searchParam);
		
		model.put("dateList", pageInfo.getList());
		model.put("page",  page );
		model.put("searchParam", searchParam);
		model.put("customerid", id);
	    return "/customers/deatil_shortagerecord_list";
  }
  
  /**
   * <p>意见建议</p>
   * @author LT
   * @date 2017年5月16日 下午1:53:16
   * @return String
   * @param searchParam
   * @param page
   * @param req
   * @param model
   * @param id
   * @return
   */
  @RequestMapping("/customers/suggest/list/{id}")
  public String suggestList(@RequestParam(required=false) Map<String,Object> searchParam  ,
		  Page<Map<String,Object>> page,
		  HttpServletRequest req, ModelMap model ,@PathVariable(name="id")  Long id ){
	  logger.info("加载意见建议");
	  searchParam.put("customerid", id);
	  PageInfo<Map<String,Object>>  pageInfo =suggestService.pageFindModel("findAll", page, searchParam);
	  
	  model.put("dateList", pageInfo.getList());
	  model.put("page",  page );
	  model.put("searchParam", searchParam);
	  model.put("customerid", id);
	  return "/customers/deatil_suggest_list";
  }
  
  
}

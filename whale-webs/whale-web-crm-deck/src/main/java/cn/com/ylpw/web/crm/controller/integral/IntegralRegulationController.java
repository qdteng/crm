package cn.com.ylpw.web.crm.controller.integral;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.core.tools.AjaxResult;
import cn.com.ylpw.core.tools.AjaxResult.ResultCode;
import cn.com.ylpw.web.crm.controller.system.DictionarieController;
import cn.com.ylpw.web.crm.entity.customer.TCustomerGrade;
import cn.com.ylpw.web.crm.entity.customer.TCustomerIntegralLimit;
import cn.com.ylpw.web.crm.service.customer.CustomerGradeService;
import cn.com.ylpw.web.crm.service.customer.CustomerIntegralLimitService;
import cn.com.ylpw.web.crm.util.Page;
import cn.com.ylpw.web.crm.util.SessionUtils;

/***
 * @ClassName: IntegralRegulation
 * @Description:积分规则设置
 * @author LT
 * @date 2017年8月28日 上午10:28:05
 */

@Controller("integralRegulation")
public class IntegralRegulationController {
	
	private static final Logger logger = LoggerFactory.getLogger(DictionarieController.class);
	  
	  @Autowired
	  private  CustomerGradeService customerGradeService ; 
	  @Autowired
	  private  CustomerIntegralLimitService customerIntegralLimitService ; 
	  
	  /**
	   * <p>积分规则设置页面</p>
	   * @author LT
	   * @date 2017年8月29日 上午10:52:38
	   * @return String
	   * @param page
	   * @param req
	   * @param model
	   * @return
	   */
	  @RequestMapping("/integralLimit/list")
	  public String limitList(
				Page<Map<String,Object>> page,
				HttpServletRequest req,
				ModelMap model){
		  
			logger.info("加载积分规则限制");
			page.setPageSize(Integer.MAX_VALUE);
			PageInfo<Map<String, Object>> resultPage = customerGradeService.pageFindModel("findByIntegralLimit", page, null);
			
			TCustomerIntegralLimit integralLimit =  customerIntegralLimitService.findCurrentCustomerIntegralLimit();
			
			model.put("dateList", resultPage.getList());
			model.put("page",  page );
			model.put("integralLimit", integralLimit);
			return "/integralLimit/list";
			
		}
	  
	  /**
	   * <p>保存用户等级对应的积分倍数</p>
	   * @author LT
	   * @date 2017年8月29日 上午10:52:52
	   * @return AjaxResult
	   * @param id
	   * @param integralMultiple
	   * @param page
	   * @param req
	   * @param model
	   * @return
	   */
	  @RequestMapping("/integralLimit/updLimitMultiple")
	  @ResponseBody
	  public AjaxResult updLimitMultiple( Long id , Float  integralMultiple ,
			  Page<Map<String,Object>> page,
			  HttpServletRequest req,
			  ModelMap model ){
		  AjaxResult  ar = new AjaxResult(); 
		  TCustomerGrade old  = customerGradeService.selectByPrimaryKey(id) ;
		  if(null==old){
			  ar.setCode(ResultCode.error);
			  ar.setMessage("更新失败，会员等级不存在！");  
		  }
		  logger.info("更新 {} 的积分倍数 : {} ",old.getGname() , integralMultiple);
		  
		  
		  
		  TCustomerGrade grade = new TCustomerGrade() ;
		  grade.setId(id);
		  grade.setIntegralMultiple(integralMultiple);
		  customerGradeService.updateByPrimaryKeySelective(grade);
		  return ar;
	  }
	  
	  /**
	   * <p>保存积分有效期</p>
	   * @author LT
	   * @date 2017年8月29日 上午10:53:14
	   * @return AjaxResult
	   * @param type
	   * @param dateVal
	   * @param page
	   * @param req
	   * @param model
	   * @return
	   */
	  @RequestMapping("/integralLimit/saveLimit")
	  @ResponseBody
	  public AjaxResult saveLimit( Integer type , String  dateVal,
			  Page<Map<String,Object>> page,
			  HttpServletRequest req,
			  ModelMap model ){
		  AjaxResult  ar = new AjaxResult(); 
		  TCustomerIntegralLimit  customerIntegralLimit = new TCustomerIntegralLimit() ; 
		  customerIntegralLimit.setType(type);
		  customerIntegralLimit.setDateVal(dateVal);
		  customerIntegralLimit.setUpdateId(SessionUtils.currentUser().getId());
		  customerIntegralLimit.setUpdateName(SessionUtils.currentUser().getName());
		  customerIntegralLimit.setUpdateTime(new Date());
		  
		  customerIntegralLimitService.saveLimit(customerIntegralLimit);
		  
		  
		  return ar;
	  }
		
	
}

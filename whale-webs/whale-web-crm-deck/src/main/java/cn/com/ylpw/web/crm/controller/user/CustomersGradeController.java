package cn.com.ylpw.web.crm.controller.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.ylpw.core.tools.AjaxResult;
import cn.com.ylpw.web.crm.entity.customer.TCustomerGrade;
import cn.com.ylpw.web.crm.entity.customer.TCustomerGradeRight;
import cn.com.ylpw.web.crm.entity.customer.TCustomers;
import cn.com.ylpw.web.crm.entity.sys.SysDictionarie;
import cn.com.ylpw.web.crm.service.customer.CustomerGradeRightService;
import cn.com.ylpw.web.crm.service.customer.CustomerGradeService;
import cn.com.ylpw.web.crm.util.Page;
import cn.com.ylpw.web.crm.util.SessionUtils;

import com.github.pagehelper.PageInfo;

/**
 * @ClassName:  CustomersGradeController
 * @Description:会员体系-等级管理
 * @author LT
 * @date 2017年5月22日 下午1:25:42
 */
@Controller("customersGradeController")
public class CustomersGradeController {
  
  private static final Logger logger = LoggerFactory.getLogger(CustomersGradeController.class);
  
  @Autowired
  private CustomerGradeService customerGradeService;
  
  @Autowired
  private CustomerGradeRightService customerGradeRightService;
 
   @RequestMapping("/customers/grade/list")
	public String gradeList( @RequestParam(required=false) Map<String,Object> searchParam  ,
			Page<Map<String,Object>> page,@RequestParam(required=false ,name="QUANYI")  String [] quanyi ,
			HttpServletRequest req, ModelMap model  ){
		logger.info("等级管理");
		searchParam.put("QUANYI",   quanyi);
		PageInfo<Map<String,Object>>  pageInfo =  customerGradeService.pageFindModel("findAll", page, null) ;
		
		
		model.put("dateList", pageInfo.getList());
		model.put("page",  page );
		
		model.put("searchParam", searchParam);
	    return "/customers/grade/list";
	}
   
   /***
	 * <p>添加更新会员等级展示页</p>
	 * @author WY
	 * @date 2017年5月23日 下午6:16:56
	 * @return String
	 * @param @RequestParam(required=false) Long id
	 * @return
	 
	 */
	@RequestMapping("/customers/grade/showDetail")
	public String showDetail(@RequestParam(required=false) Long id, @RequestParam(required=false) Map<String,Object> searchParam, @RequestParam(required=false ,name="QUANYI")  String [] quanyi, ModelMap model){
		if (null!=id&&id>0){
			TCustomerGrade cg =  customerGradeService.selectByPrimaryKey(id); 
			model.addAttribute("detail", cg);
			//得到会员权益
			List<Map<String, Object>> customerQuyiList = customerGradeRightService.findByCustomerGradeid(cg.getId());
			if(null != customerQuyiList && customerQuyiList.size() > 0){
				StringBuffer sb = new StringBuffer();
				for(Map<String, Object> map : customerQuyiList){
					sb.append(map.get("scode")).append(",");
				}
				quanyi = sb.toString().split(",");
			}
		}
		searchParam.put("QUANYI",   quanyi);
		model.put("searchParam", searchParam);
		return "/customers/grade/detail";
	}
   
   @RequestMapping("/customers/grade/saveOrUpdate")
	public @ResponseBody AjaxResult saveOrUpdate( @RequestParam(required=false) Map<String,Object> searchParam,
			Page<Map<String,Object>> page,@RequestParam(required=false ,name="QUANYI") String [] quanyi,
			HttpServletRequest req, ModelMap model, @ModelAttribute TCustomerGrade cg, BindingResult br){
		logger.info("新建/更新等级管理");
		AjaxResult ajxresult = AjaxResult.Instance();
		searchParam.put("QUANYI", quanyi);
		
		Boolean b = customerGradeService.saveOrUpdate(cg, quanyi, searchParam);
		if(!b){
			ajxresult.addError("操作失败");
			return ajxresult;
		}
		
		PageInfo<Map<String,Object>>  pageInfo =  customerGradeService.pageFindModel("findAll", page, null) ;
		
		model.put("dateList", pageInfo.getList());
		model.put("page",  page );
		
		model.put("searchParam", searchParam);
		return ajxresult;
	    //return "/customers/grade/list";
	}
   
   @RequestMapping("/customers/grade/delCustomerGrade")
	public @ResponseBody AjaxResult delCustomerGrade(@RequestParam(required=false) Long id){
		logger.info("删除会员等级");
		AjaxResult ajxresult = AjaxResult.Instance();
		Integer b = 0;
		if(null != customerGradeService.selectByPrimaryKey(id) && !customerGradeService.isUse(id)){
			b = customerGradeService.deleteByPrimaryKey(id);
		}else{
			ajxresult.addError("等级不存在或该等级已被使用，删除失败");
		}
		return ajxresult;
	}
   
   @RequestMapping("/customers/grade/updateEnable")
	public @ResponseBody AjaxResult updateEnable(@RequestParam(required=false) Long id, @RequestParam(required=false) Integer enable){
		logger.info("更新会员等级状态");
		AjaxResult ajxresult = AjaxResult.Instance();
		TCustomerGrade cg = customerGradeService.selectByPrimaryKey(id);
		if(null != cg){
			if(0 == enable){
				cg.setIsEnable(1);
			}else{
				cg.setIsEnable(0);
			}
			customerGradeService.updateByPrimaryKeySelective(cg);
		}else{
			ajxresult.addError("操作失败");
		}
		return ajxresult;
	}

}

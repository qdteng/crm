package cn.com.ylpw.web.crm.controller.user;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.ylpw.core.tools.AjaxResult;
import cn.com.ylpw.web.crm.controller.BasicController;
import cn.com.ylpw.web.crm.entity.customer.TCustomerIndexActive;
import cn.com.ylpw.web.crm.service.customer.CustomerIndexActiveService;
import cn.com.ylpw.web.crm.service.customer.CustomerIndexRecencyService;
import cn.com.ylpw.web.crm.service.customer.CustomerIndexRfmService;
import cn.com.ylpw.web.crm.service.customer.CustomerIndexService;
import cn.com.ylpw.web.crm.util.Page;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @ClassName: CustomersIndexController
 * @Description:会员体系-成长值
 * @author LT
 * @date 2017年6月1日 下午2:42:57
 */
@Controller("customersIndexController")
public class CustomersIndexController extends BasicController {
  
  private static final Logger logger = LoggerFactory.getLogger(CustomersIndexController.class);
  
  @Autowired
  private CustomerIndexService customerIndexService;
  @Autowired
  private CustomerIndexRfmService customerIndexRfmService;
  @Autowired
  private CustomerIndexRecencyService customerIndexRecencyService;
  @Autowired
  private CustomerIndexActiveService customerIndexActiveService;
  
  /**
   * <p>会员成长值管理</p>
   * @author LT
   * @date 2017年6月1日 下午2:53:45
   * @return String
   * @param searchParam
   * @param page
   * @param req
   * @param model
   * @return
   */
   @RequestMapping("/customers/indexPanel")
	public String indexPanel( @RequestParam(required=false) Map<String,Object> searchParam,
			Page<Map<String,Object>> page,
			HttpServletRequest req, ModelMap model){
		logger.info("成长值管理");
		List<Map<String,Object>> list = customerIndexService.findByParam(searchParam);
		for(Map<String,Object> ci : list){
			if(ci.get("MTYPE").toString().equals("1")){
				model.addAttribute("rfmval",ci.get("MTYPE").toString());
				model.addAttribute("rfmvalIsOpen",ci.get("IS_OPEN").toString());
				model.addAttribute("rfmvalScale",ci.get("SCALE").toString());
			}
			if(ci.get("MTYPE").toString().equals("2")){
				model.addAttribute("recencyval",ci.get("MTYPE").toString());
				model.addAttribute("recencyvalIsOpen",ci.get("IS_OPEN").toString());
				model.addAttribute("recencyvalScale",ci.get("SCALE").toString());
						}
			if(ci.get("MTYPE").toString().equals("3")){
				model.addAttribute("activeval",ci.get("MTYPE").toString());
				model.addAttribute("activevalIsOpen",ci.get("IS_OPEN").toString());
				model.addAttribute("activevalScale",ci.get("SCALE").toString());
			}
		}
		model.addAttribute("list",list);
	    return "/customers/index_panel";
	}
   
   @RequestMapping("/customers/index/upOpen")
	public @ResponseBody AjaxResult upOpen(@RequestParam(required=false) Long id, @RequestParam(required=false) String rfmval, @RequestParam(required=false) String recencyval, @RequestParam(required=false) String activeval){
		logger.info("成长值-开关操作");
		AjaxResult ajxresult = AjaxResult.Instance();
		Map<String,Object> searchParam = Maps.newHashMap();
		List<Map<String,Object>> list = customerIndexService.findByParam(searchParam);
		customerIndexService.upOpen(list, rfmval, recencyval, activeval, id);
		return ajxresult;
	}

   @RequestMapping("/customers/index/indexManager/{mtype}")
	public String indexRfmManager( @RequestParam(required=false) Map<String,Object> searchParam,
			Page<Map<String,Object>> page,@PathVariable(name="mtype") Integer mtype,
			HttpServletRequest req, ModelMap model){
	   if(1 == mtype){
		   logger.info("成长值-RFM指标管理");
		   //searchParam.put("", null);
		   PageInfo<Map<String,Object>>  pageInfo = customerIndexRfmService.pageFindModel("findAll", page, searchParam);
		   List<Map<String,Object>> plusList = Lists.newArrayList();
		   List<Map<String,Object>> negiList = Lists.newArrayList();
		   for(Map<String,Object> map: pageInfo.getList()){
			   if(null != map.get("IS_LOSS") && map.get("IS_LOSS").toString().equals("0")){
				   plusList.add(map);
			   }else{
				   negiList.add(map);
			   }
		   }
		   model.put("plusList", plusList);
		   model.put("negiList", negiList);
		   return "/customers/index/list_rfm";
	   }else if (2 == mtype){
		   logger.info("成长值-recency指标管理");
		   //searchParam.put("", null);
		   PageInfo<Map<String,Object>>  pageInfo =  customerIndexRecencyService.pageFindModel("findAll", page, searchParam);
		   //1每消费2一次性消费3.每充值4一次性充值
		   List<Map<String,Object>> list1 = Lists.newArrayList();
		   List<Map<String,Object>> list2 = Lists.newArrayList();
		   List<Map<String,Object>> list3 = Lists.newArrayList();
		   List<Map<String,Object>> list4 = Lists.newArrayList();
		   model.put("isEnableXF", "1");//消费开关默认为开
		   model.put("isEnableCZ", "1");//充值开关默认为开
		   if(null != pageInfo.getList() && pageInfo.getList().size() > 0){
			   for(Map<String, Object> map : pageInfo.getList()){
				   if(null != map.get("MTYPE")){
					   if(map.get("MTYPE").toString().equals("1")){
						   list1.add(map);
						   model.put("isEnableXF", map.get("IS_ENABLE").toString());
					   }
					   if(map.get("MTYPE").toString().equals("2")){
						   list2.add(map);
						   model.put("isEnableXF", map.get("IS_ENABLE").toString());
					   }
					   if(map.get("MTYPE").toString().equals("3")){
						   list3.add(map);
						   model.put("isEnableCZ", map.get("IS_ENABLE").toString());
					   }
					   if(map.get("MTYPE").toString().equals("4")){
						   list4.add(map);
						   model.put("isEnableCZ", map.get("IS_ENABLE").toString());
					   }
				   }
			   }
		   }
		   model.put("list1", list1);
		   model.put("list2", list2);
		   model.put("list3", list3);
		   model.put("list4", list4);
		   return "/customers/index/list_recency";
	   }else{
		   logger.info("成长值-active指标管理");
		   //searchParam.put("", null);
		   PageInfo<Map<String,Object>>  pageInfo =  customerIndexActiveService.pageFindModel("findAll", page, searchParam);
		   List<TCustomerIndexActive> list2 = new ArrayList<TCustomerIndexActive>();
		   if(null != pageInfo && pageInfo.getList().size() > 0){
			   for(Map<String, Object> map : pageInfo.getList()){
				   if(null != map.get("ATYPE")){
					   switch(Integer.parseInt(map.get("ATYPE").toString())){
					   		case 1://每日签到
					   			searchParam.put("aindex1", map.get("AINDEX"));
					   			searchParam.put("isEnable1", map.get("IS_ENABLE"));
					   			model.put("isEnable1", map.get("IS_ENABLE"));
					   			break;
					   		case 2://连续签到
					   			
					   			searchParam.put("isEnable1", map.get("IS_ENABLE"));
					   			model.put("isEnable1", map.get("IS_ENABLE"));
					   			list2.add(customerIndexActiveService.selectByPrimaryKey(Long.parseLong(map.get("ID").toString())));
					   			break;
					   		case 3://每次分享
					   			searchParam.put("aindex3", map.get("AINDEX"));
					   			searchParam.put("isEnable2", map.get("IS_ENABLE"));
					   			model.put("isEnable2", map.get("IS_ENABLE"));
					   			break;
					   		case 4://最多分享
					   			searchParam.put("aindex4", map.get("AINDEX"));
					   			searchParam.put("isEnable2", map.get("IS_ENABLE"));
					   			model.put("isEnable2", map.get("IS_ENABLE"));
					   			break;
					   		case 5://每次订阅
					   			searchParam.put("aindex5", map.get("AINDEX"));
					   			searchParam.put("isEnable3", map.get("IS_ENABLE"));
					   			model.put("isEnable3", map.get("IS_ENABLE"));
					   			break;
					   		case 6://最多订阅
					   			searchParam.put("aindex6", map.get("AINDEX"));
					   			searchParam.put("isEnable3", map.get("IS_ENABLE"));
					   			model.put("isEnable3", map.get("IS_ENABLE"));
					   			break;
					   		case 7://领卡
					   			searchParam.put("aindex7", map.get("AINDEX"));
					   			searchParam.put("isEnable4", map.get("IS_ENABLE"));
					   			model.put("isEnable4", map.get("IS_ENABLE"));
					   			break;
					   }
				   }
			   }
		   }
		   model.put("list2", list2);
		   model.put("searchParam", searchParam);
		   return "/customers/index/list_active";
	   }
	   
	}
   
   @RequestMapping("/customers/index/saveOrUpdateRfm")
	public @ResponseBody AjaxResult saveOrUpdateRfm (String[] recency, String[] rindex, String[] frequency, String[] findex, String[] monetary, String[] mindex, String[] isLoss, String[] id,
			HttpServletRequest req, ModelMap model){
		logger.info("成长值-RFM指标管理-保存");
		AjaxResult ajxresult = AjaxResult.Instance();
		Map<String,Object> searchParam = Maps.newHashMap();
		searchParam.put("mtype", 1);
		List<Map<String,Object>> list = customerIndexService.findByParam(searchParam);
		//List<TCustomerIndexRfm> cirList = Arrays.asList();
		customerIndexRfmService.saveOrUpdateRfm(recency, rindex, frequency, findex, monetary, mindex, isLoss, id, Long.parseLong(list.get(0).get("ID").toString()));
	    return ajxresult;
	}
   
   @RequestMapping("/customers/index/saveOrUpdateRecency")
	public @ResponseBody AjaxResult saveOrUpdateRecency (Integer isEnableXF, Integer isEnableCZ, String monetary1, String monetary2,
			String mindex1, String mindex2, String[] monetarys1, String[] monetarys2, String[] mindexs1, String[] mindexs2, 
			HttpServletRequest req, ModelMap model){
		logger.info("成长值-消费激励指标管理-保存");
		AjaxResult ajxresult = AjaxResult.Instance();
		Map<String,Object> searchParam = Maps.newHashMap();
		searchParam.put("mtype", 2);
		List<Map<String,Object>> list = customerIndexService.findByParam(searchParam);
		//List<TCustomerIndexRfm> cirList = Arrays.asList();
		customerIndexRecencyService.saveOrUpdateRecency(isEnableXF, isEnableCZ, monetary1, monetary2, mindex1, mindex2, monetarys1, monetarys2, mindexs1, mindexs2, Long.parseLong(list.get(0).get("ID").toString()));
	    return ajxresult;
	}
   
   @RequestMapping("/customers/index/saveOrUpdateActive")
	public @ResponseBody AjaxResult saveOrUpdateActive (@RequestParam(required=false) Map<String,Object> searchParam, String[] aindexs, String[] anums, String[] id,
			HttpServletRequest req, ModelMap model){
		logger.info("成长值-会员活动指标管理-保存");
		AjaxResult ajxresult = AjaxResult.Instance();
		//Map<String,Object> searchParam = Maps.newHashMap();
		searchParam.put("mtype", 3);
		//model.put("searchParam", searchParam);
		List<Map<String,Object>> list = customerIndexService.findByParam(searchParam);
		//List<TCustomerIndexRfm> cirList = Arrays.asList();
		customerIndexActiveService.saveOrUpdateActive(searchParam, aindexs, anums, Long.parseLong(list.get(0).get("ID").toString()));
	    return ajxresult;
	}
}


package cn.com.ylpw.web.crm.controller.user;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.google.common.collect.Maps;

import cn.com.ylpw.core.tools.AjaxResult;
import cn.com.ylpw.web.crm.entity.customer.TCustomers;
import cn.com.ylpw.web.crm.model.importVO.TCustomersImportVO;
import cn.com.ylpw.web.crm.service.customer.CustomerGradeService;
import cn.com.ylpw.web.crm.service.customer.CustomerJoinNodeService;
import cn.com.ylpw.web.crm.service.customer.CustomerService;
import cn.com.ylpw.web.crm.service.sys.DictionarieService;
import cn.com.ylpw.web.crm.util.ExcelUtil;
import cn.com.ylpw.web.crm.util.Page;
import jxl.write.WritableCell;

/**
 * @ClassName: CustomersController
 * @Description:会员
 * @author Wangyang
 * @date 2017年4月24日 下午2:51:27
 */
@Controller("customersController")
public class CustomersController {
  
  private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);
  
  @Autowired
  private  CustomerService customerService ;
  
  @Autowired
  private  CustomerGradeService customerGradeService ; 
  
  @Autowired
  private  DictionarieService dictionarieService; 
  
  
  @Autowired
  private CustomerJoinNodeService  customerJoinNodeService;
	
	@RequestMapping("/customers/list")
	public String list( @RequestParam(required=false) Map<String,Object> searchParam  ,
			@RequestParam(required=false ,name="ORDERSOURCE")  String [] orderSource ,
			Page<Map<String,Object>> page,
			HttpServletRequest req, ModelMap model){
		logger.info("加载会员信息列表");
		searchParam.put("ORDERSOURCE",   orderSource);
		
		
    	PageInfo<Map<String,Object>>  pageInfo =customerService.pageFindModel( page, searchParam);
    	
		model.put("dateList", pageInfo.getList());
		model.put("page",  page );
		
		Page<Map<String,Object>> greadeSearchParam = new Page<Map<String,Object>>();
		greadeSearchParam.setPageSize(Integer.MAX_VALUE);
		
		model.put("customerGrades", customerGradeService.pageFindModel("findGrades", greadeSearchParam, null).getList());
    	
	
		
		model.put("searchParam", searchParam);
	    return "/customers/list";
	}
	
	/***
	 * <p>更新营销屏蔽</p>
	 * @author LT
	 * @date 2017年5月4日 上午10:50:09
	 * @return AjaxResult
	 * @param ids
	 * @return
	 
	 */
	@RequestMapping("/customers/updShield")
	public @ResponseBody AjaxResult  updShield(Long [] ids){
		
		AjaxResult  ajaxResult = AjaxResult.Instance(); 
		if(ids.length>0){
			logger.info("营销屏蔽ID{}" , ids);
			customerService.updShieldBatch(ids) ;
		}
		return ajaxResult;
	}
	
	/**
	 * <p>会员信息</p>
	 * @author LT
	 * @date 2017年5月4日 下午1:53:03
	 * @return String
	 * @param id
	 * @param req
	 * @param model
	 * @return
	 
	 */
	@RequestMapping("/customers/detail/{id}")
	public String detail(
			@PathVariable(name="id")  Long id , 
			HttpServletRequest req, ModelMap model){
		logger.info("加载会员信息");
		model.put("customer", this.customerService.selectByPrimaryKey(id));
	    return "/customers/deatil_panel";
	}
	/**
	 * <p>会员信息-基本信息</p>
	 * @author LT
	 * @date 2017年5月4日 下午1:53:21
	 * @return String
	 * @param id
	 * @param req
	 * @param model
	 * @return
	 
	 */
	@RequestMapping("/customers/detail/baseinfo/{id}")
	public String baseinfo(
			@PathVariable(name="id")  Long id , 
			HttpServletRequest req, ModelMap model){
		logger.info("加载会员信息");
		
		model.put("customers", this.customerService.selectByPrimaryKey(id));
		return "/customers/deatil_base_info";
	}
	
	/**
	 * @Description: 导入会员信息
	 * @author Wangyang
	 * @date 2017年5月4日 下午5:47:43
	 * @return void
	 * @param @RequestParam MultipartFile uploadFiles,
	 *            HttpServletRequest request
	 */
	@RequestMapping(value = "/customers/importCustomerInfo")
	public @ResponseBody
	Map<String, Object> importCustomerInfo(@RequestParam MultipartFile uploadFiles, 
			HttpServletRequest request)
			throws Exception {
		logger.info("开始导入会员……");
		Map<String, Object> map = Maps.newHashMap();
		List<Long> ids=   new ArrayList<Long> ();
		ids.add(64l);
		map.put("list", ids);
		
		PageInfo<Map<String, Object>> resultPage = dictionarieService.pageFindModel("findByPid", new Page<Map<String,Object>>(), map);
		if(null == resultPage || null == resultPage.getList() || resultPage.getList().size() < 1){
			map.put("message", "读取会员来源失败");
			return map;
		}
		List<Map<String, Object>> ordersource = resultPage.getList();
		if (0 == uploadFiles.getSize()) {
			map.put("message", "请上传文件");
			return map;
		}

		InputStream is = null;

		try {
			is = uploadFiles.getInputStream();
			ImportParams params = new ImportParams();
			params.setTitleRows(0);
			params.setHeadRows(1);
			params.setNeedSave(true);
			List<TCustomersImportVO> importCustomerInfoList = ExcelUtil.importExcel(is,
					TCustomersImportVO.class, params);// 导入的会员信息
			if (null != importCustomerInfoList && importCustomerInfoList.size() > 0) {
				for (TCustomersImportVO customersImportVO : importCustomerInfoList) {
					TCustomers customer = new TCustomers();
					//会员来源
					if(StringUtil.isEmpty(customersImportVO.getCustomerSource())){
						map.put("message", "会员来源不能为空");
						return map;
					}
					for(Map<String, Object> sourceMap : ordersource){
						if(null != sourceMap.get("CODE") && customersImportVO.getCustomerSource().equals(sourceMap.get("CODE").toString())){
							customer.setSysSource(customersImportVO.getCustomerSource());
							break;
						}
					}
					if(null == customer.getSysSource()){
						map.put("message", "会员来源格式不正确");
						return map;
					}
					if (null != customersImportVO.getSex()) {//性别
						if(!("男".equals(customersImportVO.getSex().trim()) || "女".equals(customersImportVO.getSex().trim()))){
							map.put("message", "性别不合法");
							return map;
						}
					}
					if (null != customersImportVO.getPhone()) {//手机号
						Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  
						Matcher m = p.matcher(customersImportVO.getPhone().trim());  
						if(!m.matches()){
							map.put("message", "手机号不合法");
							return map;
						}
					}
					if (null != customersImportVO.getEmail()) {
				        //正则表达式的模式
				        Pattern p = Pattern.compile("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$");
				        //正则表达式的匹配器
				        Matcher m = p.matcher(customersImportVO.getEmail().trim());
				        if(!m.matches()){
				        	map.put("message", "邮箱不合法");
							return map;
						}
					}
				}
				
				Integer count = customerService.importCustomerInfo(importCustomerInfoList, ordersource);
				map.put("message", "成功导入"+count+"条会员");
				// 导出问题数据
				//map.put("errNum", errImportList.size());
				// ***********************
				//session.setAttribute("errImportSignList", errImportList);
//				if(null!=errImportList&&errImportList.size()>0){
//					logger.info("报名信息导入失败，错误信息：{}",JSONObject.toJSONString(errImportList));
//				}
				// *****************
			} else {
				logger.info("会员导入失败，失败原因：导入数据为空");
				map.put("message", "会员导入失败，失败原因：导入数据为空");
				return map;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.info("会员导入失败");
			map.put("message", "会员导入失败");
			return map;
		} finally {
			if (null != is) {
				is.close();
			}
		}
		return map;
	}
	
	/***
	 * <p>会员资料导入展示页</p>
	 * @author WY
	 * @date 2017年5月5日 下午6:16:56
	 * @return AjaxResult
	 * @param 
	 * @return
	 
	 */
	@RequestMapping("/customers/showImportCustomerInfo")
	public String showImportCustomerInfo(){
		return "/customers/showImportCustomerInfo";
	}
	
	
	

	/**
	 * <p>会员信息</p>
	 * @author LT
	 * @date 2017年5月16日 下午2:14:44
	 * @return String
	 * @param id
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/customers/detail/info/{id}")
	public String info(
			@PathVariable(name="id")  Long id , 
			HttpServletRequest req, ModelMap model){
		logger.info("加载会员信息");
		Map<String,Object>  cus =this.customerService.findCustomerInfo(id);
		
		if (null!=cus.get("NOTE")){
			if(cus.get("NOTE").toString().contains(",")){
				cus.put("NOTE",   cus.get("NOTE").toString().split(",")   );
				cus.put("JOIN_NOTEID", cus.get("JOIN_NOTEID").toString().split(",") );	
			}else{
				
				cus.put("NOTE",    new String [] {cus.get("NOTE").toString()  } );
				cus.put("JOIN_NOTEID", new String []  {cus.get("JOIN_NOTEID").toString() }  );
			}
		}
		model.put("customers", cus);
		return "/customers/deatil_customer_info";
	}
	
	/***
	 * <p>删除标签</p>
	 * @author LT
	 * @date 2017年5月17日 上午9:09:38
	 * @return String
	 * @param id
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/customers/delnode/{id}")
	public @ResponseBody AjaxResult  delNode(
			@PathVariable(name="id")  Long id , 
			HttpServletRequest req, ModelMap model){
		AjaxResult  ajxresult = AjaxResult.Instance(); 
		logger.info("删除会员标签{}",id);
		this.customerJoinNodeService.deleteByPrimaryKey(id);
		
		return ajxresult;
	}
	
	/**
	 * <p>添加会员标签</p>
	 * @author LT
	 * @date 2017年5月17日 上午9:14:25
	 * @return String
	 * @param customerId
	 * @param nodeName
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/customers/addNode")
	public @ResponseBody AjaxResult  addNode(
			 Long customerId , String  cusNodeName ,
			HttpServletRequest req, ModelMap model){
		AjaxResult  ajxresult = AjaxResult.Instance(); 
		logger.info("添加会员标签");
		
		this.customerJoinNodeService.addNode(customerId,cusNodeName);
		
		return ajxresult;
	}
	
	/**
	 * <p>会员信息-基本信息-保存</p>
	 * @author WY
	 * @date 2017年5月18日 下午1:53:21
	 * @return AjaxResult
	 * @param TCustomers c
	 * @param BindingResult br
	 * @param model
	 * @return
	 
	 */
	@RequestMapping("/customers/update")
	public @ResponseBody AjaxResult saveOrUpdate(@ModelAttribute TCustomers c, BindingResult br){
		logger.info("更新会员信息");
		AjaxResult  ajxresult = AjaxResult.Instance(); 
		
		logger.info("更新会员ID{}" , c.getId());
		customerService.updateByPrimaryKeySelective(c) ;
		return ajxresult;
	}
	
	/**
	 * 
	 * @Description: 导出 导入报名的错误数据
	 * @author wangyang
	 * @date 2016-12-27 下午5:17:46
	 */
	@RequestMapping(value = "/customers/exportImportCModel")
	public void exportImportCModel(HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("导出下载模板");
		// 导出信息
		// excel标题
		String[] titles = null;
		String fileName = "导入模板";
		String encoding = "UTF-8";
		titles = new String[] { "会员来源", "昵称", "姓名", "性别", "手机号", "邮箱",
				"微博号", "微信号", "证件号", "会员标签" };

		List<String[]> contentsList = new ArrayList<String[]>();

		// 导出
		ExcelUtil.exportExcel2(fileName, encoding, titles, contentsList, 0,
				response, new ExcelUtil.callback() {
					@Override
					public WritableCell reload(int j, int rows,
							String value, String[] titles) {
						return null;
					}

					@Override
					public Boolean isReload() {
						return false;
					}

					@Override
					public String excute() {
						return "";
					}
				}, DateFormatUtils.format(new Date(), "yyyyMMddhhmmss")
						+ UUID.randomUUID().toString().substring(0, 3));
	}
	
	
	@RequestMapping("/validateSession")
	public @ResponseBody String validateSession(HttpServletRequest request, HttpServletResponse response){
		return "1";
	}
	
}

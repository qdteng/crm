package cn.com.ylpw.web.crm.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.core.tools.AjaxResult;
import cn.com.ylpw.web.crm.entity.customer.TCustomerGroup;
import cn.com.ylpw.web.crm.entity.usable.TFiles;
import cn.com.ylpw.web.crm.model.CustomerLableGroup;
import cn.com.ylpw.web.crm.model.RedisKeys;
import cn.com.ylpw.web.crm.service.customer.CustomerGradeService;
import cn.com.ylpw.web.crm.service.customer.CustomerGroupService;
import cn.com.ylpw.web.crm.service.customer.CustomerLableService;
import cn.com.ylpw.web.crm.service.other.FileService;
import cn.com.ylpw.web.crm.util.ExcelUtil;
import cn.com.ylpw.web.crm.util.Page;
import cn.com.ylpw.web.crm.util.RedisUtilBasic;
import cn.com.ylpw.web.crm.util.SessionUtils;
import cn.com.ylpw.web.crm.util.ZipUtils;
import cn.com.ylpw.web.crm.util.files.FileUploadUtils;
import jxl.write.WritableCell;

/**
 * @ClassName:  CustomersGroupController
 * @Description:会员体系-分组管理
 * @author LT
 * @date 2017年5月22日 下午1:25:42
 */
@Controller("customersGroupController")
public class CustomersGroupController {
  private static final Logger logger = LoggerFactory.getLogger(CustomersGroupController.class);
  
    @Autowired
    private  CustomerGroupService customerGroupService;
    
    @Autowired
    private  CustomerLableService customerLableService;
    
    @Autowired
    private  CustomerGradeService customerGradeService ;
    
    @Autowired  
    private FileService fileService;
    
    @Autowired
	private RedisUtilBasic redisUtil;
    
    private final  static String  []  errmsg  = {"操作失败，当前分组正在计算中,请稍后再试","操作失败，当前分组已被引用"};
 
    @RequestMapping("/customers/group/list")
	public String groupList( @RequestParam(required=false) Map<String,Object> searchParam  ,
			Page<Map<String,Object>> page,
			HttpServletRequest req, ModelMap model){
		logger.info("分组管理");
		
		PageInfo<Map<String,Object>>  pageInfo =  customerGroupService.pageFindModel("findAll", page, searchParam) ;
		
		model.put("dateList", pageInfo.getList());
		model.put("page",  page );
		model.put("searchParam", searchParam);
	    return "/customers/group/list";
	}
    
    @RequestMapping("/customers/group/executeStatus/{groupId}")
	public @ResponseBody  List<Map<String, Object>> executeStatus(@PathVariable String groupId, HttpServletRequest req, ModelMap model){
		logger.info("分组管理-执行状态刷新分组ID{}", groupId);
		if(null != groupId) {
			String[] groupIds = groupId.split(",");
			return  customerGroupService.findStaticByIds(groupIds);
		}
		return null;
	}
    
    @RequestMapping("/customers/group/executeExportStatus/{groupId}")
	public @ResponseBody  List<Map<String, Object>> executeExportStatus(@PathVariable String groupId, HttpServletRequest req, ModelMap model){
		logger.info("分组管理-分组状态刷新分组ID{}", groupId);
		if(null != groupId) {
			String[] groupIds = groupId.split(",");
			return  customerGroupService.findExportStaticByIds(groupIds);
		}
		return null;
	}
    
    /**
	 * <p>新建会员分组</p>
	 * @author WY
	 * @date 2017年5月26日 下午1:53:03
	 * @return String
	 * @param id
	 * @param req
	 * @param model
	 * @return
	 
	 */
	@RequestMapping("/customers/group/detail/{id}")
	public String detail(
			@PathVariable(name="id")  Long id, HttpServletRequest req, ModelMap model){
		logger.info("加载会员分组信息");
		model.put("customerLable",customerLableService.loadChild(-1).get(0));
		model.put("cGroup", new TCustomerGroup());
		
		logger.info("加载会员等级");
		Page<Map<String,Object>> gradePage = new Page<Map<String,Object>>();
		gradePage.setPageSize(Integer.MAX_VALUE);
		
		model.put("customerGrades", customerGradeService.pageFindModel("findGrades", gradePage, null).getList());
		
		if(null != id && id > 0){
			TCustomerGroup cGroup = customerGroupService.selectByPrimaryKey(id);
			model.put("cGroup", cGroup);
			model.put("id", id);
			//一般分组
			if(cGroup.getGclass().equals("1")){
				return "/customers/group/detail_normal";
			}else{
				model.put("customerLable",this.customerLableService.loadChild(-1).get(0));
				model.put("selectLable",customerLableService.selectLableByGroupId(cGroup.getId()) );
				//标签分组
				return "/customers/group/detail_lable_panel";
			}
			
		}
		
		
		
	    return "/customers/group/deatil_panel";
	}
	
	/**
	 * <p>新建会员分组-添加</p>
	 * @author WY
	 * @date 2017年5月31日 下午5:53:21
	 * @return String
	 * @param TCustomerGroup cg
	 * @param BindingResult br
	 * @param model
	 * @return
	 
	 */
	@RequestMapping("/customers/group/add")
	public @ResponseBody  AjaxResult addGroup(@ModelAttribute TCustomerGroup cg, BindingResult br, HttpServletRequest request,
			@RequestParam(required=false) Map<String,Object> searchParam, Page<Map<String,Object>> page, ModelMap model){
		logger.info("新建会员分组");
		if(null != request.getParameter("selArea") && request.getParameter("selArea").equals("0")){//区域
			cg.setGrAddrProv(null);
			cg.setGrAddrCity(null);
		}
		if(null != request.getParameter("signedProduct")){//指定票品
			if(request.getParameter("signedProduct").equals("0")){
				cg.setGrProname(null);
				cg.setGrClassa(null);
			}
			if(request.getParameter("signedProduct").equals("1")){
				//cg.setGrProname(null);
				cg.setGrClassa(null);
			}
			if(request.getParameter("signedProduct").equals("2")){
				cg.setGrProname(null);
				//cg.setGrClassa(null);
			}
		}
		cg.setGclass("1");
		cg.setCreateId(SessionUtils.currentUser().getId());
		cg.setCreateName(SessionUtils.currentUser().getName());
		cg.setCreateTime(new Date());
		cg.setExecuteStatus(0);
		customerGroupService.insertSelective(cg);
		AjaxResult aj= AjaxResult.Instance(); 
		
//		PageInfo<Map<String,Object>>  pageInfo =  customerGroupService.pageFindModel("findByModel", page, cg) ;
//		
//		model.put("dateList", pageInfo.getList());
//		model.put("page",  page );
//		model.put("searchParam", searchParam);
//	    return "/customers/group/list";
		aj.putVal("groupName", cg.getName());
		
		return aj;
	}
	
	/**
	 * <p>新建会员分组-修改</p>
	 * @author WY
	 * @date 2017年5月31日 下午5:53:21
	 * @return AjaxResult
	 * @param TCustomerGroup cg
	 * @param BindingResult br
	 * @param model
	 * @return
	 
	 */
	@RequestMapping("/customers/group/update")
	public @ResponseBody AjaxResult updateGroup(@ModelAttribute TCustomerGroup cg, BindingResult br, HttpServletRequest request, ModelMap model){
		logger.info("更新会员分组{}" , cg.getId());
		
		AjaxResult ajxresult = AjaxResult.Instance(); 
		
		if (customerGroupService.validateIsDoing(cg.getId())){
			  ajxresult.addError(errmsg[0]);
			  return ajxresult;
		}

		if(null != request.getParameter("selArea") && request.getParameter("selArea").equals("0")){//区域
			cg.setGrAddrProv(null);
			cg.setGrAddrCity(null);
		}
		if(null != request.getParameter("signedProduct")){//指定票品
			if(request.getParameter("signedProduct").equals("0")){
				cg.setGrProname(null);
				cg.setGrClassa(null);
			}
			if(request.getParameter("signedProduct").equals("1")){
				//cg.setGrProname(null);
				cg.setGrClassa(null);
			}
			if(request.getParameter("signedProduct").equals("2")){
				cg.setGrProname(null);
				//cg.setGrClassa(null);
			}
		}
		cg.setUpdateId(SessionUtils.currentUser().getId());
		cg.setUpdateName(SessionUtils.currentUser().getName());
		cg.setUpdateTime(new Date());
		cg.setExecuteStatus(0);
		customerGroupService.updateByPrimaryKeySelective(cg) ;
		
	    return ajxresult;
	}
	
	@RequestMapping("/customers/group/delCustomerGroup")
	public @ResponseBody AjaxResult delCustomerGroup(@RequestParam(required=false) Long id){
		logger.info("删除会员分组:{}" , id);
		AjaxResult ajxresult = AjaxResult.Instance();
		if (customerGroupService.validateIsDoing(id)){
			  ajxresult.addError(errmsg[0]);
			  return ajxresult;
		}
		//该会员分组是否被引用
		if(customerGroupService.isUse(id)) {
			ajxresult.addError(errmsg[1]);
			return ajxresult;
		}
		if(null != customerGroupService.selectByPrimaryKey(id)){
			customerGroupService.deleteByPrimaryKey(id);
		}else{
			ajxresult.addError("删除失败");
		}
		return ajxresult;
	}
	
	/***
	 * <p>批量删除会员分组</p>
	 * @author WY
	 * @date 2017年6月1日 下午6:55:09
	 * @return AjaxResult
	 * @param ids
	 * @return
	 
	 */
	@RequestMapping("/customers/group/batchDel")
	public @ResponseBody AjaxResult batchDel(Long [] ids){
		
		AjaxResult  ajaxResult = AjaxResult.Instance(); 
		
		for (long groupid :ids){
			if (customerGroupService.validateIsDoing(groupid)){
				ajaxResult.addError("操作失败，当前分组 "+groupid+ "正在计算中,请稍后再试"  );
				return ajaxResult;
			}
			//该会员分组是否被引用
			if(customerGroupService.isUse(groupid)) {
				ajaxResult.addError(errmsg[1]);
				return ajaxResult;
			}
		}
		if(ids.length>0){
			logger.info("批量删除ID{}" , ids);
			customerGroupService.batchDel(ids) ;
		}
		return ajaxResult;
	}
	
	
	
	/***
	 * <p>标签分组页面信息</p>
	 * @author LT
	 * @date 2017年6月5日 上午10:51:00
	 * @return String
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/customers/group/labledetail")
	public String detailByLable(HttpServletRequest req, ModelMap model){
		logger.info("标签分组信息");
		model.put("customerLable",this.customerLableService.loadChild(-1).get(0));
	    return "/customers/group/detail_lable_panel";
	}
	
	/***
	 * <p>标签分组保存修改</p>
	 * @author LT
	 * @date 2017年6月5日 上午10:51:00
	 * @return String
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/customers/group/labledetail/saveOrUpdate")
	public @ResponseBody AjaxResult lableDetailSaveOrUpdate(HttpServletRequest req, ModelMap model,CustomerLableGroup  lableGroup ){
		AjaxResult  ajaxResult = AjaxResult.Instance(); 
		if (null!=lableGroup.getGroupId()){
			if (customerGroupService.validateIsDoing(lableGroup.getGroupId())){
				ajaxResult.addError(errmsg[0]);
				  return ajaxResult;
			}
			this.customerGroupService.updateLableGroup(lableGroup);
		}else {
			this.customerGroupService.saveLableGroup(lableGroup);
		}
		
		ajaxResult.putVal("groupName", lableGroup.getName());
		logger.info("保存更新会员标签分组");
		return ajaxResult;
	}
	
	
	
	/***
	 * <p>导出</p>
	 * @author WY
	 * @date 2017年6月1日 下午6:55:09
	 * @return 
	 * @param groupid
	 * @return
	 
	 */
	@RequestMapping("/customers/group/exportGroupCustomers")
	public void exportGroupCustomers(Long groupid, HttpServletResponse response){
		
		
		logger.info("导出分组{}用户" ,groupid );
		
		if (customerGroupService.validateIsDoing(groupid)){
			throw new RuntimeException(errmsg[0]);
		}
		
		// 导出信息
		// excel标题
		String[] titles = null;
		String fileName = "会员分组"+groupid;
		String encoding = "UTF-8";
		titles = new String[] { "会员来源", "昵称", "姓名", "性别", "手机号", "邮箱",
				"微博号", "微信号", "证件号", "会员标签" };
		Map<String,String>  targetFileName = new HashMap<String,String>() ; 
		
		
		List<String[]> contentsList = this.customerGroupService.findCustomerByGroupId(groupid , targetFileName);
		fileName = null==targetFileName.get("fileName") ?fileName:targetFileName.get("fileName") ;
		
		// 导出
		Map<String,Object>  param = new HashMap<String,Object>();
		param.put("timestr", groupid);
		param.put("path", FileUploadUtils.fileUploadRootFiled+"/excelExport/");
		ExcelUtil.exportExcel4(fileName, encoding, titles, contentsList, 5000,
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
				}, param);
		
		
	}
	
	/***
	 * <p>生成分组</p>
	 * @author WY
	 * @date 2017年12月14日 下午6:55:09
	 * @return 
	 * @param groupid
	 * @return
	 
	 */
	@RequestMapping("/customers/group/generateCustomersGroupZip")
	public void generateCustomersGroupZip(Long groupid, HttpServletResponse response){
		
		
		logger.info("生成分组{}用户" ,groupid );
		
		if (customerGroupService.validateIsDoing(groupid)){
			throw new RuntimeException(errmsg[0]);
		}
		//判断该分组ID是否正在被分组,如果是，则不管它
		if(!redisUtil.getRedisTemplate().opsForSet().isMember(RedisKeys.GENERATE_CUSTOMER_GROUPIDS, groupid)) {
			//分组ID放入redis里
			redisUtil.getRedisTemplate().opsForSet().add(RedisKeys.GENERATE_CUSTOMER_GROUPIDS, groupid);
			customerGroupService.updateCustomerGroup(groupid);
		}
	}
	
	/***
	 * <p>生成分组</p>
	 * @author WY
	 * @date 2017年12月14日 下午6:55:09
	 * @return 
	 * @param groupid
	 * @return
	 
	 */
	@RequestMapping("/customers/group/exportCustomersGroupZip")
	public void exportCustomersGroupZip(Long groupid, HttpServletResponse response){
		//AjaxResult  ajaxResult = AjaxResult.Instance();
		
		logger.info("生成分组{}用户" ,groupid );
		
		if (customerGroupService.validateIsDoing(groupid)){
			//ajaxResult.addError("操作失败");
			throw new RuntimeException(errmsg[0]);
		}
		if(redisUtil.getRedisTemplate().opsForSet().isMember(RedisKeys.GENERATE_CUSTOMER_GROUPIDS, groupid)) {
			logger.info("正在生成导出分组文件，请耐心等待...");
			//return ajaxResult;
		}
		TCustomerGroup cg = customerGroupService.selectByPrimaryKey(groupid);
		if(null != cg) {
			if(null != cg.getExportFile() && cg.getExportFile() > 0) {
				TFiles tFile = fileService.selectByPrimaryKey(cg.getExportFile());
				if(null != tFile.getPath()) {
					ZipUtils.downFile(response, tFile.getPath(), "customerGroup"+groupid+".zip");
				} else {
					if(cg.getExportStatus() == 0) {
						logger.info("请先生成导出分组文件");
					} else if (cg.getExportStatus() == 1) {
						logger.info("正在生成导出分组文件，请耐心等待...");
					}
					//return ajaxResult;
				}
			}
		}
		//return ajaxResult;
	}
	
}

package cn.com.ylpw.web.crm.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import cn.com.ylpw.web.crm.entity.customer.TCustomerLable;
import cn.com.ylpw.web.crm.entity.customer.TCustomerPropertys;
import cn.com.ylpw.web.crm.entity.sys.SysDictionarie;
import cn.com.ylpw.web.crm.model.tree.ZTreeNode;
import cn.com.ylpw.web.crm.service.customer.CustomerGradeService;
import cn.com.ylpw.web.crm.service.customer.CustomerGroupService;
import cn.com.ylpw.web.crm.service.customer.CustomerLableService;
import cn.com.ylpw.web.crm.service.customer.CustomerPropertysService;
import cn.com.ylpw.web.crm.util.Contact;
import cn.com.ylpw.web.crm.util.Page;
import cn.com.ylpw.web.crm.util.SessionUtils;

/**
 * @ClassName: CustomersLabController
 * @Description:会员体系-标签管理
 * @author LT
 * @date 2017年5月18日 下午1:55:54
 */
@Controller("customersLabController")
public class CustomersLabController extends BasicController {
  
  private static final Logger logger = LoggerFactory.getLogger(CustomersLabController.class);
  
  @Autowired
  private  CustomerLableService customerLableService;
  @Autowired
  private CustomerPropertysService customerPropertysService;
  
  @Autowired
  private  CustomerGradeService customerGradeService ; 
  @Autowired
  private  CustomerGroupService customerGroupService ;
  
  
  /**
   * <p>标签管理</p>
   * @author LT
   * @date 2017年5月18日 下午2:05:56
   * @return String
   * @param page
   * @param req
   * @param model
   * @return
   */
   @RequestMapping("/customers/lablePanel")
	public String lablePanel( @RequestParam(required=false) Map<String,Object> searchParam  ,
			Page<Map<String,Object>> page,
			HttpServletRequest req, ModelMap model  ){
		logger.info("标签管理");
		 model.put("customerLable",this.customerLableService.loadChild(-1).get(0));
		 
		logger.info("加载会员等级");
		Page<Map<String,Object>> gradePage = new Page<Map<String,Object>>();
		gradePage.setPageSize(Integer.MAX_VALUE);
		model.put("customerGrades", customerGradeService.pageFindModel("findGrades", gradePage, null).getList());
		 
	    return "/customers/lable_panel";
	}

  
   /***
    * <p>加载树形分类子级</p>
    * @author LT
    * @date 2017年5月19日 上午9:02:17
    * @return TreeNode
    * @param pid
    * @return
    */
    @RequestMapping("/customers/lable/loadChild/{pid}")
	public @ResponseBody List <ZTreeNode>  loadChild(@PathVariable Integer pid ){
    	
    	List <ZTreeNode> nodeList =  customerLableService.loadChild(pid); 
    	
		return nodeList;
	}
    
    /**
     * <p>添加更新标签</p>
     * @author LT
     * @date 2017年6月30日 下午4:46:20
     * @return AjaxResult
     * @param pid
     * @param lableName
     * @param id
     * @return
     */
    @RequestMapping("/customers/lable/addOrUpdChild/{pid}")
    public @ResponseBody AjaxResult  addChild(@PathVariable Long pid  , String lableName, 
    		@RequestParam(required=false) Long id){
    	AjaxResult  result = AjaxResult.Instance() ;
    	if(null!=id){
    		TCustomerLable lable =this.customerLableService.selectByPrimaryKey(id);
    		lable.setName(lableName);
            customerLableService.updateByPrimaryKeySelective(lable);
    	}else {
    		TCustomerLable lable = new  TCustomerLable(); 
        	lable.setCreateId(SessionUtils.currentUser().getId());
        	lable.setCreateName(SessionUtils.currentUser().getName());
        	lable.setCreateTime(new Date());
        	lable.setPid(pid);
        	lable.setName(lableName);
            customerLableService.insertSelective(lable);
    	}
    	return result;
    }
    
    /**
     * <p>删除标签</p>
     * @author LT
     * @date 2017年5月23日 上午10:28:02
     * @return AjaxResult
     * @param id
     * @return
     */
    @RequestMapping("/customers/lable/delLable/{id}")
    public @ResponseBody AjaxResult  delLable(@PathVariable Long id  ){
    	AjaxResult  result = AjaxResult.Instance() ;

    	if(null!=customerGroupService.selectGroupsByLableId(id)&&customerGroupService.selectGroupsByLableId(id).size()>0){
    		return result.addError("操作失败，删除的标签已被用户分组引用。");
    	}
        customerLableService.delLable(id);
    	return result;
    }
	
    /***
     * <p>标签搜索</p>
     * @author LT
     * @date 2017年5月23日 上午10:25:56
     * @return List<ZTreeNode>
     * @param nodeName
     * @return
     */
    @RequestMapping("/customers/lable/searchNode/{nodeName}")
 	public @ResponseBody ZTreeNode  searchNode(@PathVariable String nodeName ){
//    	List <ZTreeNode> ztreeNodeList = Lists.newArrayList();
//    	List <ZTreeNode> nodeList =  ;
//     	if(null != nodeList && nodeList.size() > 0) {
//     		ztreeNodeList.addAll(nodeList);
//     		for(ZTreeNode ztreeNode : nodeList) {
//     			if(ztreeNode.isHasChildren()) {
//     				List <ZTreeNode> nodeChildrenList = customerLableService.loadChild(Integer.valueOf(ztreeNode.getId()));//ztreeNode.getChildren();
//     				ztreeNodeList.addAll(nodeChildrenList);
//     				if(null != nodeChildrenList && nodeChildrenList.size() > 0) {
//     					for(ZTreeNode nodeChildrenSub : nodeChildrenList) {
//     		     			if(nodeChildrenSub.isHasChildren()) {
//     		     				List <ZTreeNode> nodeChildrenSubList = customerLableService.loadChild(Integer.valueOf(nodeChildrenSub.getId()));//ztreeNode.getChildren();
//     		     				ztreeNodeList.addAll(nodeChildrenSubList);
//     		     			}
//     		     		}
//     				}
//     			}
//     		}
//     	}
 		return customerLableService.searchNode(nodeName);
 	}
    
    /***
     * <p>省CODE 获取市选项</p>
     * @author LT
     * @date 2017年5月26日 下午1:37:16
     * @return Map<String,SysDictionarie>
     * @param provinceCode
     * @return
     */
    @RequestMapping("/customers/lable/loadArea/{provinceCode}")
    public @ResponseBody  List<SysDictionarie>   loadArea(@PathVariable String provinceCode  ){
    	if (provinceCode.contains("_")){
    		
    		List <SysDictionarie>  citys = new ArrayList<SysDictionarie>()  ;
    		
    		Map<String ,SysDictionarie >  maps = Contact.getAllDictionarie().get(provinceCode.split("_")[1])  ;
    		Set<String> keys = maps.keySet() ;
    		for (String key :keys){
    			citys.add(maps.get(key)) ;
    		}
    		
    		return citys;
    	}
    	return null;
    }
    
    /***
     * <p>产品A分类CODE 获取B分类</p>
     * @author LT
     * @date 2017年5月26日 下午1:37:16
     * @return Map<String,SysDictionarie>
     * @param provinceCode
     * @return
     */
    @RequestMapping("/customers/lable/loadProClass/{proClassACode}")
    public @ResponseBody  List<SysDictionarie>   loadProClass(@PathVariable String proClassACode  ){
    	if (proClassACode.contains("_")){
    		
    		List <SysDictionarie>  proClass = new ArrayList<SysDictionarie>()  ;
    		
    		Map<String ,SysDictionarie >  maps = Contact.getAllDictionarie().get(proClassACode.split("_")[1])  ;
    		Set<String> keys = maps.keySet() ;
    		for (String key :keys){
    			proClass.add(maps.get(key)) ;
    		}
    		
    		return proClass;
    	}
    	return null;
    }
    
    /**
     * <p>生成标签</p>
     * @author LT
     * @date 2017年5月27日 下午1:08:54
     * @return AjaxResult
     * @param lableId
     * @param propertys
     * @return
     */
    @RequestMapping("/customers/lable/saveOrUpdatePropertysByLableId/{lableId}")
    public @ResponseBody  AjaxResult   saveOrUpdatePropertysByLableId(@PathVariable Long lableId  , TCustomerPropertys propertys ){
    		AjaxResult ar =  AjaxResult.Instance(); 
    		if (null!=propertys.getId()){
    			this.customerPropertysService.update(propertys);
    		}else{
    			this.customerPropertysService.insertSelective(propertys) ;
    		}
    		ar.putVal("propertyid", propertys.getId());
    		return ar;
    }
    
    
    /**
     * <p>标签属性获取标签</p>
     * @author LT
     * @date 2017年5月27日 下午1:18:28
     * @return TCustomerPropertys
     * @param lableId
     * @return
     */
    @RequestMapping("/customers/lable/getPropertysByLableId/{lableId}")
    public @ResponseBody  TCustomerPropertys   getPropertysByLableId(@PathVariable Long lableId   ){
    		TCustomerPropertys prop = this.customerPropertysService.getPropertysByLableId(lableId);
    	  return prop;
    }
    
    
}

package cn.com.ylpw.web.crm.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.core.tools.AjaxResult;
import cn.com.ylpw.web.crm.entity.sys.SysDictionarie;
import cn.com.ylpw.web.crm.service.sys.DictionarieService;
import cn.com.ylpw.web.crm.util.Page;

/**
 * @ClassName: DictionarieController
 * @Description:数据字典
 * @author LT
 * @date 2017年4月17日 下午2:51:27
 */
@Controller("dictionarieController")
public class DictionarieController {
  
  private static final Logger logger = LoggerFactory.getLogger(DictionarieController.class);
  
  @Autowired
  private  DictionarieService dictionarieService ; 
  
	@RequestMapping("/dictionarie/list")
	public String list(
			Page<Map<String,Object>> page,
			HttpServletRequest req,
			@ModelAttribute("dic") SysDictionarie dics,
			ModelMap model){
		logger.info("加载数据字典列表");
		PageInfo<Map<String, Object>> resultPage = dictionarieService.pageFindModel("findAllParent", page, dics);
		
		Map<String ,Object> param = new HashMap<String ,Object>() ;
		List<Long> ids=   new ArrayList<Long> ();
		for ( Map<String, Object>  dic  :  resultPage.getList()){
			ids.add((Long) dic.get("ID"));
		}
		//父子节点排序
		List<Map<String, Object>> allDis = new ArrayList<Map<String, Object>>() ; 
		if (ids.size()>0){
			param.put("list", ids);
			Page   childSearch = new Page() ; 
			childSearch.setPageSize(Integer.MAX_VALUE);
			//根据父级ID查找子节点
			PageInfo<Map<String, Object>> childDis = dictionarieService.pageFindModel("findByPid", childSearch, param);
			for ( Map<String, Object>  dic  :  resultPage.getList()){
				allDis.add(dic);
				for (Map<String, Object>  child  :  childDis.getList()){
					if (child.get("PID").toString().equals(dic.get("ID").toString())){
						allDis.add(child);
					}
				}
			}
		}else {
			allDis =resultPage.getList();
		}
		
		model.put("dateList", allDis);
		model.put("page",  page );
		return "/dictionarie/list";
	}
	
  
	
	/***
	 * <p>添加更新数据字典展示页</p>
	 * @author LT
	 * @date 2017年4月17日 下午6:16:56
	 * @return AjaxResult
	 * @param dic
	 * @return
	 
	 */
	@RequestMapping("/dictionarie/showDetail")
	public String   showDetail(Model model, @RequestParam(required=false) Long id , @RequestParam(required=false) Long pid ){
		 if (null!=id&&id>0){
			 SysDictionarie  dic =  dictionarieService.selectByPrimaryKey(id); 
			 model.addAttribute("detail", dic);
			 if (dic.getPid()>0){
				 pid = dic.getPid(); 
			 }
		 }
		 
		 if (null!=pid&&pid>0){
			 model.addAttribute("parent", dictionarieService.selectByPrimaryKey(pid));
		 }
		return "/dictionarie/detail";
	}
	/***
	 * <p>添加更新数据字典</p>
	 * @author LT
	 * @date 2017年4月17日 下午6:16:56
	 * @return AjaxResult
	 * @param dic
	 * @return
	 
	 */
	@RequestMapping("/dictionarie/saveOrUpdate")
	public @ResponseBody AjaxResult  saveOrUpdate(@ModelAttribute("dict") SysDictionarie dic){
		
		AjaxResult  ajxresult = AjaxResult.Instance(); 
	
		PageInfo<Map<String, Object>> pageInfo =   dictionarieService.pageFindModel("findByExist", new Page(), dic);
		if (pageInfo.getTotal()>0){
			logger.info("字典名称或编码重复！ : {}" , com.alibaba.fastjson.JSONObject.toJSONString(dic));
			ajxresult.addError("字典名称或编码重复！");
			return ajxresult ;
		}
		
		if(null!=dic.getId()){
			
			logger.info("更新数据字典ID{}" , dic.getId());
			dictionarieService.updateByPrimaryKeySelective(dic) ;
		}else {
			
			
			logger.info("添加数据字典" );
			dictionarieService.insertSelective(dic);
		}
		return ajxresult;
	}
	
	@RequestMapping("/dictionarie/delete")
	public @ResponseBody AjaxResult  delete(Long [] ids){
		
		AjaxResult  ajaxResult = AjaxResult.Instance(); 
		if(ids.length>0){
			logger.info("删除数据字典ID{}" , ids);
			dictionarieService.deleteBatch(ids) ;
		}
		return ajaxResult;
	}
	
  
}

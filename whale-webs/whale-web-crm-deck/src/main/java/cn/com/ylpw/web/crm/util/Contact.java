package cn.com.ylpw.web.crm.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.web.crm.entity.sys.SysDictionarie;
import cn.com.ylpw.web.crm.service.sys.DictionarieService;


/**
 * @ClassName: Contact
 * @Description:
 * @author LT
 * @date 2016年9月12日 下午4:43:30
 */
public class Contact {
	
	private static final Logger logger = LoggerFactory.getLogger(Contact.class);

	//存放数据字典	Listener 中加载
	private static Map<String,Map<String ,SysDictionarie>> allDictionarie  = new LinkedHashMap<String,Map<String ,SysDictionarie>>();
	
	/***
	 * <p>初始化数据字典缓存</p>
	 * @author LT
	 * @date 2017年4月19日 下午3:21:43
	 * @return Map<String,Map<String,SysDictionarie>>
	 * @return
	 
	 */
	public static  Map<String,Map<String ,SysDictionarie>> initDicCache(){
		
		 Map<String,Map<String ,SysDictionarie>> allDictionarieTmp  = new LinkedHashMap<String,Map<String ,SysDictionarie>>();
		logger.info("缓存数据字典..");
		
		DictionarieService  dictionarieService = (DictionarieService) SpringUtils.getBean("dictionarieServiceImpl");
				
		Page   pageSearch = new Page() ; 
		pageSearch.setPageSize(Integer.MAX_VALUE);
		PageInfo<Map<String, Object>> resultPage = dictionarieService.pageFindModel("findAll", pageSearch, null);
		
		
		for ( Map<String, Object>  dic  :  resultPage.getList()){
			//所有父节点
			if(dic.get("PID").toString().equals("0")){
				allDictionarieTmp.put(dic.get("CODE").toString()+"-"+dic.get("ID").toString(), new LinkedHashMap<String ,SysDictionarie>());
			}
		}
		
		Iterator<String>  it = allDictionarieTmp.keySet().iterator(); 
		//循环所有父几点添加子节点
		while(it.hasNext()){
			String  parentKey = it.next(); 
			
			 for ( Map<String, Object>  dic  :  resultPage.getList()){
				 //根据子节点PID归类
				 
				 if (parentKey.split("-")[1].equals(dic.get("PID").toString())){
					 SysDictionarie dicModel = new SysDictionarie() ;
					 dicModel.setId((Long) dic.get("ID"));
					 dicModel.setPid( (Long) dic.get("PID"));
					 dicModel.setName((String) dic.get("NAME"));
					 dicModel.setCode((String) dic.get("CODE"));
					 dicModel.setRemark(String.valueOf(dic.get("REMARK")));
					 allDictionarieTmp.get(parentKey).put(dicModel.getCode(), dicModel);
				 } 
			 }
		}
		it = allDictionarieTmp.keySet().iterator(); 
		allDictionarie.clear();
		while(it.hasNext()){
			String  parentKey = it.next(); 
			allDictionarie.put(parentKey.split("-")[0], allDictionarieTmp.get(parentKey));
		}
		return  allDictionarie; 
	}
	
	/***
	 * <p>添加字典时刷新缓存</p>
	 * @author LT
	 * @date 2017年4月19日 下午3:22:14
	 * @return Map<String,Map<String,SysDictionarie>>
	 * @param dic
	 * @param parentKey
	 * @return
	 
	 */
	public static  Map<String,Map<String ,SysDictionarie>> refreshDicCacheByAdd(SysDictionarie dic,String parentKey){
		logger.info("刷新数据字典");
		//目录
		if(null == dic.getPid() || dic.getPid()==0){
			allDictionarie.put( dic.getCode(), new LinkedHashMap<String ,SysDictionarie>() );
		}else{
			
			allDictionarie.get(parentKey).put(dic.getCode(), dic);
		}
		return  allDictionarie;
	}

	
	public static Map<String, Map<String, SysDictionarie>> getAllDictionarie() {
		return allDictionarie;
	}
	
	
	
	
}

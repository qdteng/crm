package cn.com.ylpw.web.crm.service.impl.sys;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ylpw.web.crm.controller.system.DictionarieController;
import cn.com.ylpw.web.crm.entity.sys.SysDictionarie;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.service.sys.DictionarieService;
import cn.com.ylpw.web.crm.util.Contact;

@Transactional
@Service("dictionarieServiceImpl")
public class DictionarieServiceImpl   extends BaseServiceImpl<SysDictionarie> implements DictionarieService {
	
	private static final Logger logger = LoggerFactory.getLogger(DictionarieServiceImpl.class);
	@Override
	protected Class setClass() {
		return SysDictionarie.class;
	}

	@Override
	public int deleteBatch(Long[] ids) {
		Map<String , Object>  parma = new HashMap<String , Object>() ;
		parma.put("ids", ids);
		int num =super.getBaseDao().getSqlSession().delete(super.getMapperKey("deleteBatch"), parma) ;
		if (num>0){
			logger.info("更新缓存");
			Contact.initDicCache();
		}
		return num;
	}
	
	@Override
    public int insertSelective(SysDictionarie record){
    	int num =super.insertSelective(record);; 
    	String parentKey = ""; 
    	if (null != record.getPid() && record.getPid()!=0){
    		parentKey= this.selectByPrimaryKey(record.getPid()).getCode() ;
    	}
    	if (num>0){
	    	Contact.refreshDicCacheByAdd(record, parentKey) ;
	    	logger.info("添加字典刷新缓存");
    	}
    	return num;
    }
    
	@Override
    public int updateByPrimaryKey(SysDictionarie record) {  
		logger.info("方法已禁用");
		return 0 ; 
    }  
	
	@Override
    public int updateByPrimaryKeySelective(SysDictionarie record) {
		int num =super.updateByPrimaryKeySelective(record);; 
		
		if (num>0){
			logger.info("更新缓存");
			Contact.initDicCache();
    	}
        return num;
    }  
	    
    
    

	
}

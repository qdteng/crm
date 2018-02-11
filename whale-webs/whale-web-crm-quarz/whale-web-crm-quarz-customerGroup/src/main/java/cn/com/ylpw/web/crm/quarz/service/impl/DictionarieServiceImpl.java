package cn.com.ylpw.web.crm.quarz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ylpw.web.crm.entity.sys.SysDictionarie;
import cn.com.ylpw.web.crm.quarz.service.DictionarieService;

@Transactional
@Service("dictionarieServiceImpl")
public class DictionarieServiceImpl   extends BaseServiceImpl<SysDictionarie> implements DictionarieService {
	
	private static final Logger logger = LoggerFactory.getLogger(DictionarieServiceImpl.class);
	@Override
	protected Class setClass() {
		return SysDictionarie.class;
	}
	@Override
	public List<Integer> findCityIdsByProvCode(String provCode) {
		if (!provCode.contains("_")){
			return null ;
		} 
		String  citysParentCode = provCode.split("_")[1] ;
		
		List <Map<String,Object>> results =super.getBaseDao().getSqlSession().selectList(super.getMapperKey("findCityIdsByProvCode"), citysParentCode);
		List <Integer>  rtnList = new ArrayList<Integer>(0) ;
		for (Map<String,Object> id  : results){
			rtnList.add(Integer.parseInt(id.get("CODE").toString()));
		}
		
		return rtnList;
	}
	@Override
	public List<String> findProTypebByTypea(String typeaCode) {
		
		if (!typeaCode.contains("_")){
			return null ;
		} 
		String  typebParentCode = typeaCode.split("_")[1] ;
		
		List <Map<String,Object>> results =super.getBaseDao().getSqlSession().selectList(super.getMapperKey("findProTypebByTypea"), typebParentCode);
		List <String>  rtnList = new ArrayList<String>(0) ;
		for (Map<String,Object> id  : results){
			rtnList.add(id.get("NAME").toString());
		}
		
		return rtnList;
	}
	
	@Override
	public List<String> findCityNamesByCityIds(List<Integer> findCityIdsByProvCode) {
		
		
		Map<String,Object>  param  = new HashMap<String,Object>();
		param.put("ids", findCityIdsByProvCode);
		
		List <Map<String,Object>> results = 
				super.getBaseDao().getSqlSession().selectList(super.getMapperKey("findCityNamesByCityIds"), param);
				
		List <String>  rtnList = new ArrayList<String>(0) ;
		for (Map<String,Object> id  : results){
			rtnList.add(id.get("NAME").toString());
		}
		return rtnList;
	}
	
}

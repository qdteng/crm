package cn.com.ylpw.web.crm.service.impl.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGroup;
import cn.com.ylpw.web.crm.entity.customer.TCustomerGroupLable;
import cn.com.ylpw.web.crm.entity.usable.TFiles;
import cn.com.ylpw.web.crm.mapper.customer.TCustomerGroupLableMapper;
import cn.com.ylpw.web.crm.mapper.customer.TCustomerGroupMapper;
import cn.com.ylpw.web.crm.model.CustomerLableGroup;
import cn.com.ylpw.web.crm.model.RedisKeys;
import cn.com.ylpw.web.crm.service.customer.CustomerGroupService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.util.Page;
import cn.com.ylpw.web.crm.util.RedisUtilBasic;
import cn.com.ylpw.web.crm.util.SessionUtils;

@Transactional
@Service("customerGroupServiceImpl")
public class CustomerGroupServiceImpl   extends BaseServiceImpl<TCustomerGroup> implements CustomerGroupService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerGroupServiceImpl.class);
	@Autowired 
	TCustomerGroupLableMapper  customerGroupLableMapper ;
	@Autowired 
	TCustomerGroupMapper  customerGroupMapper ;
	@Resource(name = "redisUtil")
	private RedisUtilBasic redisUtil;
	@Override
	protected Class setClass() {
		return TCustomerGroup.class;
	}
	@Override
	public int batchDel(Long[] ids) {
		Map<String, Object> parma = new HashMap<String, Object>();
		parma.put("ids", ids);
		
		customerGroupMapper.deleteGroupCustomersByGroupIdForBatch(parma);
		customerGroupMapper.deleteGroupLableByGroupIdForBatch(parma);
		
		int num = super.getBaseDao().getSqlSession().delete(super.getMapperKey("batchDel"), parma);
		return num;
	}
	
 	public int insertSelective(TCustomerGroup record) {  
        return super.insertSelective(record);
    }  
    public TCustomerGroup selectByPrimaryKey(Long id ) {  
        return super.selectByPrimaryKey(id);
    } 
    public int updateByPrimaryKeySelective(TCustomerGroup record) {  
        return super.updateByPrimaryKeySelective(record);
    }  
    public int deleteByPrimaryKey(Long id) {  
    	
    	Map<String, Object> parma = new HashMap<String, Object>();
		parma.put("ids", new Long [] {id} );
//		logger.info("删除分组 用户关联表");
//		customerGroupMapper.deleteGroupCustomersByGroupIdForBatch(parma);
//		logger.info("删除 相关分组标签");
//		customerGroupMapper.deleteGroupLableByGroupIdForBatch(parma);
		int num =super.deleteByPrimaryKey(id);
//		logger.info("通知 queue  删除 essaerch 中的分组 信息");
//		redisUtil.rPushList(RedisKeys.CUSTOMER_GROUP_DEL_QUEUE, id);
		logger.info("分组删除成功");
        return  num ;
    }  
    
	public PageInfo<Map<String,Object>>  pageFindModel(String mapperKey,Page<Map<String,Object>> page, Object searParam) {
			return super.pageFindModel(mapperKey, page, searParam);
	}
		
	
	@Override
	public void saveLableGroup(CustomerLableGroup lableGroup) {
		logger.info("保存分组{}",lableGroup.getName());
		TCustomerGroup group = new TCustomerGroup(); 
		group.setName(lableGroup.getName());
		group.setRemark(lableGroup.getRemark());
		group.setGclass("2");
		group.setType(lableGroup.getType());
		group.setCreateId(SessionUtils.currentUser().getId());
		group.setCreateTime( new Date());
		group.setCreateName(SessionUtils.currentUser().getName());
		this.insertSelective(group);
		lableGroup.setGroupId(group.getId());
		for (Long labelId  :lableGroup.getLableIds()){
			logger.info("保存分组标签{}",labelId);
			TCustomerGroupLable groupLable  = new TCustomerGroupLable(); 
			groupLable.setCreateId(SessionUtils.currentUser().getId());
			groupLable.setCreateName(SessionUtils.currentUser().getName());
			groupLable.setCreateTime( new Date());
			groupLable.setGroupId(group.getId());
			groupLable.setLableId(labelId);
			customerGroupLableMapper.insertSelective(groupLable);
		}
		
	}
	@Override
	public void updateLableGroup(CustomerLableGroup lableGroup) {
		
		logger.info("更新分组{}",lableGroup.getName());
		TCustomerGroup group = this.selectByPrimaryKey(lableGroup.getGroupId());
		group.setName(lableGroup.getName());
		group.setRemark(lableGroup.getRemark());
		group.setType(lableGroup.getType());
		group.setCreateId(SessionUtils.currentUser().getId());
		group.setCreateTime( new Date());
		group.setCreateName(SessionUtils.currentUser().getName());
		group.setExecuteStatus(0);
		this.updateByPrimaryKeySelective(group);
		customerGroupLableMapper.deleteByGroupId(group.getId());
		
		for (Long labelId  :lableGroup.getLableIds()){
			logger.info("更新分组标签{}",labelId);
			TCustomerGroupLable groupLable  = new TCustomerGroupLable(); 
			groupLable.setCreateId(SessionUtils.currentUser().getId());
			groupLable.setCreateName(SessionUtils.currentUser().getName());
			groupLable.setCreateTime( new Date());
			groupLable.setGroupId(group.getId());
			groupLable.setLableId(labelId);
			customerGroupLableMapper.insertSelective(groupLable);
		}
	}
	@Override
	public List<TCustomerGroup> selectGroupsByLableId(Long lableid) {
		
		
		return customerGroupMapper.findGroupByLableId(lableid);
	}
	@Override
	public List<String[]> findCustomerByGroupId(Long groupid, Map<String,String> filename) {
		Page<Map<String,Object>> page = new Page<Map<String,Object>>() ;
		page.setPageSize(Integer.MAX_VALUE);
		
		Map<String ,Object > searchParma = new HashMap<String ,Object >() ;
		searchParma.put("groupid", groupid) ;
		
		
		List<String[]>  result = new ArrayList<String[]>() ;
		List <Map<String, Object>>  arr =  super.pageFindModel("findCustomerByGroupId", page, searchParma).getList(); 
		if(null!=arr && arr.size()>0   ){
			for (Map<String, Object> customer  : arr ){
				result.add(new String [] {
						MapUtils.getString(customer , "SYS_SOURCE")   , MapUtils.getString(customer , "NICKNAME")  , 
						MapUtils.getString(customer , "TRUENAME")   , MapUtils.getString(customer , "SEX")  , 
						MapUtils.getString(customer , "PHONE")   , MapUtils.getString(customer , "EMAIL")  , 
						MapUtils.getString(customer , "WEIBO_NO")   , MapUtils.getString(customer , "WEIXIN_NO")  , 
						MapUtils.getString(customer , "CARD")   , MapUtils.getString(customer , "NOTE")  
					} ); 
				
				filename.put("fileName", MapUtils.getString(customer , "GROUPNAME")) ;
			}
		}else {
			
			filename.put("fileName", this.selectByPrimaryKey(groupid).getName()) ;
			logger.info("分组：{}, 用户为空",filename.get("fileName"));
		}
		return result;
	}
	@Override
	public boolean validateIsDoing(Long groupid) {
		return this.redisUtil.getRedisTemplate().opsForSet().isMember(RedisKeys.CUSTOMER_STATIC_GROUP_DOING, groupid);
	}
	public boolean validateIsDoing2(Long groupid) {
		return this.redisUtil.getRedisTemplate().opsForSet().isMember(RedisKeys.GENERATEING_CUSTOMER_GROUPIDS, groupid);
	}
	@Override
	public boolean isUse(Long groupid) {
		return false;
	}
	
	
	@Override
	public List<Map<String, Object>> findStaticByIds(String[] ids) {
		
		List<Map<String, Object>> result =  new ArrayList<Map<String,Object>> ();
		List <String> searcIds = new ArrayList<>() ;
		for (String id  : ids){
			if (validateIsDoing(Long.parseLong(id))) {
				//正在执行中的..
				Map<String, Object> map = new HashMap<String, Object>() ;
				map.put("ID", id);
				map.put("EXECUTE_STATUS", -1);
				result.add(map) ;
			}else {
				//未在执行过程中。 需要 查询数据库的 .
				searcIds.add(id);
			}
		}
		
		
		if (searcIds.size()>0){
			result.addAll(customerGroupMapper.findStaticByIds(searcIds.toArray( new String [searcIds.size()]  )) );
		}
		
		return result;
	}
	
	@Override
	public List<Map<String, Object>> findExportStaticByIds(String[] ids) {
		
		List<Map<String, Object>> result =  new ArrayList<Map<String,Object>> ();
		List <String> searcIds = new ArrayList<>() ;
		for (String id  : ids){
			if (validateIsDoing2(Long.parseLong(id))) {
				//正在执行中的..
				Map<String, Object> map = new HashMap<String, Object>() ;
				map.put("ID", id);
				map.put("EXPORT_STATUS", 1);
				result.add(map) ;
			}else {
				//未在执行过程中。 需要 查询数据库的 .
				searcIds.add(id);
			}
		}
		
		
		if (searcIds.size()>0){
			result.addAll(customerGroupMapper.findStaticByIds(searcIds.toArray( new String [searcIds.size()]  )) );
		}
		
		return result;
	}
	
	@Override
	public void updateCustomerGroup(Long groupId) {
		TCustomerGroup tcg = customerGroupMapper.selectByPrimaryKey(groupId);
		tcg.setExportStatus(1);
		customerGroupMapper.updateForExport(tcg);
	}
}

package cn.com.ylpw.web.crm.service.impl.customer;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIntegral;
import cn.com.ylpw.web.crm.entity.customer.TCustomerJoinNote;
import cn.com.ylpw.web.crm.entity.customer.TCustomerNote;
import cn.com.ylpw.web.crm.entity.customer.TCustomers;
import cn.com.ylpw.web.crm.mapper.customer.TCustomerIntegralMapper;
import cn.com.ylpw.web.crm.mapper.customer.TCustomerJoinNoteMapper;
import cn.com.ylpw.web.crm.mapper.customer.TCustomerNoteMapper;
import cn.com.ylpw.web.crm.mapper.order.TOrdersInfoMapper;
import cn.com.ylpw.web.crm.model.importVO.TCustomersImportVO;
import cn.com.ylpw.web.crm.service.customer.CustomerService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.util.Page;
import cn.com.ylpw.web.crm.util.RedisUtilBasic;
import cn.com.ylpw.web.crm.util.SessionUtils;

@Transactional
@Service("customerServiceImpl")
public class CustomerServiceImpl extends BaseServiceImpl<TCustomers> implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private TCustomerNoteMapper customerNoteMapper;

	@Autowired
	private TCustomerJoinNoteMapper TCustomerJoinNoteMapper;
	
	@Autowired
	private TCustomerIntegralMapper customerIntegralMapper;
	
	@Autowired
	private TOrdersInfoMapper ordersInfoMapper;

	@Override
	protected Class setClass() {
		return TCustomers.class;
	}


	@Resource(name = "redisUtil")
	private RedisUtilBasic redisUtil;

	 
	 
	@Override
	public int updShieldBatch(Long[] ids) {
		Map<String, Object> parma = new HashMap<String, Object>();
		parma.put("ids", ids);
		int num = super.getBaseDao().getSqlSession().update(super.getMapperKey("updShieldBatch"), parma);
		return num;

	}

	@Override
	public int importCustomerInfo(List<TCustomersImportVO> importCustomerInfoList,
			List<Map<String, Object>> ordersource) {
		if(true){
			logger.info("禁止导入用户，待定");
			System.out.println(1/0);
		}
		Map<String, Object> map = Maps.newHashMap();
		int count = 0;
		if (null != importCustomerInfoList && importCustomerInfoList.size() > 0) {
			for (TCustomersImportVO customersImportVO : importCustomerInfoList) {
				TCustomers customer = new TCustomers();
				for (Map<String, Object> sourceMap : ordersource) {
					if (null != sourceMap.get("CODE")
							&& customersImportVO.getCustomerSource().equals(sourceMap.get("CODE").toString())) {
						customer.setSysSource(customersImportVO.getCustomerSource());
						break;
					}
				}
				if (null != customersImportVO.getNickName()) {// 昵称
					customer.setNickname(customersImportVO.getNickName());
				}
				if (null != customersImportVO.getName()) {// 姓名
					customer.setTruename(customersImportVO.getName());
				}
				if (null != customersImportVO.getSex()) {// 性别
					customer.setSex(customersImportVO.getSex().trim());
				}
				if (null != customersImportVO.getPhone()) {// 手机号
					customer.setPhone(customersImportVO.getPhone());
				}
				if (null != customersImportVO.getEmail()) {
					customer.setEmail(customersImportVO.getEmail());
				}
				if (null != customersImportVO.getWeiboNo()) {
					customer.setWeiboNo(customersImportVO.getWeiboNo().trim());
				}
				if (null != customersImportVO.getWeCheatNo()) {
					customer.setWeixinNo(customersImportVO.getWeCheatNo().trim());
				}
				if (null != customersImportVO.getCardNo()) {
					customer.setCard(customersImportVO.getCardNo());
				}
				customer.setShield(0);// 营销未屏蔽
				customer.setStatus(Short.parseShort("0"));// 状态默认为‘有效’
				customer.setType(0);// 会员类型设为‘用户’
				this.insertSelective(customer);// 保存会员
				if (null != customersImportVO.getCustomerSign()) {
					// 会员标签
					String[] notes = customersImportVO.getCustomerSign().split(",");
					if (null != notes && notes.length > 0) {
						for (String note : notes) {
							map.put("notename", note);
							TCustomerJoinNote tjn = new TCustomerJoinNote();
							tjn.setCustomerId(customer.getId());
							List<Map<String, Object>> customerNoteList = customerNoteMapper.findByParams(map);
							if (null != customerNoteList && customerNoteList.size() > 0) {
								tjn.setNoteId(Long.parseLong(customerNoteList.get(0).get("ID").toString()));
							} else {// 没有标签，新建标签
								TCustomerNote cn = new TCustomerNote();
								cn.setName(note);
								cn.setCreateTime(new Date());
								cn.setCreateId(SessionUtils.currentUser().getId());
								cn.setCreateName(SessionUtils.currentUser().getName());
								customerNoteMapper.insertSelective(cn);// 保存标签
								tjn.setNoteId(cn.getId());
							}
							tjn.setCreateTime(new Date());
							logger.info(SessionUtils.currentUser().getId() + "");
							tjn.setCreateId(SessionUtils.currentUser().getId());
							tjn.setCreateName(SessionUtils.currentUser().getName());
							TCustomerJoinNoteMapper.insertSelective(tjn);// 保存关联表
						}
					}
				}
				count++;
			}
		}
		return count;
	}

	@Override
	public Map<String, Object> findCustomerInfo(Long id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("customersid", id);
		List<Map<String, Object>> list = this.getBaseDao().getSqlSession()
				.selectList(super.getMapperKey("findCustomerInfo"), param);
		if (null != list && list.size() > 0) {
			Map<String, Object> map = list.get(0);
			List<Map<String, Object>> prolist = ordersInfoMapper.findOrdersGroupByPros(Long.parseLong(map.get("PWSYSID").toString()));
			map.put("PRO_TOTAL", prolist.size());
			return map;
		}
		return null;
	}

	public PageInfo<Map<String, Object>> pageFindModel( Page<Map<String, Object>> page, Map<String,Object>  searParam) {
		logger.info("使用 mysql 分页查询 ");
		PageInfo<Map<String, Object>> pageInfo=null;
		try {
			pageInfo = this.getBaseDao().pageFindModel("findByParams", page, searParam, setClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}


	
	@Override
	public void updateIntegral(TCustomers customer, TCustomerIntegral customerIntegral) {
		
		logger.info("更新{} 用户 积分 {}  " ,customer.getId()  , customerIntegral.getIntegral());
		
		logger.info("  积分增减操作类型（1系统计算2人为操作）  :  {} ",customerIntegral.getOptType());
		
		super.updateByPrimaryKeySelective(customer);
		
		logger.info("插入积分操作日志：");
		this.customerIntegralMapper.insertSelective(customerIntegral) ;
		
	}

	@Override
	public int updIntegral2Dis(Long[] ids, Integer status ) {
		Map<String, Object> parma = new HashMap<String, Object>();
		parma.put("ids", ids);
		parma.put("status", status);
		int num = super.getBaseDao().getSqlSession().update(super.getMapperKey("updIntegral2Dis"), parma);
		return num;
	}
	@Override
	public int updIntegral2Clear(Long[] ids) {
		Map<String, Object> parma = new HashMap<String, Object>();
		parma.put("ids", ids);
		int num = super.getBaseDao().getSqlSession().update(super.getMapperKey("updIntegral2Clear"), parma);
		return num;
	}
	
	
	

    public int insert(TCustomers entity) {  
        return super.insert(entity) ;
    }  
    public int insertSelective(TCustomers record) {  
        return super.insertSelective(record);  
    }  
    public int updateByPrimaryKey(TCustomers record) {  
        return super.updateByPrimaryKey(record);  
    }  
    public int updateByPrimaryKeySelective(TCustomers record) {  
        return super.updateByPrimaryKeySelective(record);  
    }  
    public int deleteByPrimaryKey(Long id) {
    	if (true)throw new RuntimeException("不支持删除操作");
        return super.deleteByPrimaryKey(id );  
    }  

}

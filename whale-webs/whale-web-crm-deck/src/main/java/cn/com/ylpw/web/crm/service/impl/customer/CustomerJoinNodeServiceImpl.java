package cn.com.ylpw.web.crm.service.impl.customer;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;

import cn.com.ylpw.web.crm.entity.customer.TCustomerJoinNote;
import cn.com.ylpw.web.crm.entity.customer.TCustomerNote;
import cn.com.ylpw.web.crm.mapper.customer.TCustomerJoinNoteMapper;
import cn.com.ylpw.web.crm.mapper.customer.TCustomerNoteMapper;
import cn.com.ylpw.web.crm.service.customer.CustomerJoinNodeService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.util.SessionUtils;

@Transactional
@Service("customerJoinNodeServiceImpl")
public class CustomerJoinNodeServiceImpl extends BaseServiceImpl<TCustomerJoinNote> implements CustomerJoinNodeService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerJoinNodeServiceImpl.class);
	
	@Autowired
	private TCustomerNoteMapper customerNoteMapper;
	
	@Autowired
	private TCustomerJoinNoteMapper customerJoinNoteMapper;
	
	@Override
	protected Class setClass() {
		return TCustomerJoinNote.class;
	}

	@Override
	public void addNode(Long customerId, String nodeName) {
		nodeName=nodeName.trim() ;
		Map<String, Object> map = Maps.newHashMap();
		map.put("notename", nodeName);
		List<Map<String, Object>> customerNoteList = customerNoteMapper.findByParams(map);
		
		TCustomerJoinNote tjn = new TCustomerJoinNote();
		tjn.setCustomerId(customerId);
		if(null != customerNoteList && customerNoteList.size() > 0){
			tjn.setNoteId(Long.parseLong(customerNoteList.get(0).get("ID").toString()));
		}else{//没有标签，新建标签
			this.logger.info("标签[{}]不存在添加标签",nodeName);
			TCustomerNote cn = new TCustomerNote();
			cn.setName(nodeName);
			cn.setCreateTime(new Date());
			cn.setCreateId(SessionUtils.currentUser().getId());
			cn.setCreateName(SessionUtils.currentUser().getName());
			customerNoteMapper.insertSelective(cn);//保存标签
			tjn.setNoteId(cn.getId());
		}
		tjn.setCreateTime(new Date());
		tjn.setCreateId(SessionUtils.currentUser().getId());
		tjn.setCreateName(SessionUtils.currentUser().getName());
		customerJoinNoteMapper.insertSelective(tjn);//保存关联表
		
	}
	
	
}

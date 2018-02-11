package cn.com.ylpw.web.crm.service.impl.test;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ylpw.web.crm.service.test.GuestServiceI;
import cn.com.ylpw.web.crm.entity.test.GuestEntity;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**   
 * @Title: Entity
 * @Description: 访客管理
 * @author L.T.auto
 * @date 2018-01-23 10:46:59
 * @version V1.0   
 */
@Service("guestService")
@Transactional
public class GuestServiceImpl extends BaseServiceImpl<GuestEntity> implements GuestServiceI { 
	
	private static final Logger logger = LoggerFactory.getLogger(GuestServiceImpl.class);
	@Override
	protected Class setClass() {
		return GuestEntity.class;
	}
	
}
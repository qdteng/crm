package cn.com.ylpw.web.crm.service.impl.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ylpw.web.crm.service.domain.PlayPriceServiceI;
import cn.com.ylpw.web.crm.entity.domain.PlayPriceEntity;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**   
 * @Title: Entity
 * @Description: 剧目票价
 * @author L.T.auto
 * @date 2018-01-25 11:37:22
 * @version V1.0   
 */
@Service("playPriceService")
@Transactional
public class PlayPriceServiceImpl extends BaseServiceImpl<PlayPriceEntity> implements PlayPriceServiceI { 
	
	private static final Logger logger = LoggerFactory.getLogger(PlayPriceServiceImpl.class);
	@Override
	protected Class setClass() {
		return PlayPriceEntity.class;
	}
	
}
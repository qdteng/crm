package cn.com.ylpw.web.crm.service.impl.customer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.StringUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cn.com.ylpw.web.crm.entity.Enums;
import cn.com.ylpw.web.crm.entity.customer.TCustomerIndexRecency;
import cn.com.ylpw.web.crm.service.customer.CustomerIndexRecencyService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.util.SessionUtils;

@Transactional
@Service("customerIndexRecencyServiceImpl")
public class CustomerIndexRecencyServiceImpl extends BaseServiceImpl<TCustomerIndexRecency> implements CustomerIndexRecencyService{

	@Override
	protected Class setClass() {
		return TCustomerIndexRecency.class;
	}

	@Override
	public void saveOrUpdateRecency(Integer isEnableXF, Integer isEnableCZ, String monetary1, String monetary2,
			String mindex1, String mindex2, String[] monetarys1, String[] monetarys2, String[] mindexs1, String[] mindexs2, Long indexId) {
		//清空原消费策略数据
		Map<String, Object> paramMap = Maps.newHashMap();
		paramMap.put("indexid", indexId);
		super.getBaseDao().getSqlSession().delete(super.getMapperKey("delByParam"), paramMap);
		List<TCustomerIndexRecency> cirList = Lists.newArrayList();
		//新增消费策略
		if(StringUtil.isNotEmpty(mindex1) || StringUtil.isNotEmpty(monetary1)){//每消费
			TCustomerIndexRecency cir = new TCustomerIndexRecency();
			cir.setCreateId(SessionUtils.currentUser().getId());
			cir.setCreateName(SessionUtils.currentUser().getName());
			cir.setCreateTime(new Date());
			if(StringUtil.isNotEmpty(mindex1)){
				cir.setMindex(Integer.valueOf(mindex1));
			}
			if(StringUtil.isNotEmpty(monetary1)){
				cir.setMonetary(BigDecimal.valueOf(Double.parseDouble(monetary1)));
			}
			cir.setIsEnable(isEnableXF);
			cir.setIsDel(Enums.isDel.FALSE);
			cir.setIndexId(indexId);
			cir.setMtype(1);
			cirList.add(cir);
		}
		if(StringUtil.isNotEmpty(mindex2) || StringUtil.isNotEmpty(monetary2)){//每充值
			TCustomerIndexRecency cir = new TCustomerIndexRecency();
			cir.setCreateId(SessionUtils.currentUser().getId());
			cir.setCreateName(SessionUtils.currentUser().getName());
			cir.setCreateTime(new Date());
			if(StringUtil.isNotEmpty(mindex2)){
				cir.setMindex(Integer.valueOf(mindex2));
			}
			if(StringUtil.isNotEmpty(monetary2)){
				cir.setMonetary(BigDecimal.valueOf(Double.parseDouble(monetary2)));
			}
			cir.setIsEnable(isEnableCZ);
			cir.setIsDel(Enums.isDel.FALSE);
			cir.setIndexId(indexId);
			cir.setMtype(3);
			cirList.add(cir);
		}
		if(null != mindexs1 && mindexs1.length > 0){
			for(int i = 0; i < mindexs1.length; i++){//一次性消费
				if(!(StringUtil.isEmpty(mindexs1[i]) && StringUtil.isEmpty(monetarys1[i]))){//同时为空不保存
					TCustomerIndexRecency cir = new TCustomerIndexRecency();
					cir.setCreateId(SessionUtils.currentUser().getId());
					cir.setCreateName(SessionUtils.currentUser().getName());
					cir.setCreateTime(new Date());
					if(StringUtil.isNotEmpty(mindexs1[i])){
						cir.setMindex(Integer.valueOf(mindexs1[i]));
					}
					if(StringUtil.isNotEmpty(monetarys1[i])){
						cir.setMonetary(BigDecimal.valueOf(Double.parseDouble(monetarys1[i])));
					}
					cir.setIsEnable(isEnableXF);
					cir.setIsDel(Enums.isDel.FALSE);
					cir.setIndexId(indexId);
					cir.setMtype(2);
					cirList.add(cir);
				}
			}
		}
		if(null != mindexs2 && mindexs2.length > 0){
			for(int i = 0; i < mindexs2.length; i++){//一次性充值
				if(!(StringUtil.isEmpty(mindexs2[i]) && StringUtil.isEmpty(monetarys2[i]))){//同时为空不保存
					TCustomerIndexRecency cir = new TCustomerIndexRecency();
					cir.setCreateId(SessionUtils.currentUser().getId());
					cir.setCreateName(SessionUtils.currentUser().getName());
					cir.setCreateTime(new Date());
					if(StringUtil.isNotEmpty(mindexs2[i])){
						cir.setMindex(Integer.valueOf(mindexs2[i]));
					}
					if(StringUtil.isNotEmpty(monetarys2[i])){
						cir.setMonetary(BigDecimal.valueOf(Double.parseDouble(monetarys2[i])));
					}
					cir.setIsEnable(isEnableCZ);
					cir.setIsDel(Enums.isDel.FALSE);
					cir.setIndexId(indexId);
					cir.setMtype(4);
					cirList.add(cir);
				}
			}
		}
		
		super.getBaseDao().getSqlSession().insert(super.getMapperKey("insertBatchSelective"), cirList);
	}

}

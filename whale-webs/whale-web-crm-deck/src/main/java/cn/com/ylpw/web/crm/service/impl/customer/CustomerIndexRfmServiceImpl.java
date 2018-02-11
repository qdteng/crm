package cn.com.ylpw.web.crm.service.impl.customer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.StringUtil;

import cn.com.ylpw.web.crm.entity.Enums;
import cn.com.ylpw.web.crm.entity.customer.TCustomerIndexRfm;
import cn.com.ylpw.web.crm.service.customer.CustomerIndexRfmService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.util.SessionUtils;

@Transactional
@Service("customerIndexRfmServiceImpl")
public class CustomerIndexRfmServiceImpl extends BaseServiceImpl<TCustomerIndexRfm> implements CustomerIndexRfmService{

	@Override
	protected Class setClass() {
		return TCustomerIndexRfm.class;
	}

	@Override
	public void saveOrUpdateRfm(String[] recency, String[] rindex,
			String[] frequency, String[] findex, String[] monetary,
			String[] mindex, String[] isLoss, String[] id, Long indexId) {
		//删除,除了id里的其它策略要删掉
		if(null != id && id.length > 0) {
			Map<String , Object>  parma = new HashMap<String , Object>() ;
			Long[] ids = new Long[id.length];
			for(int i = 0; i < id.length; i++) {
				if(StringUtils.isNotBlank(id[i])) {
					ids[i] = Long.parseLong(id[i]);
				}else {
					ids[i] = 0l;
				}
			}
			parma.put("ids", ids);
			this.getBaseDao().getSqlSession().delete(this.getMapperKey("batchDel"), parma);
		}else {
			this.getBaseDao().getSqlSession().delete(this.getMapperKey("batchDel"), null);
		}
		for(int i = 0; i < id.length; i++){
			if(StringUtil.isEmpty(id[i])){//新增
				TCustomerIndexRfm cir = new TCustomerIndexRfm();
				Boolean b = false;
				cir.setCreateId(SessionUtils.currentUser().getId());
				cir.setCreateName(SessionUtils.currentUser().getName());
				cir.setCreateTime(new Date());
				if(StringUtil.isNotEmpty(rindex[i])){
					cir.setRindex(Integer.parseInt(rindex[i]));
					b = true;
				}
				if(StringUtil.isNotEmpty(recency[i])){
					cir.setRecency(Integer.parseInt(recency[i]));
					b = true;
				}
				if(StringUtil.isNotEmpty(monetary[i])){
					cir.setMonetary(BigDecimal.valueOf(Double.valueOf(monetary[i])));
					b = true;
				}
				if(StringUtil.isNotEmpty(mindex[i])){
					cir.setMindex(Integer.parseInt(mindex[i]));
					b = true;
				}
				if(StringUtil.isNotEmpty(isLoss[i])){
					cir.setIsLoss(Integer.parseInt(isLoss[i]));
				}
				if(StringUtil.isNotEmpty(frequency[i])){
					cir.setFrequency(Integer.parseInt(frequency[i]));
					b = true;
				}
				if(StringUtil.isNotEmpty(findex[i])){
					cir.setFindex(Integer.parseInt(findex[i]));
					b = true;
				}
				cir.setIndexId(indexId);//策略ID
				cir.setIsDel(Enums.isDel.FALSE);
				if(b){
					this.insertSelective(cir);
				}
			}else{//更新
				TCustomerIndexRfm cir = this.selectByPrimaryKey(Long.parseLong(id[i]));
				if(StringUtil.isNotEmpty(rindex[i])){
					cir.setRindex(Integer.parseInt(rindex[i]));
				}
				if(StringUtil.isNotEmpty(recency[i])){
					cir.setRecency(Integer.parseInt(recency[i]));
				}
				if(StringUtil.isNotEmpty(monetary[i])){
					cir.setMonetary(BigDecimal.valueOf(Double.valueOf(monetary[i])));
				}
				if(StringUtil.isNotEmpty(mindex[i])){
					cir.setMindex(Integer.parseInt(mindex[i]));
				}
				if(StringUtil.isNotEmpty(isLoss[i])){
					cir.setIsLoss(Integer.parseInt(isLoss[i]));
				}
				if(StringUtil.isNotEmpty(frequency[i])){
					cir.setFrequency(Integer.parseInt(frequency[i]));
				}
				if(StringUtil.isNotEmpty(findex[i])){
					cir.setFindex(Integer.parseInt(findex[i]));
				}
				cir.setIndexId(indexId);//策略ID
				cir.setIsDel(Enums.isDel.FALSE);
				cir.setUpdateId(SessionUtils.currentUser().getId());
				cir.setUpdateName(SessionUtils.currentUser().getName());
				cir.setUpdateTime(new Date());
				this.updateByPrimaryKeySelective(cir);
			}
		}
	}

}

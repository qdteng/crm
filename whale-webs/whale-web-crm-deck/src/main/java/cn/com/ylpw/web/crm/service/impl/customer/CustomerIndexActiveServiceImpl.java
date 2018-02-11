package cn.com.ylpw.web.crm.service.impl.customer;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.StringUtil;

import cn.com.ylpw.web.crm.entity.Enums;
import cn.com.ylpw.web.crm.entity.customer.TCustomerIndexActive;
import cn.com.ylpw.web.crm.service.customer.CustomerIndexActiveService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.util.SessionUtils;

@Transactional
@Service("customerIndexActiveServiceImpl")
public class CustomerIndexActiveServiceImpl extends BaseServiceImpl<TCustomerIndexActive> implements CustomerIndexActiveService{

	@Override
	protected Class setClass() {
		return TCustomerIndexActive.class;
	}

	@Override
	public void saveOrUpdateActive(Map<String, Object> searchParam, String[] aindexs, String[] anums, Long indexId) {
		List<Map<String, Object>> allList = this.getBaseDao().getSqlSession().selectList(super.getMapperKey("findAll"));//得到会员活动相关所有成长值的记录
		Boolean b1=true, b3=true, b4=true, b5=true, b6=true, b7=true;
		if(null != allList && allList.size() > 0){
			for(Map<String, Object> map : allList){
				if(null != map.get("ATYPE")){
					switch(Integer.parseInt(map.get("ATYPE").toString())){
					case 1://每日签到
						b1=false;
						TCustomerIndexActive cia1 = this.selectByPrimaryKey(Long.parseLong(map.get("ID").toString()));
						cia1.setAindex(Integer.parseInt(map.get("AINDEX").toString()));
						cia1.setIsEnable(Integer.parseInt(searchParam.get("isEnable1").toString()));
						cia1.setUpdateId(SessionUtils.currentUser().getId());
						cia1.setUpdateName(SessionUtils.currentUser().getName());
						cia1.setUpdateTime(new Date());
						this.updateByPrimaryKeySelective(cia1);
						break;
					case 2:
						this.deleteByPrimaryKey(Long.parseLong(map.get("ID").toString()));//删除原数据
						break;
					case 3:
						b3=false;
						TCustomerIndexActive cia3 = this.selectByPrimaryKey(Long.parseLong(map.get("ID").toString()));
						cia3.setAindex(Integer.parseInt(map.get("AINDEX").toString()));
						cia3.setIsEnable(Integer.parseInt(searchParam.get("isEnable2").toString()));
						cia3.setUpdateId(SessionUtils.currentUser().getId());
						cia3.setUpdateName(SessionUtils.currentUser().getName());
						cia3.setUpdateTime(new Date());
						this.updateByPrimaryKeySelective(cia3);
						break;
					case 4:
						b4=false;
						TCustomerIndexActive cia4 = this.selectByPrimaryKey(Long.parseLong(map.get("ID").toString()));
						cia4.setAindex(Integer.parseInt(map.get("AINDEX").toString()));
						cia4.setIsEnable(Integer.parseInt(searchParam.get("isEnable2").toString()));
						cia4.setUpdateId(SessionUtils.currentUser().getId());
						cia4.setUpdateName(SessionUtils.currentUser().getName());
						cia4.setUpdateTime(new Date());
						this.updateByPrimaryKeySelective(cia4);
						break;
					case 5:
						b5=false;
						TCustomerIndexActive cia5 = this.selectByPrimaryKey(Long.parseLong(map.get("ID").toString()));
						cia5.setAindex(Integer.parseInt(map.get("AINDEX").toString()));
						cia5.setIsEnable(Integer.parseInt(searchParam.get("isEnable3").toString()));
						cia5.setUpdateId(SessionUtils.currentUser().getId());
						cia5.setUpdateName(SessionUtils.currentUser().getName());
						cia5.setUpdateTime(new Date());
						this.updateByPrimaryKeySelective(cia5);
						break;
					case 6:
						b6=false;
						TCustomerIndexActive cia6 = this.selectByPrimaryKey(Long.parseLong(map.get("ID").toString()));
						cia6.setAindex(Integer.parseInt(map.get("AINDEX").toString()));
						cia6.setIsEnable(Integer.parseInt(searchParam.get("isEnable3").toString()));
						cia6.setUpdateId(SessionUtils.currentUser().getId());
						cia6.setUpdateName(SessionUtils.currentUser().getName());
						cia6.setUpdateTime(new Date());
						this.updateByPrimaryKeySelective(cia6);
						break;
					case 7:
						b7=false;
						TCustomerIndexActive cia7 = this.selectByPrimaryKey(Long.parseLong(map.get("ID").toString()));
						cia7.setAindex(Integer.parseInt(map.get("AINDEX").toString()));
						cia7.setIsEnable(Integer.parseInt(searchParam.get("isEnable4").toString()));
						cia7.setUpdateId(SessionUtils.currentUser().getId());
						cia7.setUpdateName(SessionUtils.currentUser().getName());
						cia7.setUpdateTime(new Date());
						this.updateByPrimaryKeySelective(cia7);
						break;
					}
				}
			}
		}
		//增加
		List<TCustomerIndexActive> ciaList = Lists.newArrayList();
		if(b1 && null != searchParam.get("aindex1")){//每日签到
			TCustomerIndexActive cia = new TCustomerIndexActive();
			cia.setCreateId(SessionUtils.currentUser().getId());
			cia.setCreateName(SessionUtils.currentUser().getName());
			cia.setCreateTime(new Date());
			cia.setAindex(Integer.parseInt(searchParam.get("aindex1").toString()));
			cia.setIndexId(indexId);
			cia.setIsDel(Enums.isDel.FALSE);
			cia.setIsEnable(Integer.parseInt(searchParam.get("isEnable1").toString()));
			cia.setAtype(1);
			ciaList.add(cia);
		}
		if(null != aindexs || null != anums){//连续签到
			int j = null != aindexs ? aindexs.length : anums.length;
			for(int i = 0; i < j; i++){
				TCustomerIndexActive cia = new TCustomerIndexActive();
				cia.setCreateId(SessionUtils.currentUser().getId());
				cia.setCreateName(SessionUtils.currentUser().getName());
				cia.setCreateTime(new Date());
				cia.setIndexId(indexId);
				cia.setIsDel(Enums.isDel.FALSE);
				cia.setIsEnable(Integer.parseInt(searchParam.get("isEnable1").toString()));
				if(StringUtil.isNotEmpty(aindexs[i])){}
				cia.setAindex(StringUtil.isNotEmpty(aindexs[i])?Integer.parseInt(aindexs[i]):0);
				cia.setAnum(StringUtil.isNotEmpty(anums[i])?Integer.parseInt(anums[i]):0);
				cia.setAtype(2);
				ciaList.add(cia);
			}
		}
		if(b3 && null != searchParam.get("aindex3")){//每次分享
			TCustomerIndexActive cia = new TCustomerIndexActive();
			cia.setCreateId(SessionUtils.currentUser().getId());
			cia.setCreateName(SessionUtils.currentUser().getName());
			cia.setCreateTime(new Date());
			cia.setAindex(Integer.parseInt(searchParam.get("aindex3").toString()));
			cia.setIndexId(indexId);
			cia.setIsDel(Enums.isDel.FALSE);
			cia.setIsEnable(Integer.parseInt(searchParam.get("isEnable2").toString()));
			cia.setAtype(3);
			ciaList.add(cia);
		}
		if(b4 && null != searchParam.get("aindex4")){//最多分享
			TCustomerIndexActive cia = new TCustomerIndexActive();
			cia.setCreateId(SessionUtils.currentUser().getId());
			cia.setCreateName(SessionUtils.currentUser().getName());
			cia.setCreateTime(new Date());
			cia.setAindex(Integer.parseInt(searchParam.get("aindex4").toString()));
			cia.setIndexId(indexId);
			cia.setIsDel(Enums.isDel.FALSE);
			cia.setIsEnable(Integer.parseInt(searchParam.get("isEnable2").toString()));
			cia.setAtype(4);
			ciaList.add(cia);		
		}
		if(b5 && null != searchParam.get("aindex5")){//每次订阅
			TCustomerIndexActive cia = new TCustomerIndexActive();
			cia.setCreateId(SessionUtils.currentUser().getId());
			cia.setCreateName(SessionUtils.currentUser().getName());
			cia.setCreateTime(new Date());
			cia.setAindex(Integer.parseInt(searchParam.get("aindex5").toString()));
			cia.setIndexId(indexId);
			cia.setIsDel(Enums.isDel.FALSE);
			cia.setIsEnable(Integer.parseInt(searchParam.get("isEnable3").toString()));
			cia.setAtype(5);
			ciaList.add(cia);
		}
		if(b6 && null != searchParam.get("aindex6")){//最多订阅
			TCustomerIndexActive cia = new TCustomerIndexActive();
			cia.setCreateId(SessionUtils.currentUser().getId());
			cia.setCreateName(SessionUtils.currentUser().getName());
			cia.setCreateTime(new Date());
			cia.setAindex(Integer.parseInt(searchParam.get("aindex6").toString()));
			cia.setIndexId(indexId);
			cia.setIsDel(Enums.isDel.FALSE);
			cia.setIsEnable(Integer.parseInt(searchParam.get("isEnable3").toString()));
			cia.setAtype(6);
			ciaList.add(cia);
		}
		if(b7 && null != searchParam.get("aindex7")){//领卡
			TCustomerIndexActive cia = new TCustomerIndexActive();
			cia.setCreateId(SessionUtils.currentUser().getId());
			cia.setCreateName(SessionUtils.currentUser().getName());
			cia.setCreateTime(new Date());
			cia.setAindex(Integer.parseInt(searchParam.get("aindex7").toString()));
			cia.setIndexId(indexId);
			cia.setIsDel(Enums.isDel.FALSE);
			cia.setIsEnable(Integer.parseInt(searchParam.get("isEnable4").toString()));
			cia.setAtype(7);
			ciaList.add(cia);
		}
		if(null != ciaList && ciaList.size() > 0){
			this.getBaseDao().getSqlSession().insert(super.getMapperKey("insertBatchSelective"), ciaList);
		}
	}

}

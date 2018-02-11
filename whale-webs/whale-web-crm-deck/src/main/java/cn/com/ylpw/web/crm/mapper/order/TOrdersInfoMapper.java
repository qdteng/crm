package cn.com.ylpw.web.crm.mapper.order;

import java.util.List;
import java.util.Map;

import cn.com.ylpw.web.crm.entity.order.TOrdersInfo;

public interface TOrdersInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TOrdersInfo record);

    int insertSelective(TOrdersInfo record);

    TOrdersInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TOrdersInfo record);

    int updateByPrimaryKey(TOrdersInfo record);
    
    List<Map<String, Object>> findOrdersGroupByPros(Long pwsysid);
}
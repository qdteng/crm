package cn.com.ylpw.web.crm.service.impl.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.web.crm.entity.customer.TCustomerLable;
import cn.com.ylpw.web.crm.entity.customer.TCustomerNote;
import cn.com.ylpw.web.crm.mapper.customer.TCustomerPropertysMapper;
import cn.com.ylpw.web.crm.model.tree.ZTreeNode;
import cn.com.ylpw.web.crm.service.customer.CustomerLableService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.util.Page;

@Transactional
@Service("customerLableServiceImpl")
public class CustomerLableServiceImpl  extends  BaseServiceImpl<TCustomerLable>    implements CustomerLableService {
	
	@Autowired
	TCustomerPropertysMapper customerPropertysMapper  ;
	
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerLableServiceImpl.class);
	@Override
	protected Class setClass() {
		return TCustomerLable.class;
	}
	@Override
	public List<ZTreeNode> loadChild(Integer pid) {
		Page<Map<String,Object>> page  =new Page<Map<String,Object>>() ;
		page.setPageSize(Integer.MAX_VALUE);
		Map<String ,Object> searchParam = new  HashMap<String ,Object>() ;
		searchParam.put("id", pid);
		
		List<Map<String,Object>> resultList = this.pageFindModel("loadChild", page, searchParam).getList();
		List<ZTreeNode> ChildNodes = new ArrayList<ZTreeNode>();
		logger.info("查询ID:{}子标签{}条",pid,resultList.size());
		for (Map<String,Object> map : resultList){
			ZTreeNode node = new ZTreeNode() ;
			try {
				node.setHasChildren(MapUtils.getInteger(map, "hasChildren")>0?true:false );
				node.setIsHasProperty(MapUtils.getInteger(map, "hasProperty")>0?true:false);
				node.setIsParent(MapUtils.getInteger(map, "hasChildren")>0?true:false );
				node.setName(MapUtils.getString(map, "text"));
				node.setId(map.get("value").toString());
				
			}catch ( Exception e){
				logger.error("ZTreeNode属性转换错误",e);
				e.printStackTrace();
			}
			ChildNodes.add(node) ;
		}
		return ChildNodes;
	}
	
	
	@Override
	public int delLable(Long id) {
		this.logger.info("删除标签{}相关属性...",id);
		customerPropertysMapper.deleteByLableId(id);
		this.logger.info("删除标签{}...",id);
		this.deleteByPrimaryKey(id);
		return 0;
	}
	@Override
	public ZTreeNode  searchNode(String nodeName) {

		Page<Map<String,Object>> page  =new Page<Map<String,Object>>() ;
		page.setPageSize(Integer.MAX_VALUE);
		Map<String ,Object> searchParam = new  HashMap<String ,Object>() ;
		searchParam.put("name", nodeName);
		
		List<Map<String,Object>> resultList = this.pageFindModel("searchNode", page, searchParam).getList();
		List<ZTreeNode>   treeNodes = new ArrayList<ZTreeNode>() ;
		
		if (null!=resultList&&resultList.size()> 0 ){
			//根目录
			ZTreeNode parentNode  =	this.loadChild(-1).get(0);
			List<ZTreeNode> repetition=new ArrayList<ZTreeNode>();		
			for (Map<String,Object> map : resultList){
					ZTreeNode node = new ZTreeNode();
					node.setHasChildren( Integer.parseInt( map.get("HASCHILDREN").toString() ) > 0 ?true:false);
					node.setIsHasProperty(Integer.parseInt( map.get("HASCHILDREN").toString() ) > 0 ?true:false);
					node.setId(map.get("ID") .toString());
					node.setName(map.get("NAME") .toString());
					node.setPpid(map.get("PID") .toString());
					node.setIsParent( Integer.parseInt( map.get("HASCHILDREN").toString() ) > 0 ?true:false);
					if(node.isHasChildren()){
						node.setChildren(this.loadChild(Integer.parseInt(node.getId())));
						repetition.addAll(node.getChildren());
					}
					treeNodes.add(node) ;
			}
			
			
			//去重
			List<ZTreeNode> removeNodes=new ArrayList<ZTreeNode>();
			for( int i =0; i < treeNodes.size() ;i++){
				for (ZTreeNode childerNode : repetition){
					if (childerNode.getId().equals(treeNodes.get(i).getId())){
						removeNodes.add(treeNodes.get(i));
					}
				}
			}
			for (ZTreeNode node:removeNodes){
				treeNodes.remove(node);
			}
			
			if(null!=treeNodes){
				removeNodes = new ArrayList<ZTreeNode>();
				List<ZTreeNode> addNodes=new ArrayList<ZTreeNode>();
				
				Map<Long ,List<ZTreeNode>> notParentNodes = new  HashMap<>() ;
				
				for (ZTreeNode node : treeNodes){
					if (!node.getIsParent() &&!node.getPpid().equals("0") ){
						if ( null==notParentNodes.get(Long.parseLong(node.getPpid()))  ){
							notParentNodes.put(Long.parseLong(node.getPpid()), new ArrayList<ZTreeNode>());
						}
						notParentNodes.get(Long.parseLong(node.getPpid())).add(node);
						removeNodes.add(node);
					}
				}
				
				for ( Long pid  :notParentNodes.keySet()){
					
					TCustomerLable lable = this.selectByPrimaryKey(pid);
					ZTreeNode tmp1 = new ZTreeNode();
					tmp1.setName(lable.getName());
					tmp1.setId(lable.getId().toString());
					List<ZTreeNode>   tmp2 = new ArrayList<ZTreeNode>() ;
					
					for (ZTreeNode treeNode  : notParentNodes.get(pid)){
						tmp2.add(treeNode);
					}
					
					tmp1.setChildren(tmp2);
					addNodes.add(tmp1);
				}
				
				treeNodes.removeAll(removeNodes);
				treeNodes.addAll(addNodes);
			}
			parentNode.setChildren(treeNodes);
			return parentNode;
		}
		
		
		return null;
	}
	@Override
	public List<TCustomerNote> selectLableByGroupId(Long id) {
		
		return super.getBaseDao().getSqlSession().selectList(super.getMapperKey("selectLableByGroupId"), id); 
	}
	@Override
	public int insertSelective(TCustomerLable record) {
		return super.insertSelective(record);
	}
	@Override
	public TCustomerLable selectByPrimaryKey(Long id) {
		return super.selectByPrimaryKey( id); 
	}
	@Override
	public int updateByPrimaryKeySelective(TCustomerLable record) {
		return super.updateByPrimaryKeySelective(record) ;
	}
	@Override
	public int deleteByPrimaryKey(Long id) {
		return super.deleteByPrimaryKey(id);
	}
	@Override
	public PageInfo<Map<String, Object>> pageFindModel(String mapperKey, Page<Map<String, Object>> page,
			Object searParam) {
		return super.pageFindModel(mapperKey, page, searParam);
	}
	
	
//	//遍历顶级节点
//	for (Map<String,Object> map : resultList){
//		if (map.get("PID").toString().equals("-1")){
//			ZTreeNode node = new ZTreeNode() ;
//			node.setHasChildren( Integer.parseInt( map.get("HASCHILDREN").toString() ) > 0 ?true:false  );
//			node.setIsHasProperty(Integer.parseInt( map.get("HASCHILDREN").toString() ) > 0 ?true:false );
//			node.setId(map.get("ID") .toString());
//			node.setName(map.get("NAME") .toString());
//			treeNodes.add(node) ;
//			break ;
//		}
//	}
//
//	if (resultList.size() < 1){
//		
//	}else {
//		this.sortNodes(resultList, treeNodes);
//	}
//	
//	
//	/**
//	 * <p>标签排序</p>
//	 * @author LT
//	 * @date 2017年5月23日 上午11:38:01
//	 * @return void
//	 * @param resultList
//	 * @param treeNodes
//	 */
//	private    void  sortNodes(List<Map<String,Object>> resultList  ,  List<ZTreeNode> treeNodes   ) {
//		
//		for (ZTreeNode node  : treeNodes){
//				for (int i=0 ; i<resultList.size();i++){
//					if (resultList.get(i).get("PID").toString().equals(node.getId()) ){
//						ZTreeNode nodeObj = new ZTreeNode() ;
//						nodeObj.setHasChildren(   Integer.parseInt( resultList.get(i).get("HASCHILDREN").toString() ) > 0 ?true:false  );
//						nodeObj.setIsHasProperty( Integer.parseInt(  resultList.get(i).get("HASPROPERTY").toString() ) > 0 ?true:false );
//						nodeObj.setId(resultList.get(i).get("ID") .toString());
//						nodeObj.setName(resultList.get(i).get("NAME") .toString());
//						node.getChildren().add(nodeObj);
//					}
//				}
//			sortNodes (resultList , node.getChildren());
//		}
//	}
	
}

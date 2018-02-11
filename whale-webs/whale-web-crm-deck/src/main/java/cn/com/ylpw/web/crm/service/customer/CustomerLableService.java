
package cn.com.ylpw.web.crm.service.customer;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.web.crm.entity.customer.TCustomerLable;
import cn.com.ylpw.web.crm.entity.customer.TCustomerNote;
import cn.com.ylpw.web.crm.model.tree.ZTreeNode;
import cn.com.ylpw.web.crm.util.Page;

public interface CustomerLableService {

	public int insertSelective(TCustomerLable record);

	public TCustomerLable selectByPrimaryKey(Long id);


	public int updateByPrimaryKeySelective(TCustomerLable record);

	public int deleteByPrimaryKey(Long id);

	public PageInfo<Map<String, Object>> pageFindModel(String mapperKey, Page<Map<String, Object>> page,
			Object searParam);
	
	/***
	 *  *
	 * <p>
	 * 查询指定节点的子节点
	 * </p>
	 *  * @author LT  * @date 2017年5月19日 上午9:36:18  * @return List
	 * <TreeNode>  * @param pid  * @return
	 */
	List<ZTreeNode> loadChild(Integer pid);

	/***
	 *  *
	 * <p>
	 * 删除指定的节点，同时删除已生成的属性
	 * </p>
	 *  * @author LT  * @date 2017年5月19日 下午2:04:40  * @return int  * @param id
	 *  * @return
	 */
	int delLable(Long id);

	/***
	 *  *
	 * <p>
	 * 节点搜索
	 * </p>
	 *  * @author LT  * @date 2017年5月23日 上午10:25:40  * @return List
	 * <ZTreeNode>  * @param nodeName  * @return
	 */
	ZTreeNode searchNode(String nodeName);

	/***
	 *  *
	 * <p>
	 * 标签分组ID获取标签
	 * </p>
	 *  * @author LT  * @date 2017年6月5日 下午4:36:01  * @return TCustomerNote
	 *  * @param id  * @return  
	 */
	List<TCustomerNote> selectLableByGroupId(Long id);

}

package cn.com.ylpw.web.crm.controller.test;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.ylpw.web.crm.controller.BasicController;
import com.github.pagehelper.PageInfo;
import cn.com.ylpw.web.crm.util.Page;
import cn.com.ylpw.web.crm.entity.test.GuestEntity;
import cn.com.ylpw.web.crm.service.test.GuestServiceI;
import cn.com.ylpw.core.tools.AjaxResult;
import java.util.Map;
import org.springframework.ui.ModelMap;
import cn.com.ylpw.web.crm.util.SessionUtils;
import java.util.Date;

/**   
 * @Title: Controller
 * @Description: 访客管理
 * @author L.T.auto
 * @date 2018-01-23 10:46:59
 * @version V1.0   
 */
@Controller
public class GuestController extends BasicController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(GuestController.class);
	@Autowired
	private GuestServiceI guestService;

	/**
	 * 访客管理列表 页面跳转
	 * @return
	 */
	@RequestMapping( "/guest/list")
	public String list(HttpServletRequest request ,Page<Map<String,Object>> page, ModelMap model,
			@RequestParam(required=false) Map<String,Object> searchParam  ) {
			logger.info("加载访客管理列表");
	    	PageInfo<Map<String,Object>>  pageInfo =guestService.pageFindModel( "pageFind", page, searchParam);
			model.put("dateList", pageInfo.getList());
			model.put("page",  page );
			model.put("searchParam", searchParam);
			return "/test/guestList";
	}


	/**
	 * 删除访客管理
	 * @return
	 */
	@RequestMapping( "/guest/del")
	@ResponseBody
	public AjaxResult del(Long [] ids, HttpServletRequest request) {
		AjaxResult  ajaxResult = AjaxResult.Instance();
		if(ids.length>0){
			logger.info("批量删除ID{}" , ids);
			guestService.batchDel(ids) ;
		}
		return ajaxResult;
	}


	/**
	 * 处理页面的添加或更新请求访客管理
	 * @param ids
	 * @return
	 */
	@RequestMapping( "/guest/save")
	@ResponseBody
	public AjaxResult save(GuestEntity guest, HttpServletRequest request) {
		String message = null;
		AjaxResult j = AjaxResult.Instance();
		if (null!=guest.getId() && guest.getId()>0   ) {
			message = "访客管理更新成功";
			try {
				guest.setUpdateId(SessionUtils.currentUser().getId());
				guest.setUpdateName(SessionUtils.currentUser().getName());
				guest.setUpdateTime(new Date());
				guestService.updateByPrimaryKeySelective(guest) ;
			} catch (Exception e) {
				e.printStackTrace();
				message = "访客管理更新失败";
			}
		}else{
			message = "访客管理添加成功";
			guest.setCreateTime(new Date());
			guest.setCreateId(SessionUtils.currentUser().getId());
			guest.setCreateName(SessionUtils.currentUser().getName());
			guestService.insertSelective(guest);
		}
		j.setMessage(message);
		return j;
	}

	/**
	 * 访客管理跳转 添加或更新的页面
	 * @return
	 */
	@RequestMapping( "/guest/addorupdate")
	public String addorupdate( Long id,ModelMap model, HttpServletRequest req) {
	
		if(null != id && id > 0){
			GuestEntity entity = guestService.selectByPrimaryKey(id);
			model.put("entity", entity);
			model.put("id", id);
		}
		return "/test/guest";
	}
	
}

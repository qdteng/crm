package cn.com.ylpw.web.crm.controller.domain;
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
import cn.com.ylpw.web.crm.entity.domain.PlayPriceEntity;
import cn.com.ylpw.web.crm.service.domain.PlayPriceServiceI;
import cn.com.ylpw.core.tools.AjaxResult;
import java.util.Map;
import org.springframework.ui.ModelMap;
import cn.com.ylpw.web.crm.util.SessionUtils;
import java.util.Date;

/**   
 * @Title: Controller
 * @Description: 剧目票价
 * @author L.T.auto
 * @date 2018-01-25 11:37:23
 * @version V1.0   
 */
@Controller
public class PlayPriceController extends BasicController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(PlayPriceController.class);
	@Autowired
	private PlayPriceServiceI playPriceService;

	/**
	 * 剧目票价列表 页面跳转
	 * @return
	 */
	@RequestMapping( "/playPrice/list")
	public String list(HttpServletRequest request ,Page<Map<String,Object>> page, ModelMap model,
			@RequestParam(required=false) Map<String,Object> searchParam  ) {
			logger.info("加载剧目票价列表");
	    	PageInfo<Map<String,Object>>  pageInfo =playPriceService.pageFindModel( "pageFind", page, searchParam);
			model.put("dateList", pageInfo.getList());
			model.put("page",  page );
			model.put("searchParam", searchParam);
			return "/domain/playPriceList";
	}


	/**
	 * 删除剧目票价
	 * @return
	 */
	@RequestMapping( "/playPrice/del")
	@ResponseBody
	public AjaxResult del(Long [] ids, HttpServletRequest request) {
		AjaxResult  ajaxResult = AjaxResult.Instance();
		if(ids.length>0){
			logger.info("批量删除ID{}" , ids);
			playPriceService.batchDel(ids) ;
		}
		return ajaxResult;
	}


	/**
	 * 处理页面的添加或更新请求剧目票价
	 * @param ids
	 * @return
	 */
	@RequestMapping( "/playPrice/save")
	@ResponseBody
	public AjaxResult save(PlayPriceEntity playPrice, HttpServletRequest request) {
		String message = null;
		AjaxResult j = AjaxResult.Instance();
		if (null!=playPrice.getId() && playPrice.getId()>0   ) {
			message = "剧目票价更新成功";
			try {
				playPrice.setUpdateId(SessionUtils.currentUser().getId());
				playPrice.setUpdateName(SessionUtils.currentUser().getName());
				playPrice.setUpdateTime(new Date());
				playPriceService.updateByPrimaryKeySelective(playPrice) ;
			} catch (Exception e) {
				e.printStackTrace();
				message = "剧目票价更新失败";
			}
		}else{
			message = "剧目票价添加成功";
			playPrice.setCreateTime(new Date());
			playPrice.setCreateId(SessionUtils.currentUser().getId());
			playPrice.setCreateName(SessionUtils.currentUser().getName());
			playPriceService.insertSelective(playPrice);
		}
		j.setMessage(message);
		return j;
	}

	/**
	 * 剧目票价跳转 添加或更新的页面
	 * @return
	 */
	@RequestMapping( "/playPrice/addorupdate")
	public String addorupdate( Long id,ModelMap model, HttpServletRequest req) {
	
		if(null != id && id > 0){
			PlayPriceEntity entity = playPriceService.selectByPrimaryKey(id);
			model.put("entity", entity);
			model.put("id", id);
		}
		return "/domain/playPrice";
	}
	
}

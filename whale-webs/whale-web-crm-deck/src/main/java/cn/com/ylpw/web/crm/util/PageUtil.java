/**
 * <p>Title: PageUtil.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017, zj7687362@gmail.com All Rights Reserved. </p>
 * <p>Company: www.jcore.cn</p>
 * @author 张嘉杰
 * @date 2017年2月24日 下午4:08:21
 */
package cn.com.ylpw.web.crm.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;

import cn.com.ylpw.core.tools.StringTool;

/**
 * <p>Title: PageUtil.java</p>
 * <p>Description: 分页插件</p>
 * @author 张嘉杰
 * @date 2017年2月24日 下午4:08:21
 */
public class PageUtil {
	
	/**
	 * @param page pagehelper分页对象
	 * @param param 分页参数map
	 * @return 返回分页字符串脚本
	 */
	public static String toHtml(PageInfo<?> page, HttpServletRequest req){
		
		String pageNo = "pageNo", 
			   pageSize = "pageSize", 
			   pageParameter = pageNo.concat("=%s").concat("&").concat(pageSize).concat("=%s");
		
//PageInfo{pageNum=10, pageSize=5, size=5, startRow=46, endRow=50, total=148, pages=30, 
//list=Page{count=true, pageNum=10, pageSize=5, startRow=45, endRow=50, total=148, pages=30, countSignal=false, orderBy='null', orderByOnly=false, reasonable=true, pageSizeZero=true}, firstPage=6, prePage=9, nextPage=11, lastPage=13, isFirstPage=false, isLastPage=false, hasPreviousPage=true, hasNextPage=true, navigatePages=8, navigatepageNums=[6, 7, 8, 9, 10, 11, 12, 13]}

		Map<String, String> map = Maps.newTreeMap();
		for (String key : req.getParameterMap().keySet()) {
			String value = StringUtils.join(req.getParameterMap().get(key));
			map.put(key, value);
		}
		map.remove(pageNo);
		map.remove(pageSize);
		
//		System.out.println(map);
//		System.out.println(page.toString());
//		System.out.println(page.getList());
		
		String url = req.getRequestURI() + (map.size() == 0 ? "?" : "?".concat(StringTool.map2String(map).concat("&")));
		
		int[] navigatepageNums = page.getNavigatepageNums();
		
		if(navigatepageNums.length == 0) return null;
		
		StringBuffer pageHTML = new StringBuffer();
		pageHTML.append("<div class=\"pagination\">");
		pageHTML.append("<ul class=\"pagination\">");
		
		// 判断是否有上一页
		if(page.isHasPreviousPage())
			pageHTML.append(String.format("<li class=\"disabled\"><a href=\"%s\">&#171; 上一页</a></li>", url + String.format(pageParameter, page.getPrePage(), page.getPageSize())));
		else
			pageHTML.append("<li class=\"disabled\"><a href=\"javascript:\">&#171; 上一页</a></li>");
		
		// 首页显示判断
		if(navigatepageNums.length == page.getNavigatePages() &&
				navigatepageNums[0] != 1)
			pageHTML.append(String.format("<li class=\"disabled\"><a href=\"%s\">%s</a></li>", url + String.format(pageParameter, 1, page.getPageSize()), 1));
		
		// 前页 ... 显示判断
		if(navigatepageNums[0] != 1)
			pageHTML.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>");
		
		// 页码
		for (int i = 0; i < navigatepageNums.length; i++) {
			int navigatepageNum = navigatepageNums[i];
			String checkClass = (navigatepageNum == page.getPageNum()) ? "active" : "disabled";
			pageHTML.append(String.format("<li class=\"%s\"><a href=\"%s\">%s</a></li>", checkClass, url + String.format(pageParameter, navigatepageNum, page.getPageSize()) , navigatepageNum));
		}
		
		// 后页 ... 显示判断
		int lastPageNum = navigatepageNums[navigatepageNums.length-1];
		if(navigatepageNums.length == page.getNavigatePages() && 
				lastPageNum != page.getPages())
			pageHTML.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>");
		
		// 末页显示判断
		if(lastPageNum != page.getPages())
			pageHTML.append(String.format("<li class=\"disabled\"><a href=\"%s\">%s</a></li>", url + String.format(pageParameter, page.getPages(), page.getPageSize()), page.getPages()));
		
		// 判断是否有下一页
		if(page.isHasNextPage())
			pageHTML.append(String.format("<li class=\"disabled\"><a href=\"%s\">下一页 &#187;</a></li>", url + String.format(pageParameter, page.getNextPage(), page.getPageSize())));
		else
			pageHTML.append("<li class=\"disabled\"><a href=\"javascript:\">下一页 &#187;</a></li>");
		
		pageHTML.append("<li class=\"disabled controls\">");
		pageHTML.append(String.format("<a href=\"javascript:\">当前 <input type=\"text\" value=\"%s\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)page(this.value,20,'');\" onclick=\"this.select();\" />",page.getPageNum()));
		pageHTML.append(String.format("/ <input type=\"text\" value=\"%s\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');\" onclick=\"this.select();\" />",page.getPages()));
		pageHTML.append(String.format("条，共 %s 条</a></li>", page.getTotal()));
		pageHTML.append("</li>");
		pageHTML.append("<div style=\"clear:both;\"></div>");
		pageHTML.append("</ul>");
		pageHTML.append("</div>");
		
		return pageHTML.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

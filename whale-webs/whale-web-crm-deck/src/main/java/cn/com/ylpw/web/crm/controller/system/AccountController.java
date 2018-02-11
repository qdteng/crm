/**
 * <p>Title: AccountController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017, zj7687362@gmail.com All Rights Reserved. </p>
 * <p>Company: www.jcore.cn</p>
 * @author 张嘉杰
 * @date 2017年2月27日 下午4:15:57
 */
package cn.com.ylpw.web.crm.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title: AccountController.java</p>
 * <p>Description: 账户系统控制器</p>
 * @author 张嘉杰
 * @date 2017年2月27日 下午4:15:57
 */
@Controller("accountController")
@RequestMapping("/account")
public class AccountController {
	
	@RequestMapping("/accountManage")
	public String accountManage(ModelMap model){
		return "/account/accountManage";
	}
	
	
}

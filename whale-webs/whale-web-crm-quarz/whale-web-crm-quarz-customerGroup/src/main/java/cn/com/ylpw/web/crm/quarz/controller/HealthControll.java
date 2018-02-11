package cn.com.ylpw.web.crm.quarz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("healthControll")
public class HealthControll {
	
	/**
	 * 运维可用的检测心跳的路径
	 */
	public final  static String HEALTH_PATH = "/crm/h/check";
	
	@RequestMapping(HEALTH_PATH)
    public String home() {
        return "ok";
    }
}

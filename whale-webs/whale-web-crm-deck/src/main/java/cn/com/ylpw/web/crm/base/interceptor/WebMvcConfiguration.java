package cn.com.ylpw.web.crm.base.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.com.ylpw.core.tools.Globals;
import cn.com.ylpw.web.crm.service.sys.SysMenuService;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    
    @Autowired
    private SysMenuService sysMenuService;
    
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new GlobalInterceptor(sysMenuService)).addPathPatterns("/**").excludePathPatterns(Globals.HEALTH_PATH);
	}
    
}
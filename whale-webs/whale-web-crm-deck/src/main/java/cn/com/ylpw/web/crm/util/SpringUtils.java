package cn.com.ylpw.web.crm.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

 /**
  * @ClassName: SpringUtils
  * @Description: Spring 工具类，用途获取Spring上下文，实体Bean，环境（dev,test,product）等
  * @author zhaohb
  * @date 2017-3-16 下午5:39:01
  */
@Component
public class SpringUtils implements ApplicationContextAware {
  
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = applicationContext;
        }
    }

    // 获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }
    
    /**
      * @Title: environment
      * @Description: 获取配置环境（dev,test,product）等
      * @return
      * 
      * @author zhaohb
      * @date 2017-3-16 下午5:41:10
      */
    public static String environment() {
        String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
        if (ObjectUtils.isEmpty(activeProfiles)) {
            String[] defaultProfiles = applicationContext.getEnvironment().getDefaultProfiles();
            return StringUtils.arrayToCommaDelimitedString(defaultProfiles);
        } else {
            return StringUtils.arrayToCommaDelimitedString(activeProfiles);
        }
    }

}
/**
 * <p>Title: SqlSessionFactoryUpdateConfigurationBean.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017, zj7687362@gmail.com All Rights Reserved. </p>
 * <p>Company: www.jcore.cn</p>
 * @author 张嘉杰
 * @date 2017年2月18日 下午7:01:16
 */
package cn.com.ylpw.boot.starters.mybatis;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * <p>Title: SqlSessionFactoryUpdateConfigurationBean.java</p>
 * <p>Description: SqlSession工厂更新配置Bean</p>
 * @author 张嘉杰
 * @date 2017年2月18日 下午7:01:16
 */
public class SqlSessionFactoryUpdateConfigurationBean extends SqlSessionFactoryBean {
	
    private static final Log log = LogFactory.getLog(SqlSessionFactoryUpdateConfigurationBean.class);

    private Properties configurationProperties;

    @Override
    public void setConfigurationProperties(Properties configurationProperties) {
        this.configurationProperties = configurationProperties;
    }

    @Override
    public SqlSessionFactory getObject() throws Exception {
        SqlSessionFactory sqlSessionFactory = super.getObject();
        updateConfiguration(sqlSessionFactory.getConfiguration());
        return sqlSessionFactory;
    }

    private void updateConfiguration(Configuration configuration) {
        if (configurationProperties == null) { 
            return;
        }

        BeanWrapper bw = new BeanWrapperImpl(configuration);
        Set<Map.Entry<Object, Object>> entries = configurationProperties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            String propertyName = entry.getKey().toString();
            Object propertyValue = entry.getValue();
            try {
                bw.setPropertyValue(propertyName, propertyValue);
            } catch (Exception e) {
            	log.warn(propertyValue + " values are not set in " + propertyName + " property!" + " (" + e.getMessage() + ")");
            }
        }
    }
}
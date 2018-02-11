package cn.com.ylpw.web.crm.base;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {
	
	@Autowired SpringContextHolder springContextHolder;
	
	@Value("${spring.datasource.type}")
	private Class<? extends DataSource> dataSourceType;
	//TODO 配置多个数据源
	@Value("${spring.datasource.readSize}")
	private String dataSourceSize;

//	@Bean(name = "masterDataSource", destroyMethod = "close", initMethod="init")
//	@Primary
//	@ConfigurationProperties(prefix = "spring.datasource.master")
//	public DataSource masterDataSource() {
//		return DataSourceBuilder.create().type(dataSourceType).build();
//	}

//	@Bean(name = "slaveDataSource1")
//	@ConfigurationProperties(prefix = "spring.datasource.slave1")
//	public DataSource slaveDataSource1() {
//		return DataSourceBuilder.create().type(dataSourceType).build();
//	}
//	
//	@Bean(name = "slaveDataSource2")
//	@ConfigurationProperties(prefix = "spring.datasource.slave2")
//	public DataSource slaveDataSource2() {
//		return DataSourceBuilder.create().type(dataSourceType).build();
//	}
	
//	@Bean("readDataSources")  
//    public List<DataSource> readDataSources(){
//		int size = Integer.parseInt(dataSourceSize);
//        List<DataSource> dataSources = Lists.newArrayList();
//        for (int i = 0; i < size; i++) {  
//        	dataSources.add((DataSource) SpringContextHolder.getBean("slaveDataSource" + (i + 1)));
//        } 
//        return dataSources;  
//    }
	
//    @Bean("roundRobinDataSouceProxy")
//    public AbstractRoutingDataSource roundRobinDataSouceProxy() {  
//        int size = Integer.parseInt(dataSourceSize);  
//        MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource(size);  
//        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();  
//        Object writeDataSource = SpringContextHolder.getBean("masterDataSource");  
//        // 写库
//        targetDataSources.put(DataSourceType.write.getType(), writeDataSource);  
//        // 多个读库  
//        for (int i = 0; i < size; i++) {  
//            targetDataSources.put(i, SpringContextHolder.getBean("slaveDataSource" + (i + 1)));  
//        }  
//        proxy.setDefaultTargetDataSource(writeDataSource);  
//        proxy.setTargetDataSources(targetDataSources);  
//        return proxy;  
//    } 
}

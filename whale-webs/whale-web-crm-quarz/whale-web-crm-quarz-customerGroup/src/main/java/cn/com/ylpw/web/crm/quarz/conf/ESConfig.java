package cn.com.ylpw.web.crm.quarz.conf;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
///**
// * @ClassName: ESConfig
// * @Description:
// * @author LT
// * @date 2017年4月20日 下午5:13:21
// */
//@Configuration
//public class ESConfig extends ElasticsearchAutoConfiguration {
//	private static final Logger logger = LoggerFactory.getLogger(ESConfig.class);
//	static{
//		logger.info("init property  es.set.netty.runtime.available.processors");
//		System.setProperty("es.set.netty.runtime.available.processors", "false");
//	}
//	
//	public ESConfig(ElasticsearchProperties properties) {
//		super(properties);
//	}
//	@Value("${spring.data.elasticsearch.xpack.security.user}")
//	private String  xpackSecurity ;
// 
//	@SuppressWarnings("resource")
//	@Bean
//	public TransportClient transportClient() throws Exception {
//		TransportClient tc = new PreBuiltXPackTransportClient(Settings.builder()
//			        .put("xpack.security.user", xpackSecurity)
//			        .build()) ;
//		 for (TransportAddress addresss : super.elasticsearchClient().transportAddresses()){
//			 tc.addTransportAddress(addresss) ;
//		 }
//		
//		return tc;
//	            
//	}
//	
//	
//}

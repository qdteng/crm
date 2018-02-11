package cn.com.ylpw.web.crm.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import cn.com.ylpw.core.tools.Globals;

//@Configuration
//@EnableKafka
//public class KafkaProducerConfig {
//
//	@Value("${kafka.broker.address}")
//	private String brokerAddress;
//	private static final Logger log = LoggerFactory.getLogger(KafkaProducerConfig.class);
//	@Bean
//	public ProducerFactory<String, String> producerFactory() {
//		return new DefaultKafkaProducerFactory<>(producerConfigs());
//	}
//
//	@Bean
//	public Map<String, Object> producerConfigs() {
//		Map<String, Object> props = new HashMap<>();
//		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.brokerAddress);
//		//## 消息发送失败后的重试次数  
//		props.put(ProducerConfig.RETRIES_CONFIG, 3);
//		//每次失败后的间隔时间  
//		props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 100);
//		props.put(ProducerConfig.BATCH_SIZE_CONFIG,Globals.KAFKA_BATCH_SIZE_CONFIG);
//		props.put(ProducerConfig.LINGER_MS_CONFIG, Globals.KAFKA_LINGER_MS_CONFIG);
//		props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, Globals.KAFKA_COMPRESSION_TYPE_CONFIG);
//		
//		
//		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 1024*1024*1024);
//		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, Integer.MAX_VALUE);
//		props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 60000);
//		
//		
//		props.put(ProducerConfig.SEND_BUFFER_CONFIG, 100*1024*1024);
//		String  timstr = new Date().getTime()+""; 
//		log.info("kafka producer id is: {} "  , timstr);
//		//## 用户随意指定，但是不能重复，主要用于跟踪记录消息  
//		props.put(ProducerConfig.CLIENT_ID_CONFIG, timstr);
//		props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 30 * 1000*3);
//		
//		
////		 ## 0：不保证消息的到达确认，只管发送，低延迟但是会出现消息的丢失，在某个server失败的情况下，有点像TCP  
////		 ## 1：发送消息，并会等待leader 收到确认后，一定的可靠性  
////		 ## -1：发送消息，等待leader收到确认，并进行复制操作后，才返回，最高的可靠性 
//		props.put(ProducerConfig.ACKS_CONFIG, "1");
//		
//		return props;
//	}
//
//	@Bean
//	public KafkaTemplate<String, String> kafkaTemplate() {
//		return new KafkaTemplate<String, String>(producerFactory());
//	}
//}
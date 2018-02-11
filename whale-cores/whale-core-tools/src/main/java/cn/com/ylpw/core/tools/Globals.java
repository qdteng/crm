package cn.com.ylpw.core.tools;

public class Globals {
	/**
	 * 运维可用的检测心跳的路径
	 */
	public final  static String HEALTH_PATH = "/crm/h/check";
	
	/***
	 * #Producer会尝试去把发往同一个Partition的多个Requests进行合并，batch.size指明了一次Batch合并后Requests总大小的上限。如果这个值设置的太小，可能会导致所有的Request都不进行Batch。
	 */
	public final  static Integer KAFKA_BATCH_SIZE_CONFIG =200000  ;
	
	/***
	 * #Producer默认会把两次发送时间间隔内收集到的所有Requests进行一次聚合然后再发送，以此提高吞吐量，而linger.ms则更进一步，这个参数为每次发送增加一些delay，以此来聚合更多的Message。
	 */
	public final  static Integer KAFKA_LINGER_MS_CONFIG =10  ;
	
	/***
	 * 	#Producer 默认发送不进行压缩，推荐配置一种适合的压缩算法，可以大幅度的减缓网络压力和Broker的存储压力。
	 */
	public final  static String KAFKA_COMPRESSION_TYPE_CONFIG ="lz4";
	
	
	/***
	 * 	#Producer
	 * 	//		 ## 0：不保证消息的到达确认，只管发送，低延迟但是会出现消息的丢失，在某个server失败的情况下，有点像TCP  
		//		 ## 1：发送消息，并会等待leader 收到确认后，一定的可靠性  
		//		 ## -1：发送消息，等待leader收到确认，并进行复制操作后，才返回，最高的可靠性 
	 */
	public final  static String KAFKA_ACKS_CONFIG ="1";
	
	
}

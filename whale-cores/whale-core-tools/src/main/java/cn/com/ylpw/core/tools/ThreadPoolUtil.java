package cn.com.ylpw.core.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/**
 * @ClassName: ThreadPoolUtil
 * @Description:Spring线程池
 * @author LT
 * @date 2016年7月15日 上午11:18:30
 */
public   class ThreadPoolUtil {
	
	
	//日志
//	private static final Log logger = LogFactory.getLog(ThreadPoolUtil.class);
	private static final Logger log = LoggerFactory.getLogger(ThreadPoolUtil.class);

	private  static final ThreadPoolTaskExecutor   poolTaskExecutor = new ThreadPoolTaskExecutor();
	static  {
		//线程池所使用的缓冲队列  
		poolTaskExecutor.setQueueCapacity(200);  
		//线程池维护线程的最少数量  
		poolTaskExecutor.setCorePoolSize(10);  
		//线程池维护线程的最大数量  
		poolTaskExecutor.setMaxPoolSize(100);  
		//线程池维护线程所允许的空闲时间  
		poolTaskExecutor.setKeepAliveSeconds(30000);  
		poolTaskExecutor.initialize();  
	}
	/**
	 * <p>获取当前线程池实例</p>
	 * @author LT
	 * @date 2016年7月15日 上午11:22:57
	 * @return ThreadPoolTaskExecutor
	 * @return
	 */
	public static ThreadPoolTaskExecutor getPoolTaskExecutor(){
		return poolTaskExecutor ;
	}
	
	/**
	 * <p>开始执行一个线程</p>
	 * @author LT
	 * @date 2016年7月15日 上午11:22:26
	 * @return void
	 * @param runable
	 */
	public static void execute(java.lang.Runnable runable){
		getPoolTaskExecutor().execute(runable);
		log.info("当前活动线程数：{}",poolTaskExecutor.getActiveCount());
		log.info("当前线程池数量：{}",poolTaskExecutor.getPoolSize());
		log.info("线程池维护的最大数量：{}",poolTaskExecutor.getMaxPoolSize());
	}
	
	public static void main(String[] args) {
	}
	
}


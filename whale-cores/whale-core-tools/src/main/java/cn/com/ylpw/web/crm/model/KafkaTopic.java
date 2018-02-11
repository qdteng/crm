package cn.com.ylpw.web.crm.model;

public class KafkaTopic {

	/***
	 * kafka推送的主题 用户信息 KAFKA_TOPIC_T_CUSTOMERS
	 */
	public static final  String  KAFKA_TOPIC_T_CUSTOMERS="KAFKA_TOPIC_T_CUSTOMERS" ;
	
	/***
	 * kafka推送的主题 订单信息 KAFKA_TOPIC_ORDERS
	 */
	public static final  String  KAFKA_TOPIC_ORDERS="KAFKA_TOPIC_ORDERS" ;
	
	
	/***
	 * kafka推送的主题 电子钱包信息 KAFKA_TOPIC_EWALLET
	 */
	public static final  String  KAFKA_TOPIC_EWALLET="KAFKA_TOPIC_EWALLET" ;
	
	
	/***
	 * kafka推送的主题  乐通卡消费信息 KAFKA_TOPIC_LETONGCARD_SUB
	 */
	public static final  String  KAFKA_TOPIC_LETONGCARD_SUB="KAFKA_TOPIC_LETONGCARD_SUB" ;
	
	
	/***
	 * kafka推送的主题 配送地址信息 KAFKA_TOPIC_ADDRESS
	 */
	public static final  String  KAFKA_TOPIC_ADDRESS="KAFKA_TOPIC_ADDRESS" ;
	
	
	/***
	 * kafka推送的主题 支付方式信息  KAFKA_TOPIC_PAYTYPES
	 */
	public static final  String  KAFKA_TOPIC_PAYTYPES="KAFKA_TOPIC_PAYTYPES" ;

	/**
	 *  kafka推送的主题 缺货登记信息  KAFKA_TOPIC_SHORTAGERECORD
	 */
	public static final String KAFKA_TOPIC_SHORTAGERECORD = "KAFKA_TOPIC_SHORTAGERECORD";

	/**
	 *  kafka推送的主题 意见建议  KAFKA_TOPIC_REPORT
	 */
	public static final String KAFKA_TOPIC_REPORT = "KAFKA_TOPIC_REPORT";
	
	
	/***
	 * kafka推送的主题 用户的更新信息 KAFKA_TOPIC_UPD_TCUSTOMERS
	 */
	public static final  String  KAFKA_TOPIC_UPD_TCUSTOMERS="KAFKA_TOPIC_UPD_TCUSTOMERS" ;

	
	/**
	 *  kafka推送的主题 CRM添加静态用户分组
	 */
	public static final String KAFKA_TOPIC_ADDSTATICCUSTOMERGROUP = "KAFKA_TOPIC_ADDSTATICCUSTOMERGROUP";

	/**
	 *  kafka推送的主题 CRM同步用户或订单后通知Elastic 重新计算
	 */
	public static final String KAFKA_TOPIC_SYN_ELASTIC_CUSTOMER ="KAFKA_TOPIC_SYN_ELASTIC_CUSTOMER";

	/**
	 *  kafka推送的主题 CRM同步订单后 通知计算 用户的成长值
	 */
	public static final String KAFKA_TOPIC_INDEXCOMPUTING_ORDER = "KAFKA_TOPIC_INDEXCOMPUTING_ORDER";
	
	/**
	 *  kafka推送的主题 CRM同步电子钱包充值后 通知计算 用户的成长值
	 */
	public static final String KAFKA_TOPIC_INDEXCOMPUTING_EWALLETADD = "KAFKA_TOPIC_INDEXCOMPUTING_EWALLETADD";

	/**
	 * kafka推送的主题 配送地址信息 KAFKA_TOPIC_PRODUCT
	 */
	public static final String KAFKA_TOPIC_PRODUCT = "KAFKA_TOPIC_PRODUCT";

	
	/**
	 * 	kafka推送的主题 消费激励、会员活跃 策略产生会员成长值后 需要计算相应 会员积分 KAFKA_TOPIC_ADDINTEGRAL
	 */
	public static final String KAFKA_TOPIC_ADDINTEGRAL="KAFKA_TOPIC_ADDINTEGRAL";

	/**
	 * kafka 推送至 228  投放活动信息  
	 */
	public static String KAFKA_TOPIC_228_ACTIVTY_PUTIN="KAFKA_TOPIC_228_ACTIVTY_PUTIN";

	
	/**
	 * kafka 推送至 228  触发活动信息  
	 */
	public static String KAFKA_TOPIC_228_ACTIVTY_TRIGER="KAFKA_TOPIC_228_ACTIVTY_TRIGER";

	
	/***
	 * kafka推送的主题 更新订单、支付状态
	 */
	public final  static String KAFKA_TOPIC_UPD_ORDERS="KAFKA_TOPIC_UPD_ORDERS";

	
}
